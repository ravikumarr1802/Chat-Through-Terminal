JAVA SOCKET COMMUNICATION EXAMPLE
This repository contains a Java program demonstrating socket communication between a server and client using threads for reading and writing messages.
GETTING STARTED
To run this program, follow these steps:
1. Clone the repository to your local machine.
2. Open the project in your preferred Java IDE.
3.Compile and run the Main.java file.
USAGE
Once the program is running, it will establish a server socket on port 7788. Clients can connect to this server to exchange messages.
SERVER SIDE
The server waits for incoming connections and handles communication with clients. It uses two threads: one for reading messages from clients and another for writing messages to clients.
CLIENT SIDE
Clients can connect to the server using a socket connection. They can send messages to the server, which will be displayed on the server side. Typing "exit" will close the connection.
EXAMPLE
Here's an example of how to run the program:
1. Start the server by running Main.java.
2. Start a client and connect to the server.
3. Send messages from the client to the server and vice versa.
