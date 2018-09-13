package ChatWithThreads;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class serverPrintWrite extends Thread {
    private Thread t;
    Socket socket;
    PrintWriter out;
    String input;

    serverPrintWrite(Socket s,PrintWriter out) {
        this.socket = s;
        this.out = out;

    }

    public void run () {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            input = scanner.nextLine();
            out.println(input);
            out.flush();
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this);
            t.start();
        }
    }
}
