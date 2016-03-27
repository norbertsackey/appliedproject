/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounting;

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
public class RevenueData {
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

    public RevenueData() {
        initialize();
    }

    //this method adds a Taxi to the database
    public void addRevenue(Revenue neo) {
        String RevenueType = neo.getRevenueType();
        int amount = neo.getAmount();
        String dateRec = neo.getDateRec();
        String payer = neo.getPayer();
       
        String desc = neo.getDesc();
                
        try {
            String stm = "INSERT INTO Revenues(RevenueType,amount,dateRec,payer,descrip)VALUES(?,?,?,?,?)";
            p = conn.prepareStatement(stm);
            p.setString(1, RevenueType);
            p.setInt(2, amount);
            p.setString(3, dateRec);
            p.setString(4, payer);
            p.setString(5, desc);
            
            p.executeUpdate();

            System.out.println("New Revenue Added");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //this method updates a Student in the database
    public void updateRevenue(Revenue neo, int id) {
        String RevenueType = neo.getRevenueType();
        int amount = neo.getAmount();
        String dateRec = neo.getDateRec();
        String payer = neo.getPayer();
     
        String desc = neo.getDesc();

        try {
            String stm = "update Revenues set RevenueType = ?,amount=?,dateRec = ?, payer=?,descrip = ?  where RevenueID=?";
            p = conn.prepareStatement(stm);
            p.setString(1, RevenueType);
            p.setInt(2, amount);
            p.setString(3, dateRec);
            p.setString(4, payer);
            p.setString(5, desc);
            p.setInt(6, id);
            p.executeUpdate();
            System.out.println("Revenue Data Updated");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    //this method deletes a Student in the database
    public void deleteRevenue(int RevenueID) {
        try {
            PreparedStatement r = conn.prepareStatement("DELETE FROM Revenues WHERE RevenueID=?");
            r.setInt(1, RevenueID);
            r.execute();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

// this method searches for a row with the given registration number and stores it in an arrayList
    public ArrayList<String> getSearchbyID(int RevenueID) {
        ResultSet u = null;
        ArrayList<String> array = new ArrayList<>();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM Revenue WHERE RevenueID = '" + RevenueID + "'";
            u = s.executeQuery(query);
            if (u.next()) {
                array.add(Integer.toString(u.getInt("RevenueID")));
                array.add(u.getString("RevenueType"));
                array.add(Integer.toString(u.getInt("amount")));
                array.add(u.getString("dateRec"));
                array.add(u.getString("payer"));
                array.add(u.getString("descrip"));
                

            } else {
                JOptionPane.showMessageDialog(null, "No Revenue with that ID number exist!");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        }
        return array;
    }

    public ArrayList<String> getSearchbyType(String type) {
        ResultSet u = null;
        ArrayList<String> array = new ArrayList<>();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM Revenue WHERE revenueType = '" + type + "'";
            u = s.executeQuery(query);
            if (u.next()) {
                array.add(Integer.toString(u.getInt("RevenueID")));
                array.add(u.getString("RevenueType"));
                 array.add(Integer.toString(u.getInt("amount")));
                array.add(u.getString("dateofExp"));
                array.add(u.getString("payer"));
                array.add(u.getString("descrip"));

            } else {
                JOptionPane.showMessageDialog(null, "No Revenue with that ID number exist!");
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
            String q1 = "SELECT * FROM Revenues ";
            u = s.executeQuery(q1);
            x = u;

            PrintWriter writer = new PrintWriter(new File("Revenue.txt"));

            while (u.next()) {
                writer.println(Integer.toString(u.getInt("RevenueID")));
                writer.println(u.getString("RevenueType"));
                writer.println(Integer.toString(u.getInt("amount")));
                writer.println(u.getString("dateRec"));
                writer.println(u.getString("payer"));
                writer.println(u.getString("descrip"));

            }

            writer.close();
            System.out.println("saved");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return x;
    }

    // this method just gets info about all taxi drivers available 
    public ResultSet getAllRevenue() {
        java.sql.ResultSet u = null;

        try {
            java.sql.Statement s = conn.createStatement();
            String query = "SELECT * FROM Revenues ";
            u = s.executeQuery(query);

        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        }
        return u;
    }
    
}
