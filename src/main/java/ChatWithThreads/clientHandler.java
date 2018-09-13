package ChatWithThreads;

//This class is not in use.

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class clientHandler extends Thread{
    BufferedReader input ;
    PrintWriter output;
    Socket s;

    public clientHandler(Socket socket, BufferedReader in, PrintWriter out) {

        this.input = in;
        this.output = out;
        this.s = socket;

    }

    public void run() {
        String data = null;
        String inputData = null;

        try {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                //displaying received messages
                if ((data = input.readLine()) != null) {
                    System.out.println("Message From Client : " + data);
                }
                //sending messages part
                inputData = scanner.nextLine();
                output.println(inputData);
                output.flush();

            }
        } catch (/*IO*/Exception e) {
            e.printStackTrace();
        }

    }

}
