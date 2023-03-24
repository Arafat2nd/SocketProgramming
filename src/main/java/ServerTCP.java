import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    public static void main(String[] args) throws Exception {
        String carId;
        String carInfo;
        ServerSocket welcomeSocket = new ServerSocket(6969);


        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient =
                    new BufferedReader(new
                            InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient =
                    new DataOutputStream(connectionSocket.getOutputStream());
            carId = inFromClient.readLine();
            carInfo = JsonReader.readJson(carId) + '\n';
            outToClient.writeBytes(carInfo);
        }
    }

}
