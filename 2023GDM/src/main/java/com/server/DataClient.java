
package com.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import model.Produto;

/**
 *
 * @author deibi
 */
public class DataClient {

    private static ObjectOutputStream writer = null;
    private static ObjectInputStream is = null;
    private static Socket socket;

    public static void main(String[] args) throws IOException {

        //inicio de conexao com servidor==========
        try {
            socket = new Socket("127.0.0.1", 22168);
            writer = new ObjectOutputStream(socket.getOutputStream());

            Produto p = new Produto();
            // p.setNome("Banana Split");

            //=====mensagen enviada ao servidor=========================       
            writer.writeObject(p);
            writer.flush();

            is = new ObjectInputStream(socket.getInputStream());

            //mensagen vinda do servidor
            System.out.println(is.readObject());

            is.close();
            writer.close();
        } catch (ClassNotFoundException | IOException e) {
        } finally {
            socket.close();
        }

    }

}
