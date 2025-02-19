🔥 Java Chat Application 🚀
A real-time chat application built in Java, allowing multiple users to communicate over a network using sockets. It includes encryption (Caesar Cipher) for added security! 💬🔐

📌 Features
✅ Multi-client support – Multiple users can chat simultaneously.
✅ Graphical User Interface (GUI) – Simple and interactive chat window.
✅ Message Encryption – Uses Caesar Cipher to secure messages.
✅ Real-time Communication – Messages are sent and received instantly.
✅ Server-Client Architecture – Works on local or networked systems.

🏗 Project Structure
📂 ChatApplication/
┣ 📜 ChatServer.java → Manages connections and broadcasts messages.
┣ 📜 ClientHandler.java → Handles individual clients & encryption.
┣ 📜 ChatClient.java → GUI-based chat client for sending & receiving messages.
┗ 📜 README.md → You're reading this! 😊

🚀 How to Run the Application
🖥 Running the Server
1️⃣ Open a terminal and navigate to the project folder.
2️⃣ Compile the server:

sh
Copy
Edit
javac ChatServer.java ClientHandler.java
3️⃣ Run the server:

sh
Copy
Edit
java ChatServer
4️⃣ Server is now listening for connections! 🎧

💻 Running the Chat Client
1️⃣ Open a new terminal and navigate to the project folder.
2️⃣ Compile the client:

sh
Copy
Edit
javac ChatClient.java
3️⃣ Run the client:

sh
Copy
Edit
java ChatClient
4️⃣ Enter messages and chat in real time! 🎉

📡 Running on Different PCs (LAN Setup)
1️⃣ Find the Server’s IP:
Run the following command on the server PC:

Windows: ipconfig
Linux/macOS: ifconfig
Find your local IPv4 address (e.g., 192.168.1.2).
2️⃣ Update the Client Code:
Open ChatClient.java and change:

java
Copy
Edit
private static final String SERVER_ADDRESS = "192.168.1.2"; // Replace with your server's IP
3️⃣ Run the Server & Clients
Start the server first, then connect clients from different PCs.
🚀 Enjoy chatting! Happy coding! 😃🎉

