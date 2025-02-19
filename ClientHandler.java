import java.io.*;
import java.net.*;

public class ClientHandler extends Thread {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            ChatServer.addClient(out);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                String encryptedMessage = encrypt(message);
                ChatServer.broadcast(encryptedMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ChatServer.removeClient(out);
        }
    }

    private String encrypt(String message) {
        // Simple encryption (Caesar Cipher for demonstration)
        StringBuilder encrypted = new StringBuilder();
        for (char c : message.toCharArray()) {
            encrypted.append((char) (c + 3)); // Shift characters by 3
        }
        return encrypted.toString();
    }
}