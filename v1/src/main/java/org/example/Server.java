package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("SERVER STARTED..!");

        Socket socket = serverSocket.accept();
        System.out.println("CLIENT CONNECTED..! \n");

        //READ CLIENT MESSAGE
        String message;
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        message = inputStream.readUTF();
        System.out.println(message);

        //SERVER SEND MESSAGE
        System.out.print("MASSAGE : ");
        String serverMessage = new Scanner(System.in).nextLine();
        System.out.println();
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        outputStream.writeUTF("SERVER : " + serverMessage);
        outputStream.flush(); //SEND

        socket.close();
    }
}