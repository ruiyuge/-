package 体系结构.C_S三层;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12346);
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                // 创建线程处理客户端请求
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;
        private ContactsManager contactsManager;

        public ClientHandler(Socket socket) {
            try {
                this.clientSocket = socket;
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                contactsManager = new ContactsManager();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if (inputLine.startsWith("ADD_CONTACT")) {
                        String contact = inputLine.substring(12); // 提取联系人信息
                        contactsManager.addContact(contact); // 添加联系人到通讯录
                        out.println("Contact added: " + contact); // 返回确认消息给客户端
                    } else if ("GET_CONTACTS".equals(inputLine)) {
                        String contacts = contactsManager.getAllContacts(); // 获取所有联系人
                        out.println(contacts); // 发送联系人列表给客户端
                    }
                }
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
