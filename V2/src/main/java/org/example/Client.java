package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",5000);

        String message = "";
        while (!message.equals("stop")){
            //CLIENT SENT MESSAGE FIRST
            System.out.print("YOU : ");
            message = new Scanner(System.in).nextLine();
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF(message);
            outputStream.flush();

            //READ THE CLIENT MESSAGE
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            System.out.println(dataInputStream.readUTF());
        }

        socket.close();
    }
}
