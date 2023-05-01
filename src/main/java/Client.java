import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 8090;
        try (Socket clientSocket = new Socket(host, port)){
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            Scanner scanner = new Scanner(System.in);
            Scanner sc = new Scanner(clientSocket.getInputStream());
            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
            System.out.println("Hi there, what is your name?");
            String name = sc.nextLine();
            out.println(name);
            System.out.println("Are you a child?");
            System.out.println("Enter yes/no");
            String age = sc.nextLine();
            out.println(age);

            String serverResponse = in.readLine();

        }
    }
}
