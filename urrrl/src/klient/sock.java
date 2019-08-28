package klient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class sock {
    public static void main(String[] args) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress("localhost", 8189), 2000);

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("произошло подключение к серверу");
            Scanner sc = new Scanner(System.in);
            Scanner sc1 = new Scanner(socket.getInputStream());
            boolean b = true;
            while (b) {
                StringBuilder str = new StringBuilder(sc.nextLine());
                printWriter.println(str);
                while (b) {
                    str.delete(0,str.length());
                    str.append(sc1.nextLine());

                    System.out.println(str);
                      if (!str.equals("") )
                          break;
                }
                if (str.toString().equals("exit")) {
                    b = false;
                    break;
                }

            }
            System.out.println("ты вшел с сервера");

        } catch (IOException e) {
            System.out.println("нет подключения");
        }

    }
}

