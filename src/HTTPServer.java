import java.io.*;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

public class HTTPServer {

    private final int PORT = 8080;
    private ServerSocket serverSocket;
    private Socket clientside;


    public HTTPServer() {
        try {
            this.serverSocket = new ServerSocket(PORT);

        } catch (IOException e) {
            System.out.println("ERROR // HTTPServer Constructor: " + e.getMessage());;
        }
    }

    public void startServer() {
        while (true){
            acceptAccess();
            getBrowserResponse();
            responseToBrowser();
            closeSocket();
        }
    }

    private void acceptAccess() {
        try {
            clientside = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("ERROR // acceptAccess method - " + e.getMessage());;
        }
    }

    private void getBrowserResponse(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientside.getInputStream()));

            String line;

            while (((line = in.readLine()) != null))
                System.out.println(line);

        } catch (IOException e) {
            System.out.println("ERROR // getBrowserResponse method: " + e.getMessage());;
        }
    }

    private void responseToBrowser(){
        try{
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientside.getOutputStream()));

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }

        } catch (IOException e) {
            System.out.println("ERROR// responseToBrowser method:" + e.getMessage());;
        }
    }

    private void closeSocket(){
        try {
            clientside.close();
        } catch (IOException e) {
            System.out.println("Error: Client Socket not closing!");;
        }

    }
}

