/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Messaging;


import java.io.File;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jacque
 */
public class MessageData {

    java.sql.Connection conn = null;
    PreparedStatement p = null;

    //this method sets up the connection to the DB
    public void initialize() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost/applied_project?user=root&password=");

        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        }
        System.out.println("Connection established");
    }

    public MessageData() {
        initialize();
    }

    //this method adds a Taxi to the database
    public void addMessage(MessageOut neo) {
        String sender = neo.getSender();
        String recipients = "";
        for(int i = 0 ; i < neo.getRecipients().length;i++){
          recipients = neo.getRecipients()[i]+" ; ";
          
        }
      
        String content = neo.getContent();
        String timestamp = neo.getTimestamp();
        String subject = neo.getSubject();
       
   

        try {
            String stm = "INSERT INTO messages(sender,recipients,content,timestamp,subject)VALUES(?,?,?,?,?)";
            p = conn.prepareStatement(stm);
            p.setString(1, sender);
            p.setString(2, recipients);
            p.setString(3, content);
            p.setString(4, timestamp);
            p.setString(5, subject);
            p.executeUpdate();

            System.out.println("New Message Added");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //this method updates a Taxi in the database
    public void updateMessage(MessageOut neo, int id) {
        String sender = neo.getSender();
        String recipients = neo.getRecipients().toString();
        String content = neo.getContent();
        String timestamp = neo.getTimestamp();
        String subject = neo.getSubject();
     
        try {
            String stm = "update messages set sender = ?,recipients = ?,content = ?,timestamp = ?, subject = ? messageID=?";
            p = conn.prepareStatement(stm);
            p.setString(1, sender);
            p.setString(2, recipients);
            p.setString(3, content);
            p.setString(4, timestamp);
            p.setString(5, subject);
            p.setInt(5, id);
            p.executeUpdate();
            System.out.println("Message Data Updated");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    //this method deletes a Message in the database
    public void deleteMessage(int mid) {
        try {
            PreparedStatement r = conn.prepareStatement("DELETE FROM messages where messageID=?");
            r.setInt(1, mid);
            r.execute();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

// this method searches for a row with the given registration number and stores it in an arrayList
   

    public ArrayList<String> getMessagesBySub(String subject) {
        ResultSet u = null;
        ArrayList<String> array = new ArrayList<>();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM messages WHERE subject = '" + subject + "'";
            u = s.executeQuery(query);
            if (u.next()) {
                array.add(Integer.toString(u.getInt("messageID")));
                array.add(u.getString("sender"));
                array.add(u.getString("content"));
                array.add(u.getString("recipients"));
                array.add(u.getString("subject"));
                array.add(u.getString("timestamp"));
                
            } else {
                JOptionPane.showMessageDialog(null, "No Message with that ID number exist!");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        }
        return array;
    }

    //This method stores all the needed info about all taxi in a text file

    public ResultSet saveToFile() {
        ResultSet u = null;
        ResultSet x = null;
        try {
            java.sql.Statement s = conn.createStatement();
            String q1 = "SELECT * FROM messages ";
            u = s.executeQuery(q1);
            x = u;

            PrintWriter writer = new PrintWriter(new File("Messages.txt"));

            while (u.next()) {
                writer.println(Integer.toString(u.getInt("messageID")));
                writer.println(u.getString("sender"));
                writer.println(u.getString("content"));
                writer.println(u.getString("recipient"));
                writer.println(u.getString("subject"));
                writer.println(u.getString("timestamp"));
              
              
               

            }

            writer.close();
            System.out.println("saved");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return x;
    }

    // this method just gets info about all taxi drivers available 
    public ResultSet getAllMessages() {
        java.sql.ResultSet u = null;

        try {
            java.sql.Statement s = conn.createStatement();
            String query = "SELECT * FROM messages ";
            u = s.executeQuery(query);

        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        }
        return u;
    }

    public static void main(String[] args) {
      
       
    }

}

    

