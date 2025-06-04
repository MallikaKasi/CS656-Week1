/***********************************************************
 * Group Name:  CharmKit      CS 656-850, Summer 2025
 *
 * Group Members:
 *   Louis (nl338)
 *   Victor (bv274)
 *   Kasi (mk2434)
 *   Hutchinson (lp399)
 *   Chang (hchang12)
 *   Cunningham (ac2888)
 *
 * Assignment:        Module 2: The Adventure of Echo Server
 * Date:              06/08/2025
 ***********************************************************/


import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);

        try (
                ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                // out.println(inputLine);
                System.out.println("Received: " + inputLine);
                // Added Code to convert the recevied Messages to Uppercase
                String uppercased = inputLine.toUpperCase();
                out.println(uppercased);

            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}