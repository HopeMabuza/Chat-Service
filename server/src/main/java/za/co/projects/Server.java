package za.co.projects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serversocket;
    private Socket clientSocket;
    private PrintWriter out;//writes output to client
    private BufferedReader in;//reads input from client

    public void start(int port) throws IOException {
        serversocket = new ServerSocket(port);
        clientSocket = serversocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String greeting = in.readLine();
        if ("hello server".equals(greeting)){
            out.println("hello client");
            System.out.println("Successfully connected!");
        } else {
            out.print("unrecognised greeting");
            System.out.println("Invalid request");
        }
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serversocket.close();

    }
}
