package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class serv {
    static int countOfThread=0;
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            ExecutorService executorService = Executors.newFixedThreadPool(10);

            while (true) {
                if(serv.countOfThread==300){
                    System.out.println("Сервер перегружен");
                    break;
                }
                Socket socket = serverSocket.accept();
                executorService.submit(new Thread(new ServerThread(socket)));
                serv.countOfThread++;
               // executorService.shutdown();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class ServerThread extends Thread {
    Socket socket;



    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Клиент подключился, поток номер "+Thread.currentThread().getName()+" создан");
        Scanner scanner = null;
        try {
            scanner = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str;
        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            System.out.println(str);
            printWriter.println("ты скалал ".concat(str));
            if (str.equals("exit")) {
                serv.countOfThread--;
                break;
            }
        }
        System.out.println("клиент отключился");
    }
}