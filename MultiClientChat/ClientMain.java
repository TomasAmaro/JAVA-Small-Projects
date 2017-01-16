package org.academiadecodigo.chat;

import java.io.IOException;

/**
 * Created by codecadet on 12/11/16.
 */
public class ClientMain {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.start();

    }
}
