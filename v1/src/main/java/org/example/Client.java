package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);

        //FIRST CLIENT SEND MESSAGE
        System.out.print("YOU : " );
        String message = new Scanner(System.in).nextLine();
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        outputStream.writeUTF("CLIENT : " + message);
        outputStream.flush(); //SEND

        //READ SERVER MESSAGE
        String serverMessage;
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        serverMessage = inputStream.readUTF();
        System.out.println(serverMessage);

        socket.close();
    }
}
