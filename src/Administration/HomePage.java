/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jacque
 */
public class HomePage extends javax.swing.JFrame {

    public static DefaultTableModel jade = new DefaultTableModel();
    public static DefaultListModel jinx = new DefaultListModel();

    Connection con = null;
    PreparedStatement pst = null;
    java.sql.ResultSet u = null;

    public HomePage() {
        initComponents();

        String url = "jdbc:postgresql://localhost/Demi";
        String user = "postgres";
        String password = "titanium8";

        try {

            Class.forName("org.postgresql.Driver").newInstance();
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            Logger lgr = Logger.getLogger(AddStudent.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
        jButton1.setToolTipText("New Student");
        jButton2.setToolTipText("New Employee");
        jButton3.setToolTipText("New Message");
        jButton4.setToolTipText("Edit");
        jButton5.setToolTipText("Search");
        jButton6.setToolTipText("Delete");
        jButton7.setToolTipText("Refresh");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 33, 55));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setToolTipText("");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ssenterprise/Add-New-48.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ssenterprise/Data-Add-48.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setForeground(new java.awt.Color(255, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ssenterprise/Export-48.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ssenterprise/Search-48.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ssenterprise/Folders-OS-Configure-Metro-icon.png"))); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        jLabel4.setText("GIS AdminSys ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "applications", "servers" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setForeground(new java.awt.Color(255, 0, 0));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ssenterprise/Document-Edit-48.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setForeground(new java.awt.Color(255, 0, 0));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ssenterprise/Data-Import-48.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ssenterprise/Document-Delete-02-48(1).png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton8.setText("Exit");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTable1.setModel(jade);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(266, 266, 266))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(138, 138, 138)
                                .addComponent(jButton8)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButton8)))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        RemoveSelectedData(jTable1);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:

        String category = (jComboBox1.getSelectedItem().toString()).trim();
        ResultSet u;
        String q1 = null;
        try {
            java.sql.Statement s = con.createStatement();
            if (category.equals("applications")) {
                q1 = "SELECT appName,datedeployed,liveservername,liveserveraddress,remarks,contingencyplans,refId,appversion,apptype,developertype,developerName,hostservertype FROM  applications";
            } else {
                q1 = "SELECT * FROM servers";
            }
            u = s.executeQuery(q1);
            //  int numRows = HomePage.jade.getRowCount();
            this.buildTableModel(u);
            this.jTable1.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.getSelectedData(jTable1);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String category = (jComboBox1.getSelectedItem().toString()).trim();
        String query = jTextField1.getText();
        ResultSet rs;
        jinx.clear();
        try {
            java.sql.Statement s = con.createStatement();
            if (category.equalsIgnoreCase("applications")) {
                rs = s.executeQuery("Select * from applications where appname  like '%" + query + "%'");
            } else {
                rs = s.executeQuery("Select * from servers where server_name like '%" + query + "%'");
            }

            this.buildTableModel(rs);
            this.jTable1.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Search newQuery = new Search();
        //newQuery.jList1.setModel(jinx);
        //newQuery.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    @SuppressWarnings("related to input file ")
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int fileNo = 0;
        ResultSet u = null;
        ResultSet r = null;

        try {
            java.sql.Statement s = con.createStatement();
            java.sql.Statement x = con.createStatement();
            String q1 = "SELECT appName,datedeployed,liveservername,liveserveraddress,remarks,contingencyplans,refId,appversion,apptype,developertype,developer_name,hostservertype FROM applications,developers where applications.developerName=developers.developer_Name";
            String q2 = "Select server_name,server_address,back_up_server,back_up_server_address,bcc_server,bcc_server_address,remarks,contingency_plans,reference_id,server_type,virtual,host_server_address,set_up_date from servers";
            u = s.executeQuery(q1);
            r = x.executeQuery(q2);
            int i = 1;
            File mozi = new File("reports/ApplicationReport" + fileNo + ".txt");
            File mozi2 = new File("reports/ServerReport" + fileNo + ".txt");
            while (mozi.exists() && mozi2.exists()) {
                fileNo++;
                mozi = new File("reports/ApplicationReport" + fileNo + ".txt");
                mozi2 = new File("reports/ServerReport" + fileNo + ".txt");
            }

            PrintWriter writer = new PrintWriter(mozi);
            writer.println("Application Name\tDate Deployed\tApplication Version\tLive Server Name\tlive Server Address\tremarks\tContingency Plans\tReference ID\tApp Type\tDeveloper Type\tDeveloper Name\tHost Server Type");

            while (u.next()) {
                writer.print(u.getString("appName") + "\t");
                writer.print(u.getString("dateDeployed") + "\t");
                writer.print(u.getString("appVersion") + "\t");
                writer.print(u.getString("liveServerName") + "\t");
                writer.print(u.getString("liveServerAddress") + "\t");
                writer.print(u.getString("remarks") + "\t");
                writer.print(u.getString("contingencyPlans") + "\t");
                writer.print(u.getString("refID") + "\t");
                writer.print(u.getString("appType") + "\t");
                writer.print(u.getString("developerType") + "\t");
                writer.print(u.getString("developer_Name") + "\t");
                writer.print(u.getString("hostServerType") + "\t");
                writer.print("\n");
            }

            PrintWriter writer2 = new PrintWriter(mozi2);
            writer2.println("Select server_name\tserver_address\tback_up_server\tback_up_server_address\tbcc_server\tbcc_address\tremarks\tcontingency_plans\treference_id\tserver_type\tvirtual\thost_server_address\tset_up_date\t");

            while (r.next()) {
                writer2.print(r.getString("server_name") + "\t");
                writer2.print(r.getString("server_address") + "\t");
                writer2.print(r.getString("back_up_server") + "\t");
                writer2.print(r.getString("back_up_server_address") + "\t");
                writer2.print(r.getString("bcc_server") + "\t");
                writer2.print(r.getString("bcc_server_address") + "\t");
                writer2.print(r.getString("remarks") + "\t");
                writer2.print(r.getString("contingency_Plans") + "\t");
                writer2.print(r.getString("server_type") + "\t");
                writer2.print(r.getString("virtual") + "\t");
                writer2.print(r.getString("host_server_address") + "\t");
                writer2.print(r.getString("set_up_date") + "\t");

                writer2.print("\n");

            }

            writer.close();
            writer2.close();
            System.out.println("saved");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AddStudent newServer = new AddStudent();
        newServer.setVisible(true);
        ResultSet re;
        try {

            java.sql.Statement s = con.createStatement();
            String q1 = "select * FROM servers";
            re = s.executeQuery(q1);
            this.buildTableModel(re);
            this.jTable1.setVisible(true);
        } catch (SQLException x) {
            x.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        EditStudent newApp = new EditStudent();
        newApp.setVisible(true);
        ResultSet re;
        try {

            java.sql.Statement s = con.createStatement();
            String q1 = "select * FROM servers";
            re = s.executeQuery(q1);
            this.buildTableModel(re);
            this.jTable1.setVisible(true);
        } catch (SQLException x) {
            x.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        Vector<String> columnNames = new Vector<String>();

        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));

        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));

            }
            data.add(vector);
        }
        if ((columnNames.get(0)).equalsIgnoreCase("appName")) {
            columnNames.clear();
            String[] newColNames = {"Application Name", "Date Deployed", "Server Name", "Server Address", "Remarks", "Contingency Plans", "Application ID", "Version", "Application Type", "Developer Type", "Developer Name", "Host Server Address"};
            for (int column = 0; column < 12; column++) {
                columnNames.add(newColNames[column]);

            }
        }
        DefaultTableModel xf = new DefaultTableModel(data, columnNames);
        jade = xf;
        jTable1.setModel(jade);

    }

    public void RemoveSelectedData(JTable table) {
        // Get the selected row from the table.
        int selectedRow = table.getSelectedRow();
        ResultSet rt = null;
        ResultSet re = null;
        if (jade.getColumnName(0).equalsIgnoreCase("application Name")) {;
            try {
                int refID = (int) table.getValueAt(selectedRow, 6);
                java.sql.Statement s = con.createStatement();
                String q1 = "delete FROM applications where refId = " + refID + " ";
                s.executeUpdate(q1);
            } catch (SQLException x) {
                x.printStackTrace();
            }
            try {

                java.sql.Statement s = con.createStatement();
                String q1 = "SELECT appName,datedeployed,liveservername,liveserveraddress,remarks,contingencyplans,refId,appversion,apptype,developertype,developername,hostservertype FROM applications";
                re = s.executeQuery(q1);
                this.buildTableModel(re);
                this.jTable1.setVisible(true);
            } catch (SQLException x) {
                x.printStackTrace();
            }
        } else {
            int refID = (int) table.getValueAt(selectedRow, 8);
            try {
                java.sql.Statement s = con.createStatement();
                String q1 = "delete FROM servers where reference_Id = " + refID + " ";
                s.executeUpdate(q1);
            } catch (SQLException x) {
                x.printStackTrace();
            }
            try {

                java.sql.Statement s = con.createStatement();
                String q1 = "select * FROM servers";
                re = s.executeQuery(q1);
                this.buildTableModel(re);
                this.jTable1.setVisible(true);
            } catch (SQLException x) {
                x.printStackTrace();
            }
        }

    }

    public void getSelectedData(JTable table) {
        // Get the selected row from the table.
        int selectedRow = table.getSelectedRow();
        AddStudent x = new AddStudent();
        EditStudent y = new EditStudent();
       

    }

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
