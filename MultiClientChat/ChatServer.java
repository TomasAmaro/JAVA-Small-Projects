package org.academiadecodigo.chat;

import com.sun.xml.internal.bind.v2.TODO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by codecadet on 11/11/16.
 */
public class ChatServer {

   private static Queue<ClientMirror> queue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) throws IOException {

        ChatServer chatServer = new ChatServer();
        chatServer.run();


    }

    public void run() throws IOException {

        int limit = 10;
        ServerSocket serverSocket = new ServerSocket(4040);
        Socket clientSocket;
        boolean connected = true;

        while (connected) {
            clientSocket = serverSocket.accept();
            ClientMirror clientMirror = new ClientMirror(this,clientSocket);
            Thread client = new Thread(clientMirror);
            queue.add(clientMirror);
            client.start();
        }
    }


    public synchronized void sendAll(String message) throws IOException {

        for (ClientMirror clientMirror : queue) {
            clientMirror.sendMessage(message + "\n");
        }
}


}

