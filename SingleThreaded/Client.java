package SingleThreaded;

import java.net.UnknownHostException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public void run() throws UnknownHostException , IOException{
        int port = 8010;
        InetAddress address = InetAddress.getByName("localhost");
        Socket clientSocket = new Socket(address, port);
        PrintWriter toSocket = new PrintWriter(clientSocket.getOutputStream());
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        toSocket.println("Hello from the client");
        String line = fromServer.readLine();
        System.out.println("Received from server: " + line);
        toSocket.close();
        fromServer.close();
        clientSocket.close();
    }
    
    public static void main(String[] args) {
        try{
            Client client = new Client();
            client.run();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
