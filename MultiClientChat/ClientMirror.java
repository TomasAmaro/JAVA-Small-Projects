package org.academiadecodigo.chat;

import java.io.*;
import java.net.Socket;

/**
 * Created by codecadet on 11/11/16.
 */

class ClientMirror implements Runnable {

    private boolean connected = true;
    private ChatServer server;
    private Socket socket;

    private BufferedReader in;
    private DataOutputStream out;


    ClientMirror(ChatServer server, Socket socket) throws IOException {
        this.server = server;
        this.socket = socket;
    }

    @Override
    public void run() {
        while (connected) {


            try {

                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new DataOutputStream(socket.getOutputStream());
                String message = in.readLine();

                if(message == null){
                    break;
                }

                server.sendAll(message);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void sendMessage(String message) throws IOException {
        out.write(message.getBytes());
        out.write("\n".getBytes());
        out.flush();
    }


    public void setConnected(Boolean connected) {
        this.connected = connected;
    }
}
