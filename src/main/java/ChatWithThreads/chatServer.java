package ChatWithThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class chatServer
{
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(55000);

        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());

                serverPrintWrite s1 = new serverPrintWrite(socket,out);
                s1.start();
                serverBufferReader s2 = new serverBufferReader(socket,in);
                s2.start();
            }catch (Exception e) {
                socket.close();
                System.out.println("exception on server");
                e.printStackTrace();
            }
        }
    }
}
