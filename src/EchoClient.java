import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try {
            System.out.println("Приветствуем в чате!");
            Socket socket = new Socket("localhost", 8189);
            System.out.println("Произошёл троллинг");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Thread gett = new Thread(() -> {
                while (true) {
                    try {
                        String inp = scanner.nextLine();
                        out.writeUTF(inp);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread trow = new Thread(() -> {
                while (true) {
                    try {
                        String str = in.readUTF();
                        if (str.equals("/end")) {
                            gett.stop();
                            out.writeUTF("/end");
                            socket.close();
                            break;
                        }
                        //out.writeUTF("Эхо: " + str);
                        System.out.println(str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            gett.start();
            trow.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}