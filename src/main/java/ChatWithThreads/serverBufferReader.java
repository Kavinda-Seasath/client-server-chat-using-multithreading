package ChatWithThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class serverBufferReader extends Thread{

    private Thread h;
    Socket socket;
    BufferedReader in;
    String data;

    serverBufferReader(Socket socket, BufferedReader in){
        this.socket = socket;
        this.in = in;
    }

    public void run(){

        while (true){
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
        if (h == null) {
            h = new Thread(this);
            h.start();
        }
    }


}
