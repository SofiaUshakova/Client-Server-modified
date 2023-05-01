import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        int port = 8090;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                {
                    System.out.printf("New connection accepted");

                    Scanner sc = new Scanner(clientSocket.getInputStream());
                    PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());

                    final String name = in.readLine();
                    final String age = in.readLine();

                    if (age.equals("yes")) {
                        out.println("Welcome to the adult zone, " + name + " Have a good rest, or a good working day!");
                    } else {
                        out.println("Welcome to the kids area, " + name + "! Let's play!");
                    }

                }

            }

        }
    }
}
