package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("SERVER STARTED...!");

        Socket socket = serverSocket.accept();
        System.out.println("CLIENT CONNECTED...! \n");

        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        String clientMessage = "";
        String serverMessage = "";

        while (!clientMessage.equals("stop")){
            //READ CLIENT MESSAGE
            clientMessage = inputStream.readUTF();
            System.out.println("CLIENT : " +  clientMessage);

            //SENT MESSAGE FROM SERVER
            if(clientMessage.equals("stop")){
                System.out.print("MESSAGE : STOPPED");
            }else{
                System.out.print("MESSAGE : ");
                serverMessage = new Scanner(System.in).nextLine();
            }
            outputStream.writeUTF("SERVER : " + serverMessage);
            outputStream.flush();
        }

//        socket.close();
    }
}
