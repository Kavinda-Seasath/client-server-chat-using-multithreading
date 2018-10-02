package ChatWithThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class chatClient {


    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost";
        int port = 55000;
        String input;
        String data = null;

        try {

            Socket clientSocket = new Socket(serverAddress, port);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());

            //Scanner scanner = new Scanner(System.in);

            clientBufferReader readServerinput = new clientBufferReader(clientSocket,in);
            readServerinput.start();

            clientPrintWriter sendClientinput = new clientPrintWriter(clientSocket,out);
            sendClientinput.start();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
