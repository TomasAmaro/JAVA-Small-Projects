package org.academiadecodigo.chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by codecadet on 11/11/16.
 */
public class Client {

    private String host = "";
    private int port = 0;
    private Socket clientSocket;
    boolean connected = true;


    public void start() throws IOException {

        Scanner scannerkeyboard = new Scanner(System.in);

        System.out.println("Connect to a host:");
        host = scannerkeyboard.nextLine();

        System.out.println("Port Number:");
        port = Integer.parseInt(scannerkeyboard.nextLine());

        clientSocket = new Socket(host, port);

        OutputStream out = new DataOutputStream(clientSocket.getOutputStream());

        Thread listener = new Thread(new ClientListener());
        listener.start();

        while (connected) {

            try {
                String message = scannerkeyboard.nextLine();
                out.write(message.getBytes());
                out.write("\n".getBytes());
                out.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }




    }

    private class ClientListener implements Runnable {


        @Override
        public void run() {

            boolean connected = true;
            while (connected) {
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String message = in.readLine();
                    System.out.println(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }
}
