/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration;

/**
 *
 * @author Jacque
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 *
 * @author Norbert
 * @version 1.0
 * @since 2014-03-31
 */
public class TermData {

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

    public TermData() {
        initialize();
    }

    
    public void addTerm(Term neo) {
        String termname = neo.getName();
        String startdate = neo.getStartdate();
        String enddate = neo.getEnddate();
        
        try {
            String stm = "INSERT INTO terms(TermName,StartDate,EndDate)VALUES(?,?,?)";
            p = conn.prepareStatement(stm);
            p.setString(1, termname);
            p.setString(2, startdate);
            p.setString(3, enddate);
         
            p.executeUpdate();

            System.out.println("New Term Added");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
   
   

    public void updateTerm(Term neo, int id) {
        String termname = neo.getName();
        String startdate = neo.getStartdate();
        String enddate = neo.getEnddate();
        try {
            String stm = "update terms set TermName = ?,startDate = ?,endDate = ? where TermID="+id+"";
            p = conn.prepareStatement(stm);
          p.setString(1, termname);
            p.setString(2, startdate);
            p.setString(3, enddate);
           
            p.executeUpdate();
            System.out.println("Term Data Updated");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    //this method deletes a Term in the database
    public void deleteTerm(int TermID) {
        try {
            PreparedStatement r = conn.prepareStatement("DELETE FROM terms WHERE TermID=?");
            r.setInt(1, TermID);
            r.execute();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

// this method searches for a row with the given registration number and stores it in an arrayList
    public ArrayList<String> getSearchbyID(int TermID) {
        ResultSet u = null;
        ArrayList<String> array = new ArrayList<>();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM Terms WHERE TermID = '" + TermID + "'";
            u = s.executeQuery(query);
            if (u.next()) {
                array.add(Integer.toString(u.getInt("TermID")));
                array.add(u.getString("TermName"));
                array.add(u.getString("startDate"));
                array.add(u.getString("endDate"));

            } else {
                JOptionPane.showMessageDialog(null, "No Term with that ID number exist!");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        }
        return array;
    }

    public ArrayList<String> getSearchbyName(String termName) {
        ResultSet u = null;
        ArrayList<String> array = new ArrayList<>();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM terms WHERE termName  like %'" + termName + "'";
            u = s.executeQuery(query);
            if (u.next()) {
                array.add(Integer.toString(u.getInt("TermID")));
                array.add(u.getString("TermName"));
                array.add(u.getString("startDate"));
                array.add(u.getString("endDate"));

            } else {
                JOptionPane.showMessageDialog(null, "No term with that ID number exist!");
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
            String q1 = "SELECT * FROM terms ";
            u = s.executeQuery(q1);
            x = u;

            PrintWriter writer = new PrintWriter(new File("terms.txt"));

            while (u.next()) {
                writer.println(Integer.toString(u.getInt("TermID")));
                writer.println(u.getString("TermName"));
                writer.println(u.getString("startDate"));
                writer.println(u.getString("endDate"));
               
              

            }

            writer.close();
            System.out.println("saved");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return x;
    }

    // this method just gets info about all taxi drivers available 
    public ResultSet getAllClases() {
        java.sql.ResultSet u = null;

        try {
            java.sql.Statement s = conn.createStatement();
            String query = "SELECT * FROM terms ";
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
