package ChatWithThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class clientBufferReader extends Thread {

    private Thread t;
    Socket socket;
    BufferedReader in;
    String data;

    clientBufferReader(Socket socket, BufferedReader in){
        this.socket = socket;
        this.in = in;
    }

    public void run(){

        while (true){
            /*try {
                System.out.println("BufferReader Thread is Running");
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            try {
                if ((data = in.readLine()) != null) {
                    System.out.println("Message From Server : " + data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this);
            t.start();
        }
    }

}
