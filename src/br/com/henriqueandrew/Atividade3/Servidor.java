//Henrique Andrew da Silva
package br.com.henriqueandrew.Atividade3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private static Socket conexao;
    private static ServerSocket server;
    private static ObjectInputStream entrada;
    private static ObjectOutputStream saida;

    public static void main(String[] args) {

        try {

            server = new ServerSocket(20000);
            conexao = server.accept();
            entrada = new ObjectInputStream(conexao.getInputStream());
            Pessoa p = (Pessoa) entrada.readObject();
            if (p != null) {
                saida = new ObjectOutputStream(conexao.getOutputStream());
                saida.writeObject(p);
                System.out.println("Servidor retornou cadastro!");
            }
            conexao.close();
        } catch (Exception e) {

        }
    }
}
