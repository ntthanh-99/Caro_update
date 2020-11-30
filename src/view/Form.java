/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.O;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.User;

/**
 *
 * @author Tien Thanh
 */
public class Form extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form Form
     */
    Socket s = null;
    User user = new User();
    DataOutputStream outputStream = null;
    DataInputStream inputStream = null;
    String msg = null;
    O[][] caro = null;
    boolean turn;
    int cols = 11;
    int rows = 11;
    String name;
    int u1 = 0;
    int u2 = 0;

    public Form(User user, String name) throws IOException {
        initComponents();
        this.user = user;
        this.name = name;
        lbScore.setText(user.getName() + ": " + u1 + "-" + u2 + " :" + name);
        outputStream = new DataOutputStream(user.getSocket().getOutputStream());
        inputStream = new DataInputStream(user.getSocket().getInputStream());
        setLocationRelativeTo(this);
        setTitle("Caro");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        start();
        turn = true;
        setTurn.setText("Lượt của bạn!");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCaro = new javax.swing.JPanel();
        panelChat = new javax.swing.JPanel();
        inputText = new javax.swing.JTextField();
        send = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatArea = new javax.swing.JTextArea();
        lbScore = new javax.swing.JLabel();
        setTurn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelCaroLayout = new javax.swing.GroupLayout(panelCaro);
        panelCaro.setLayout(panelCaroLayout);
        panelCaroLayout.setHorizontalGroup(
            panelCaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
        );
        panelCaroLayout.setVerticalGroup(
            panelCaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        inputText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTextActionPerformed(evt);
            }
        });

        send.setText("Send");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        chatArea.setColumns(20);
        chatArea.setRows(5);
        jScrollPane1.setViewportView(chatArea);

        javax.swing.GroupLayout panelChatLayout = new javax.swing.GroupLayout(panelChat);
        panelChat.setLayout(panelChatLayout);
        panelChatLayout.setHorizontalGroup(
            panelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelChatLayout.createSequentialGroup()
                        .addComponent(inputText, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelChatLayout.setVerticalGroup(
            panelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelChatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(send)
                    .addComponent(inputText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        lbScore.setText("-");

        setTurn.setText("setTurn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelCaro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(setTurn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(lbScore, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(panelChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbScore)
                .addGap(18, 18, 18)
                .addComponent(panelCaro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(setTurn)
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        // TODO add your handling code here:
        // Send Mesage
        String input = inputText.getText();
        if (input.equals("!trogiup")) {
            chatArea.append("admin: !thua: nhận thua; !hoa: cầu hòa");
        } else if (input.equals("!thua")) {
            try {
                outputStream.writeUTF("!thua");
                JOptionPane.showMessageDialog(rootPane, "Chờ đối thủ đồng ý");
            } catch (IOException ex) {

            }

        } else if (input.equals("!hoa")) {
            try {
                outputStream.writeUTF("!hoa");
                JOptionPane.showMessageDialog(rootPane, "Chờ đối thủ đồng ý");

            } catch (IOException ex) {

            }
        } else {
            chatArea.append("Me:" + input + "\n");
            try {
                outputStream.writeUTF(input);
            } catch (IOException ex) {
                // close window when one more out
                JOptionPane.showMessageDialog(rootPane, "Friend Exit");
                this.dispose();
            }

        }
        inputText.setText("");

    }//GEN-LAST:event_sendActionPerformed

    private void inputTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Form(new User(), new String()).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chatArea;
    private javax.swing.JTextField inputText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbScore;
    private javax.swing.JPanel panelCaro;
    private javax.swing.JPanel panelChat;
    private javax.swing.JButton send;
    private javax.swing.JLabel setTurn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
// luong nhan
        while (true) {
            try {
                String msg = inputStream.readUTF();
                if (msg != null) {
                    System.out.println(msg);
                    if (msg.charAt(0) == '!') { // lệnh đặc biệt
                        switch (msg) {
                            case "!thang": {
                                JOptionPane.showMessageDialog(rootPane, "Bạn thua!!");
                                reset();
                                u2++;
                                lbScore.setText(user.getName() + ": " + u1 + "-" + u2 + " :" + name);
                                turn = true;
                                setTurn.setText("Luợt của bạn!");

                                break;
                            }
                            case "!thua": {
                                int option = JOptionPane.showConfirmDialog(this, "Bạn có đồng ý?", "Đối thủ xin thua", JOptionPane.YES_NO_OPTION);
                                if (option == JOptionPane.YES_OPTION) {

                                    outputStream.writeUTF("!1thua");
                                    JOptionPane.showMessageDialog(rootPane, "Bạn thắng!!");
                                    reset();
                                    u1++;
                                    lbScore.setText(user.getName() + ": " + u1 + "-" + u2 + " :" + name);
                                    turn = false;
                                    setTurn.setText("Luợt đối thủ!");
                                    
                                }
                                else{
                                    outputStream.writeUTF("!0");
                                }
                                break;
                                
                            }
                            case "!hoa": {
                                int option = JOptionPane.showConfirmDialog(this, "Bạn có đồng ý?", "Đối thủ xin hòa", JOptionPane.YES_NO_OPTION);
                                if (option == JOptionPane.YES_OPTION) {

                                    outputStream.writeUTF("!1hoa");
                                    JOptionPane.showMessageDialog(rootPane, "Hòa!!");
                                    reset();
                                    turn = true;
                                    setTurn.setText("Luợt của bạn!");
                                    
                                }
                                else{
                                    outputStream.writeUTF("!0");
                                }
                                break;
                            }
                            case "!1hoa": {
                                JOptionPane.showMessageDialog(this, "Đối thủ đồng ý!!\nHòa!!");
                                reset();
                                turn = false;
                                setTurn.setText("Lượt đối thủ!");
                                break;
                            }
                            case "!0": {
                                JOptionPane.showMessageDialog(this, "Đối thủ không đồng ý!!\nChơi tiếp!!");
                                break;
                            }
                            case "!1thua": {
                                JOptionPane.showMessageDialog(this, "Đối thủ đồng ý!!\n Bạn thua!!");
                                reset();
                                u2++;
                                lbScore.setText(user.getName() + ": " + u1 + "-" + u2 + " :" + name);
                                turn = true;
                                setTurn.setText("Lượt của bạn!");
                                break;
                            }
                            
                            default:{}

                        }
                    } else if (msg.charAt(0) == '.') {
// đánh nước cờ của đối thủ 
                        String getMes = msg.substring(1);// .11-1 -> 11-1
                        String[] vitri = getMes.split("-"); //11-1 -> [11, 1]; 
                        int i = Integer.parseInt(vitri[0]);
                        int j = Integer.parseInt(vitri[1]);
                        caro[i][j].setText("O");
                        caro[i][j].setForeground(Color.blue);
                        turn = true;
                        setTurn.setText("Lượt của bạn!");
                    } else { // hiện thông tin chat
                        System.out.println(msg);
                        chatArea.append("Friend:" + msg + "\n");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                }

            } catch (IOException e) {
                
            }
        }
    }

    public void start() { // tạo bàn cờ
        caro = new O[rows][cols];
        panelCaro.setLayout(new GridLayout(rows, cols));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                caro[i][j] = new O(i, j, " ");
                caro[i][j].setPreferredSize(new Dimension(40, 40));
                caro[i][j].setBackground(Color.white);
                caro[i][j].setForeground(Color.red);

                caro[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
// ng choi danh nuoc co
                        O o = (O) e.getSource();
                        if (turn) {
                            if (o.getText().equals(" ")) {
                                int i = o.getRow();
                                int j = o.getCol();
                                caro[i][j].setText("X");
                                if (CheckCol(j, "X") || CheckRow(i, "X") || CheckLeft(i, j, "X") || CheckRight(i, j, "X")) {
                                    try {
                                        outputStream.writeUTF("!thang");
                                    } catch (IOException ex) {

                                    }
                                    JOptionPane.showMessageDialog(null, "Bạn thắng!!!");
                                    reset();
                                    u1++;
                                    lbScore.setText(user.getName() + ": " + u1 + "-" + u2 + " :" + name);
                                    turn = false;
                                    setTurn.setText("Lượt đối thủ!");
                                } else {
                                    try {
                                        outputStream.writeUTF("." + i + "-" + j);// gui nuoc co di
                                        turn = false;
                                        setTurn.setText("Lượt đối thủ!");
                                    } catch (IOException ex) {
                                        JOptionPane.showMessageDialog(rootPane, "Đối thủ thoát");
                                        dispose();
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Wrong!!");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Friend's Turn");
                        }
                    }
                });
                panelCaro.add(caro[i][j]);
            }
        }
    }

    public void reset() {
        for (int k = 0; k < rows; k++) {
            for (int l = 0; l < cols; l++) {
                caro[k][l].setText(" ");
            }
        }
    }

    public boolean CheckRow(int row, String str) {
        int dem = 0;
        for (int i = 0; i < cols; i++) {
            if (caro[row][i].getText().equals(str)) {
                dem++;
            } else {
                dem = 0;
            }

            if (dem == 5) {
                return true;

            }
        }
        return false;
    }

    public boolean CheckCol(int col, String str) {
        int dem = 0;
        for (int i = 0; i < rows; i++) {
            if (caro[i][col].getText().equals(str)) {
                dem++;
            } else {
                dem = 0;
            }

            if (dem == 5) {

                return true;
            }
        }
        return false;
    }

    public boolean CheckLeft(int row, int col, String str) {
        int dem = 0;
        while (row > 0 && col > 0) {
            row--;
            col--;
        }
        while (row < rows && col < cols) {
            if (caro[row++][col++].getText().equals(str)) {
                dem++;
            } else {
                dem = 0;
            }
            if (dem == 5) {

                return true;
            }
        }
        return false;
    }

    public boolean CheckRight(int row, int col, String str) {
        int dem = 0;
        while (row < rows - 1 && col > 0) {
            row++;
            col--;
        }
        while (row >= 0 && col < cols) {
            if (caro[row--][col++].getText().equals(str)) {
                dem++;
            } else {
                dem = 0;
            }
            if (dem == 5) {

                return true;
            }
        }
        return false;
    }
}