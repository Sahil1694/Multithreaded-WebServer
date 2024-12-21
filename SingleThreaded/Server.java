package SingleThreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


class Server {

    public void run() throws IOException {
        int port = 8010;
        ServerSocket serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
        while (true) {
            try{
             System.out.println("Server is listening on port " + port);
             Socket acceptedConnection = serverSocket.accept();
             System.out.println("Accepted connection from " + acceptedConnection.getRemoteSocketAddress());
             PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
             BufferedReader fromClient = new BufferedReader(new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream())));
             toClient.println("Hello From the Server");
             toClient.close();
                fromClient.close();
                acceptedConnection.close();

            }catch (IOException e){
                e.printStackTrace();
            }
            
            
        }


    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        
    }   
 }
}