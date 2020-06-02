import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Main {
    public static Random rand = new Random();
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        EchoServer.main(args);
        EchoClient.main(args);
    }
}

