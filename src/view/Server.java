/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author Tien Thanh
 */
public class Server {
    // tạo môi trường kêt nối giữa các client với nhau: với 2 chức năng
    // - Ghép ngẫu nhiên: 2 Client kết nối vs Server gần nhau thì ghép với nhau
    //                    ai đến trước thì làm server
    // - Phòng-Bàn: Phòng chưa có ai -> tạo ServerSocket, Phòng có 1 người -> kết nối
    //              Phòng có 2 người thì k cho vào
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1107);
        DataOutputStream outputStream = null;
        DataInputStream inputStream = null;
        String request;
        String response;
        String action; // Hành động của client
        int ban; // Bàn: 0-8
        String ip;
        String name;
        String[] temp; // 2 biến tạm giúp xử lí chuỗi
        String[] temp2;
        // DS Client ghép ngẫu nhiên
        ArrayList<User> listGhepUser = new ArrayList<User>();
        // DS Phòng-Bàn
        ArrayList<ArrayList<User>> listBanchoi = new ArrayList< ArrayList<User>>();
        // Khởi tạo DS bàn
        for (int i = 0; i < 9; i++) {
            ArrayList<User> a = new ArrayList<>();
            listBanchoi.add(a);
        }
        while (true) { // Hứng hành động của Client
            Socket server = serverSocket.accept();
            if (server != null) {
                System.out.println("New Client!");
                User user = new User();
                outputStream = new DataOutputStream(server.getOutputStream());
                inputStream = new DataInputStream(server.getInputStream());
                // Lấy địa chỉ IP của Client
                InetSocketAddress socketAddress = (InetSocketAddress) server.getRemoteSocketAddress();
                temp = socketAddress.toString().split(":");
                temp2 = temp[0].split("/");
                ip = temp2[1];
                System.out.println(ip);
                user.setIp(ip);
                //

                request = inputStream.readUTF();
                System.out.println("Yeu cau: " + request);
                temp = request.split("-");
                action = temp[0];
                System.out.println(action);
                name = temp[1];
                user.setName(name);
                // xử lí việc ghép
                if (action.equals("ghep")) {

                    listGhepUser.add(user);
                    if (listGhepUser.size() == 1) {// tao server
                        response = "CreateServer";
                        System.out.println("Phan hoi: " + response);
                        outputStream.writeUTF(response);
                    }
                    if (listGhepUser.size() >= 2) {
                        //connect to server
                        response = "Conect-" + listGhepUser.get(0).getIp() + "-" + listGhepUser.get(0).getName();
                        System.out.println("Phan hoi: " + response);
                        outputStream.writeUTF(response);
                        listGhepUser.clear();
                    }
                } else {// Xử lí việc vào bàn
                    //Gửi DS bàn hiện tại cho Client
                    response = "";
                    for (int i = 0; i < 9; i++) {
                        if (i == 0) {
                            response = response + listBanchoi.get(i).size();
                        } else {
                            response = response + "-" + listBanchoi.get(i).size();
                        }
                    }
                    System.out.println(response);
                    outputStream.writeUTF(response);

                    //Xử lí yêu cầu là tạo bàn hay kết nối
                    request = inputStream.readUTF();
                    System.out.println(request);
                    temp = request.split("-");
                    action = temp[0];

                    ban = Integer.parseInt(temp[1]);
                    if (action.equals("taoban")) {
                        // tạo bàn: thêm User vào DS bàn
                        listBanchoi.get(ban).add(user);
                    } else {
                        // kết nối: gửi địa chỉ - tên của chủ phòng
                        String rep = "Conect-" + listBanchoi.get(ban).get(0).getIp() + "-" + listBanchoi.get(ban).get(0).getName();
                        outputStream.writeUTF(rep);
                        listBanchoi.get(ban).add(user);
                    }
                }

            }
        }
    }
}
