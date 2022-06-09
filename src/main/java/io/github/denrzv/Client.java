package io.github.denrzv;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter your Name for server...");
            String msg = scanner.nextLine();
            out.println(msg);
            System.out.println("SERVER: " + in.readLine());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
