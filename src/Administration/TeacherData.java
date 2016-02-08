/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration;

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
public class TeacherData {
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

    public TeacherData() {
        initialize();
    }

    //this method adds a Taxi to the database
    public void addTeacher(Teacher neo) {
        String firstName = neo.getFirstName();
        String middleName = neo.getMiddleName();
        String lastName = neo.getLastName();
        String birthDate = neo.getBirthDate();
        String gender = neo.getGender();
        String nationality = neo.getNationality();
        String subjects = neo.getSubjects();
        String qualifications = neo.getQualifications();
        String dateEmployed = neo.getDateEmployed();
        int salary = neo.getSalary();
        int imageID = neo.getImageID();

        try {
            String stm = "INSERT INTO teachers(firstname,middlename,lastname,birthDate,gender,nationality,subjects,dateemployed,qualifications,salary,imageID)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            p = conn.prepareStatement(stm);
            p.setString(1, firstName);
            p.setString(2, middleName);
            p.setString(3, lastName);
            p.setString(4, birthDate);
            p.setString(5, gender);
            p.setString(6, nationality);
            p.setString(7, subjects);
            p.setString(8, dateEmployed);
            p.setString(9, qualifications);
            p.setInt(10, salary);
            p.setInt(11, imageID);

            p.executeUpdate();

            System.out.println("New Teacher Added");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //this method updates a Student in the database
    public void updateTeacher(Teacher neo, int id) {
        String firstName = neo.getFirstName();
        String middleName = neo.getMiddleName();
        String lastName = neo.getLastName();
        String birthDate = neo.getBirthDate();
        String gender = neo.getGender();
        String nationality = neo.getNationality();
        String subjects = neo.getSubjects();
        String qualifications = neo.getQualifications();
        String dateEmployed = neo.getDateEmployed();
        int salary = neo.getSalary();
        int imageID = neo.getImageID();

        try {
            String stm = "update teachers set firstname = ?,middlename=?,lastname = ?,birthDate=?,gender = ?,nationality = ?,subjects = ?,qualification =?,dateEmployed = ?,salary = ?,imageID = ? where teacherID=?";
            p = conn.prepareStatement(stm);
            p.setString(1, firstName);
            p.setString(2, middleName);
            p.setString(3, lastName);
            p.setString(4, birthDate);
            p.setString(5, gender);
            p.setString(6, nationality);
            p.setString(7, subjects);
            p.setString(8, qualifications);
            p.setString(9, dateEmployed);
            p.setInt(10, salary);
            p.setInt(11, imageID);
            p.executeUpdate();
            System.out.println("Teacher Data Updated");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    //this method deletes a Student in the database
    public void deleteTeacher(int teacherID) {
        try {
            PreparedStatement r = conn.prepareStatement("DELETE FROM teachers WHERE teacherID=?");
            r.setInt(1, teacherID);
            r.execute();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

// this method searches for a row with the given registration number and stores it in an arrayList
    public ArrayList<String> getSearchbyID(int teacherID) {
        ResultSet u = null;
        ArrayList<String> array = new ArrayList<>();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM teachers WHERE teacherID = '" + teacherID + "'";
            u = s.executeQuery(query);
            if (u.next()) {
                array.add(Integer.toString(u.getInt("teacherID")));
                array.add(u.getString("firstname"));
                array.add(u.getString("middleName"));
                array.add(u.getString("lastName"));
                array.add(u.getString("birthDate"));
                array.add(u.getString("gender"));
                array.add(u.getString("nationality"));
                array.add(u.getString("subjects"));
                array.add(u.getString("qualifications"));
                array.add(u.getString("dateEmployed"));

            } else {
                JOptionPane.showMessageDialog(null, "No teacher with that ID number exist!");
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
            String query = "SELECT * FROM teachers WHERE firstname = '" + Name + "' or where middlename = '" + Name + "' or where lastname = '" + Name + "'";
            u = s.executeQuery(query);
            if (u.next()) {
                array.add(Integer.toString(u.getInt("teacherID")));
                array.add(u.getString("firstname"));
                array.add(u.getString("middleName"));
                array.add(u.getString("lastName"));
                array.add(u.getString("birthDate"));
                array.add(u.getString("gender"));
                array.add(u.getString("nationality"));
                array.add(u.getString("subjects"));
                array.add(u.getString("qualifications"));
                array.add(u.getString("dateEmployed"));

            } else {
                JOptionPane.showMessageDialog(null, "No teacher with that ID number exist!");
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
            String q1 = "SELECT * FROM teachers ";
            u = s.executeQuery(q1);
            x = u;

            PrintWriter writer = new PrintWriter(new File("Teacher.txt"));

            while (u.next()) {
                writer.println(u.getString("teacherID"));
                writer.println(u.getString("firstname"));
                writer.println(u.getString("middlename"));
                writer.println(u.getString("lastname"));
                writer.println(u.getString("birthDate"));
                writer.println(u.getString("gender"));
                writer.println(u.getString("nationality"));
                writer.println(u.getString("subjects"));
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
    public ResultSet getAllTeachers() {
        java.sql.ResultSet u = null;

        try {
            java.sql.Statement s = conn.createStatement();
            String query = "SELECT * FROM teachers ";
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
