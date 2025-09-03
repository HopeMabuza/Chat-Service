package za.co.projects;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.startConnection("localhost", 6666);
        String response = client.sendMessage("hello server");
        System.out.println("Server responded: " + response);
        client.stopConnection();
    }
}