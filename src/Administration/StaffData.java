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
public class StaffData {

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

    public StaffData() {
        
        initialize();
    }

     public void addImage(File newImage, String path) {
        PreparedStatement st = null;
        ResultSet r = null;
        int id= 0;
        String query = "SELECT MAX(staffID) FROM staff";
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
            p.setString(3, "staff");
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
            p.setString(2,"staff");
            p.executeUpdate();

            System.out.println(" Image Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //this method adds a Taxi to the database
    public void addStaff(Staff neo) {
        String firstName = neo.getFirstName();
        String middleName = neo.getMiddleName();
        String lastName = neo.getLastName();
        String birthDate = neo.getBirthDate();
        String gender = neo.getGender();
        String nationality = neo.getNationality();
        String position = neo.getPosition();
        String qualifications = neo.getQualifications();
        String dateEmployed = neo.getDateEmployed();
        int salary = neo.getSalary();
     

        try {
            String stm = "INSERT INTO staff(firstname,middlename,lastname,birthDate,gender,nationality,position,dateemployed,qualifications,salary)VALUES(?,?,?,?,?,?,?,?,?,?)";
            p = conn.prepareStatement(stm);
            p.setString(1, firstName);
            p.setString(2, middleName);
            p.setString(3, lastName);
            p.setString(4, birthDate);
            p.setString(5, gender);
            p.setString(6, nationality);
            p.setString(7, position);
            p.setString(8, dateEmployed);
            p.setString(9, qualifications);
            p.setInt(10, salary);
            

            p.executeUpdate();

            System.out.println("New Staff Added");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //this method updates a Student in the database
    public void updateStaff(Staff neo, int id) {
        String firstName = neo.getFirstName();
        String middleName = neo.getMiddleName();
        String lastName = neo.getLastName();
        String birthDate = neo.getBirthDate();
        String gender = neo.getGender();
        String nationality = neo.getNationality();
        String position = neo.getPosition();
        String qualifications = neo.getQualifications();
        String dateEmployed = neo.getDateEmployed();
        int salary = neo.getSalary();

        try {
            String stm = "update staff set firstname = ?,middlename=?,lastname = ?,birthDate=?,gender = ?,nationality = ?,position = ?,qualification =?,dateEmployed = ?,salary = ? where staffID=?";
            p = conn.prepareStatement(stm);
            p.setString(1, firstName);
            p.setString(2, middleName);
            p.setString(3, lastName);
            p.setString(4, birthDate);
            p.setString(5, gender);
            p.setString(6, nationality);
            p.setString(7, position);
            p.setString(8, qualifications);
            p.setString(9, dateEmployed);
            p.setInt(10, salary);
            p.executeUpdate();
            System.out.println("Student Data Updated");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    //this method deletes a Student in the database
    public void deleteStaff(int staffID) {
        try {
            PreparedStatement r = conn.prepareStatement("DELETE FROM staff WHERE staffID=?");
            r.setInt(1, staffID);
            r.execute();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

// this method searches for a row with the given registration number and stores it in an arrayList
    public ArrayList<String> getSearchbyID(int staffID) {
        ResultSet u = null;
        ArrayList<String> array = new ArrayList<>();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM staff WHERE staffID = '" + staffID + "'";
            u = s.executeQuery(query);
            if (u.next()) {
                array.add(Integer.toString(u.getInt("staffID")));
                array.add(u.getString("firstname"));
                array.add(u.getString("middleName"));
                array.add(u.getString("lastName"));
                array.add(u.getString("birthDate"));
                array.add(u.getString("gender"));
                array.add(u.getString("nationality"));
                array.add(u.getString("position"));
                array.add(u.getString("qualifications"));
                array.add(u.getString("dateEmployed"));

            } else {
                JOptionPane.showMessageDialog(null, "No staff with that ID number exist!");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        }
        return array;
    }

    public ArrayList<String> getSearchbyName(String Name) {
        ResultSet u = null;
        ArrayList<String> array = new ArrayList<>();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM staff WHERE firstname = '" + Name + "' or where middlename = '" + Name + "' or where lastname = '" + Name + "'";
            u = s.executeQuery(query);
            if (u.next()) {
                array.add(Integer.toString(u.getInt("staffID")));
                array.add(u.getString("firstname"));
                array.add(u.getString("middleName"));
                array.add(u.getString("lastName"));
                array.add(u.getString("birthDate"));
                array.add(u.getString("gender"));
                array.add(u.getString("nationality"));
                array.add(u.getString("position"));
                array.add(u.getString("qualifications"));
                array.add(u.getString("dateEmployed"));

            } else {
                JOptionPane.showMessageDialog(null, "No staff with that ID number exist!");
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
            String q1 = "SELECT * FROM staff ";
            u = s.executeQuery(q1);
            x = u;

            PrintWriter writer = new PrintWriter(new File("Staff.txt"));

            while (u.next()) {
                writer.println(u.getString("StaffID"));
                writer.println(u.getString("firstname"));
                writer.println(u.getString("middlename"));
                writer.println(u.getString("lastname"));
                writer.println(u.getString("birthDate"));
                writer.println(u.getString("gender"));
                writer.println(u.getString("nationality"));
                writer.println(u.getString("position"));
                writer.println(u.getString("qualifications"));
                writer.println(u.getString("dateEmployed"));
                writer.println(u.getInt("imageID"));
                writer.println(u.getInt("salary"));
                

            }

            writer.close();
            System.out.println("saved");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return x;
    }

    // this method just gets info about all taxi drivers available 
    public ResultSet getAllStaff() {
        java.sql.ResultSet u = null;

        try {
            java.sql.Statement s = conn.createStatement();
            String query = "SELECT * FROM staff ";
            u = s.executeQuery(query);

        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        }
        return u;
    }

    public static void main(String[] args) {
        StaffData x = new StaffData();
        ResultSet y = x.saveToFile();
    }

}
