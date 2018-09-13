package ChatWithThreads;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class clientPrintWriter extends Thread{

    private Thread h;
    private Socket socket;
    private PrintWriter out;
    String input;


    clientPrintWriter(Socket s,PrintWriter p) {
        this.socket = s;
        this.out = p;
    }

    public void run () {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            input = scanner.nextLine();
            out.println(input);
            out.flush();
            /*try {
            System.out.println("in Printwriter Threrad");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }

    public void start() {
        if (h == null) {
            h = new Thread(this);
            h.start();
        }
    }

}
