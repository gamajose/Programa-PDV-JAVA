package com.server;


//ESTA CLASSE É DE UM SIMPLES SERVIDOR QUE AO SER INICIADO
//FICA ATIVO E RECEBE DADOS ENVIADO PELA CLASSE DataCliente.java (Cliente Fake)

//ISSO PODE SER ÚTIL PARA IMPLEMENTAR A FUCIONALIDADE DE CONEXÃO VIA REDE LOCAL
//PARA COMPARTILHAMENTO DE DADOS ENTRE MAQUINAS

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 22168;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Servidor rodando..");
        } catch (IOException e) {
            System.out.println("Erro Servidor não esta em execução..");
        }

        while (true) {
            try {
                socket = serverSocket.accept();

                //leitura da mensagem enviada do cliente
                ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());
                System.out.println("Dados do Objeto recebido no Servidor:");
                System.out.println(reader.readObject());

                //resposta para o cliente
                ObjectOutputStream respostaCliente = new ObjectOutputStream(socket.getOutputStream());
                //  Produto retorno = new ProdutoDao().getByCodigo(8L);
                // respostaCliente.writeObject(retorno);

            } catch (ClassNotFoundException | IOException e) {
                System.out.println("I/O error: " + e);
            }
            // new thread for a client
            new EchoThread(socket).start();
        }

    }

}
