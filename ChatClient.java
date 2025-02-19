import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;
    private Socket socket;
    private PrintWriter out;

    private JFrame frame;
    private JTextArea textArea;
    private JTextField textField;

    public ChatClient() {
        frame = new JFrame("Chat Client");
        textArea = new JTextArea(20, 50);
        textField = new JTextField(50);

        textArea.setEditable(false);
        frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.getContentPane().add(textField, BorderLayout.SOUTH);

        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        connectToServer();
    }

    private void connectToServer() {
        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            out = new PrintWriter(socket.getOutputStream(), true);
            new Thread(new IncomingMessageHandler(socket)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        String message = textField.getText();
        if (!message.isEmpty()) {
            out.println(message);
            textField.setText("");
        }
    }

    private class IncomingMessageHandler implements Runnable {
        private BufferedReader in;

        public IncomingMessageHandler(Socket socket) {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    String decryptedMessage = decrypt(message);
                    textArea.append(decryptedMessage + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }
    }

    private String decrypt(String message) {
        // Simple decryption (Caesar Cipher for demonstration)
        StringBuilder decrypted = new StringBuilder();
        for (char c : message.toCharArray()) {
            decrypted.append((char) (c - 3)); // Shift characters back by 3
        }
        return decrypted.toString();
    }

    public static void main(String[] args) {
        new ChatClient();
    }
}