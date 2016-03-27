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
public class GuardianData {

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

    public GuardianData() {
        initialize();
    }

    public void addGuardian(Guardian neo) {
        String firstname = neo.getFirstname();
        String middlename = neo.getMiddlename();
        String lastname = neo.getLastname();
        String nationality = neo.getNationality();
        String birthdate = neo.getBirthDate();

        try {
            String stm = "INSERT INTO Guardians(firstname,middlename,lastname,nationality,birthDate)VALUES(?,?,?,?,?)";
            p = conn.prepareStatement(stm);
            p.setString(1, firstname);
            p.setString(2, middlename);
            p.setString(3, lastname);
            p.setString(4, nationality);
            p.setString(5, birthdate);

            p.executeUpdate();

            System.out.println("New Guardian Added");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateGuardian(Guardian neo, int id) {
        String firstname = neo.getFirstname();
        String middlename = neo.getMiddlename();
        String lastname = neo.getLastname();
        String nationality = neo.getNationality();
        String birthdate = neo.getBirthDate();

        try {
            String stm = "update Guardians set firstname = ?,middlename = ?,lastname = ?,nationality = ?,birthDate = ? where GuardianID=" + id + "";
            p = conn.prepareStatement(stm);
            p.setString(1, firstname);
            p.setString(2, middlename);
            p.setString(3, lastname);
            p.setString(4, nationality);
            p.setString(5, birthdate);

            p.executeUpdate();
            System.out.println("Guardian Data Updated");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    //this method deletes a Guardian in the database
    public void deleteGuardian(int GuardianID) {
        try {
            PreparedStatement r = conn.prepareStatement("DELETE FROM Guardians WHERE GuardianID=?");
            r.setInt(1, GuardianID);
            r.execute();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
     public void addImage(File newImage, String path) {
        PreparedStatement st = null;
        ResultSet r = null;
        int id= 0;
        String query = "SELECT MAX(GuardianID) FROM guardians";
        try {
            String stm = "INSERT INTO images(source,personID,category)VALUES(?,?,?)";
            st = conn.prepareStatement(query);
            r = st.executeQuery();
          if(r.next()){
           id = r.getInt(1);
           System.out.println(id);
          }
            int pid = id + 1;
            p = conn.prepareStatement(stm);
            p.setString(1, path);
            p.setInt(2, pid);
            p.setString(3, "guardians");
            p.executeUpdate();

            System.out.println("New Image Added");
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
   public void updateImage(File newImage, String path, int sid) {
        try {
            String stm = "update images set source = ?,category = ? where personID = "+sid+"";
            p = conn.prepareStatement(stm);
            p.setString(1, path);
            p.setString(2,"guardians");
            p.executeUpdate();

            System.out.println(" Image Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

// this method searches for a row with the given registration number and stores it in an arrayList
    public ArrayList<String> getSearchbyID(int GuardianID) {
        ResultSet u = null;
        ArrayList<String> array = new ArrayList<>();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM Guardians WHERE GuardianID = '" + GuardianID + "'";
            u = s.executeQuery(query);
            if (u.next()) {
                array.add(Integer.toString(u.getInt("GuardianID")));
                array.add(u.getString("firstname"));
                array.add(u.getString("middlename"));
                array.add(u.getString("lastname"));
                array.add(u.getString("nationality"));
                array.add(u.getString("birthDate"));

            } else {
                JOptionPane.showMessageDialog(null, "No Guardian with that ID number exist!");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        }
        return array;
    }

    public ArrayList<String> getSearchbyName(String GuardianName) {
        ResultSet u = null;
        ArrayList<String> array = new ArrayList<>();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM Guardians WHERE firstname  like %'" + GuardianName + "' or middlename  like %'" + GuardianName + "'lastname  like %'" + GuardianName + "'";
            u = s.executeQuery(query);
            if (u.next()) {
                 array.add(Integer.toString(u.getInt("GuardianID")));
                array.add(u.getString("firstname"));
                array.add(u.getString("middlename"));
                array.add(u.getString("lastname"));
                array.add(u.getString("nationality"));
                array.add(u.getString("birthDate"));

            } else {
                JOptionPane.showMessageDialog(null, "No Guardian with that ID number exist!");
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
            String q1 = "SELECT * FROM Guardians ";
            u = s.executeQuery(q1);
            x = u;

            PrintWriter writer = new PrintWriter(new File("Guardians.txt"));

            while (u.next()) {
                writer.println(Integer.toString(u.getInt("GuardianID")));
                writer.println(u.getString("firstname"));
                writer.println(u.getString("middlename"));
                writer.println(u.getString("lastname"));
                writer.println(u.getString("nationality"));
                writer.println(u.getString("birthDate"));

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
            String query = "SELECT * FROM Guardians ";
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
