import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        ServerSocket serverSocket;
        Socket clientside;
        BufferedReader in = null;
        BufferedWriter out = null;
        
        try {
            serverSocket = new ServerSocket(8080);
            clientside = serverSocket.accept();
            System.out.println("Someone entered your server!!!");

            in = new BufferedReader(new InputStreamReader(clientside.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientside.getOutputStream()));

            String line;
            while ((line = in.readLine()) != null){
                System.out.println(line);
            }

            in.close();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}