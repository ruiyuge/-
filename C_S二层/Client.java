import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345); // 连接到本地服务器的12345端口
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = userInput.readLine()) != null) {
                out.println(inputLine); // 将用户输入发送到服务器

                if ("GET_CONTACTS".equals(inputLine)) {
                    String response = in.readLine(); // 从服务器接收联系人列表
                    System.out.println("Contacts: " + response);
                } else if (inputLine.startsWith("ADD_CONTACT")) {
                    String response = in.readLine(); // 从服务器接收添加联系人的响应
                    System.out.println("Server response: " + response);
                }
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
