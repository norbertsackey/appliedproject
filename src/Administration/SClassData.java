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
public class SClassData {

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

    public SClassData() {
        initialize();
    }

    public void addClass(SClass neo) {
        String subject = neo.getSubject();
        String descrip = neo.getDescription();
        int teacherID = neo.getTeacherID();
        int periodID = neo.getPeriodID();
        String classroom = neo.getClassroom();

        try {
            String stm = "INSERT INTO classes(subject,descrip,teacherID,periodID,classroom)VALUES(?,?,?,?,?)";
            p = conn.prepareStatement(stm);
            p.setString(1, subject);
            p.setString(2, descrip);
            p.setInt(3, teacherID);
            p.setInt(4, periodID);
            p.setString(5, classroom);

            p.executeUpdate();

            System.out.println("New Class Added");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateClass(SClass neo, int id) {
        String subject = neo.getSubject();
        String descrip = neo.getDescription();
        int teacherID = neo.getTeacherID();
        int periodID = neo.getPeriodID();
        String classroom = neo.getClassroom();

        try {
            String stm = "update classes set subject = ?,descrip = ?,teacherID = ?,periodID = ?, classroom = ? where classID=" + id + "";
            p = conn.prepareStatement(stm);
            p.setString(1, subject);
            p.setString(2, descrip);
            p.setInt(3, teacherID);
            p.setInt(4, periodID);
            p.setString(5, classroom);

            p.executeUpdate();
            System.out.println("Class Data Updated");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    //this method deletes a Class in the database
    public void deleteClass(int classID) {
        try {
            PreparedStatement r = conn.prepareStatement("DELETE FROM classes WHERE classID=?");
            r.setInt(1, classID);
            r.execute();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

// this method searches for a row with the given registration number and stores it in an arrayList
    public ArrayList<String> getSearchbyID(int classID) {
        ResultSet u = null;
        ArrayList<String> array = new ArrayList<>();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM classes WHERE classID = '" + classID + "'";
            u = s.executeQuery(query);
            if (u.next()) {
                array.add(Integer.toString(u.getInt("classID")));
                array.add(u.getString("subject"));
                array.add(u.getString("descrip"));
                array.add(Integer.toString(u.getInt("teacherID")));
                array.add(Integer.toString(u.getInt("periodID")));
                array.add(u.getString("classroom"));

            } else {
                JOptionPane.showMessageDialog(null, "No class with that ID number exist!");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        }
        return array;
    }

    public ArrayList<String> getSearchbyName(String subject) {
        ResultSet u = null;
        ArrayList<String> array = new ArrayList<>();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM classes WHERE subject  like %'" + subject + "'";
            u = s.executeQuery(query);
            if (u.next()) {
                array.add(Integer.toString(u.getInt("classID")));
                array.add(u.getString("subject"));
                array.add(u.getString("descrip"));
                array.add(Integer.toString(u.getInt("teacherID")));
                array.add(Integer.toString(u.getInt("periodID")));
                array.add(u.getString("classroom"));

            } else {
                JOptionPane.showMessageDialog(null, "No class with that ID number exist!");
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
            String q1 = "SELECT * FROM classes ";
            u = s.executeQuery(q1);
            x = u;

            PrintWriter writer = new PrintWriter(new File("classes.txt"));

            while (u.next()) {
                writer.println(Integer.toString(u.getInt("classID")));
                writer.println(u.getString("subject"));
                writer.println(u.getString("descrip"));
                writer.println(Integer.toString(u.getInt("teacherID")));
                writer.println(Integer.toString(u.getInt("personID")));
                writer.println(u.getString("classroom"));

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
            String query = "SELECT * FROM classes ";
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
