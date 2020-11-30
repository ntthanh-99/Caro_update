/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.O;
import model.User;

/**
 *
 * @author Tien Thanh
 */
public class Table extends javax.swing.JFrame {

    /**
     * Creates new form Table
     */
    Socket s = null;
    ServerSocket server=null;
    User user=null;
    String request;
    String response;
    String list;
    String[] temp;
    DataOutputStream outputStream = null;
    DataInputStream inputStream = null;
    String name;
    O[][] ban;
    boolean isConnect;

    public Table(User user, String list) {
        initComponents();
        this.user=user;
        this.list=list;
        temp = list.split("-"); //0-8
        ban = new O[3][3];
        jPanel1.setLayout(new GridLayout(3, 3,40,40));
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ban[i][j] = new O(i, j, temp[count++]);
                ban[i][j].setPreferredSize(new Dimension(80, 80));
                ban[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            //Vao ban
                            O b = (O) e.getSource();
                            outputStream = new DataOutputStream(user.getSocket().getOutputStream());
                            inputStream = new DataInputStream(user.getSocket().getInputStream());

                            if (b.getText().equals("0")) {
                                //tao server
                                try {
                                    server = new ServerSocket(1109);
                                    JOptionPane.showMessageDialog(rootPane, "Đã tạo phòng\nVui lòng chờ người chơi khác!");
                                    // tao ban
                                    int i=b.getRow();
                                    int j=b.getCol();
                                    int l=3*i + j;
                                    request="taoban-"+l;
                                    outputStream.writeUTF(request);
                                    
        System.out.println("Gui cho server: "+request);
                                    while (true) {
                                        Socket s1 = server.accept();
                                        
                                        if (s1 != null) {
                                            user.setSocket(s1);
                                            inputStream= new DataInputStream(s.getInputStream());
                                            String name=inputStream.readUTF();
                                            JOptionPane.showMessageDialog(rootPane, "Ghép thành công");
                                            Form ui = new Form(user,name);
                                            ui.setVisible(true);
                                            Thread t1 = new Thread(ui);
                                            t1.start();
                                            isConnect = true;
                                        }
                                        if (isConnect == true) {
                                            break;
                                        }
                                    }
                                    }catch (IOException ex) {
                                    System.out.println(ex.getMessage());
                                }
                                }else {
                                if (b.getText().equals("1")) {
                                    int i = b.getRow();
                                    int j = b.getCol();
                                    int l = 3 * i + j;
                                    request= "connect-" + l;
 System.out.println("Yeu cau: "+request);
                                    outputStream.writeUTF(request);
                                    response = inputStream.readUTF();
System.out.println("Phan hoi:"+request);
                                    temp = response.split("-");
                                    String ip = temp[1];
                                   
                                    String name2 = temp[2];
                                    
                                    try {
                                        Socket s1 = new Socket(ip, 1109);
                                        user.setSocket(s1);
                                        String myName=user.getName();
                                        outputStream=new DataOutputStream(s1.getOutputStream());
                                        outputStream.writeUTF(myName);
                                        JOptionPane.showMessageDialog(rootPane, "Ghép thành công");
                                        Form ui = new Form(user,name2);
                                        ui.setVisible(true);
                                        Thread t = new Thread(ui);
                                        t.start();

                                    } catch (IOException ex) {
                                        System.out.println(ex.getMessage());
                                    }
                                } else {
                                    // thong bao loi
                                    JOptionPane.showMessageDialog(rootPane, "Bàn đã đủ người!");
                                }
                            }
                            }catch (IOException ex) {
                            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }
                    }

                    );
                    jPanel1.add (ban[i][j]);
            }
        }
    }

    

    private Table() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbText = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbText.setText("Xin chào:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lbText))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbText)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Table.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Table.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Table.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Table.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Table().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbText;
    // End of variables declaration//GEN-END:variables
}
