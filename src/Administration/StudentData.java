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
public class StudentData {

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

    public StudentData() {
        initialize();
    }

    //this method adds a Taxi to the database
    public void addStudent(Student neo) {
        String firstName = neo.getFirstName();
        String middleName = neo.getMiddleName();
        String lastName = neo.getLastName();
        String grade = neo.getGrade();
        String gender = neo.getGender();
        String nationality = neo.getNationality();
        String birthDate = neo.getBirthDate();
        String fathersName = neo.getFathersName();
        int fPhone = neo.getfPhone();
        String mothersName = neo.getMothersName();
        int mPhone = neo.getmPhone();
        String poBox = neo.getPoBox();
        String resAddr = neo.getResAddr();
        String dateEnrolled = neo.getDateEnrolled();
        int guard1ID = neo.getGuard1ID();
        int guard2ID = neo.getGuard2ID();

        try {
            String stm = "INSERT INTO students(firstname,lastname,grade,gender,birthDate,fathersname,fphone,mothersname,mphone,pobox,resAddr,dateEnrolled,guard1ID,guard2ID,nationality,middlename)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            p = conn.prepareStatement(stm);
            p.setString(1, firstName);
            p.setString(2, lastName);
            p.setString(3, grade);
            p.setString(4, gender);
            p.setString(5, birthDate);
            p.setString(6, fathersName);
            p.setInt(7, fPhone);
            p.setString(8, mothersName);
            p.setInt(9, mPhone);
            p.setString(10, poBox);
            p.setString(11, resAddr);
            p.setString(12, dateEnrolled);
            p.setInt(13, guard1ID);
            p.setInt(14, guard2ID);
            p.setString(15, nationality);
            p.setString(16, middleName);
            p.executeUpdate();

            System.out.println("New Student Added");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void addImage(File newImage, String path) {
        PreparedStatement st = null;
        ResultSet r = null;
        int id= 0;
        String query = "SELECT MAX(studentID) FROM students";
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
            p.setString(3, "students");
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
            p.setString(2,"students");
            p.executeUpdate();

            System.out.println(" Image Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //this method updates a Taxi in the database
    public void updateStudent(Student neo, int id) {
        String firstName = neo.getFirstName();
        String middleName = neo.getMiddleName();
        String lastName = neo.getLastName();
        String grade = neo.getGrade();
        String gender = neo.getGender();
        String nationality = neo.getNationality();
        String birthDate = neo.getBirthDate();
        String fathersName = neo.getFathersName();
        int fPhone = neo.getfPhone();
        String mothersName = neo.getMothersName();
        int mPhone = neo.getmPhone();
        String poBox = neo.getPoBox();
        String resAddr = neo.getResAddr();
        String dateEnrolled = neo.getDateEnrolled();
        int guard1ID = neo.getGuard1ID();
        int guard2ID = neo.getGuard2ID();
        try {
            String stm = "update students set firstname = ?,lastname = ?,grade = ?,gender = ?,birthDate = ?,fathersname =?,fphone = ?,mothersname = ?,mphone = ?,pobox=?,resAddr = ?,dateEnrolled = ?,guard1ID = ?,guard2ID =?,nationality=?,middlename=? where studentID="+id+"";
            p = conn.prepareStatement(stm);
            p.setString(1, firstName);
            p.setString(2, lastName);
            p.setString(3, grade);
            p.setString(4, gender);
            p.setString(5, birthDate);
            p.setString(6, fathersName);
            p.setInt(7, fPhone);
            p.setString(8, mothersName);
            p.setInt(9, mPhone);
            p.setString(10, poBox);
            p.setString(11, resAddr);
            p.setString(12, dateEnrolled);
            p.setInt(13, guard1ID);
            p.setInt(14, guard2ID);
            p.setString(15, nationality);
            p.setString(16, middleName);
            p.executeUpdate();
            System.out.println("Student Data Updated");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    //this method deletes a Student in the database
    public void deleteStudent(int studentID) {
        try {
            PreparedStatement r = conn.prepareStatement("DELETE FROM students WHERE studentID=?");
            r.setInt(1, studentID);
            r.execute();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

// this method searches for a row with the given registration number and stores it in an arrayList
    public ArrayList<String> getSearchbyID(int studentID) {
        ResultSet u = null;
        ArrayList<String> array = new ArrayList<>();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM students WHERE studentID = '" + studentID + "'";
            u = s.executeQuery(query);
            if (u.next()) {
                array.add(Integer.toString(u.getInt("studentID")));
                array.add(u.getString("firstname"));
                array.add(u.getString("middleName"));
                array.add(u.getString("lastName"));
                array.add(u.getString("grade"));
                array.add(u.getString("gender"));
                array.add(u.getString("imageID"));
                array.add(u.getString("birthDate"));

            } else {
                JOptionPane.showMessageDialog(null, "No student with that ID number exist!");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        }
        return array;
    }

    public ArrayList<String> getSearchbyName(String studentName) {
        ResultSet u = null;
        ArrayList<String> array = new ArrayList<>();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM students WHERE studentID = '" + studentName + "'";
            u = s.executeQuery(query);
            if (u.next()) {
                array.add(Integer.toString(u.getInt("studentID")));
                array.add(u.getString("firstname"));
                array.add(u.getString("middleName"));
                array.add(u.getString("lastName"));
                array.add(u.getString("grade"));
                array.add(u.getString("gender"));
                array.add(u.getString("imageID"));
                array.add(u.getString("birthDate"));

            } else {
                JOptionPane.showMessageDialog(null, "No student with that ID number exist!");
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
            String q1 = "SELECT * FROM students ";
            u = s.executeQuery(q1);
            x = u;

            PrintWriter writer = new PrintWriter(new File("Students.txt"));

            while (u.next()) {
                writer.println(u.getString("StudentID"));
                writer.println(u.getString("firstname"));
                writer.println(u.getString("grade"));
                writer.println(u.getString("gender"));
                writer.println(u.getString("imageID"));
                writer.println(u.getString("gender"));
                writer.println(u.getString("birthDate"));
                writer.println(u.getString("fathersName"));
                writer.println(Integer.toString(u.getInt("fPhone")));
                writer.println(u.getString("mothersName"));
                writer.println(Integer.toString(u.getInt("mPhone")));
                writer.println(u.getString("poBox"));
                writer.println(u.getString("resAddr"));
                writer.println(u.getString("dateEnrolled"));
                writer.println(Integer.toString(u.getInt("guard1ID")));
                writer.println(Integer.toString(u.getInt("guard2ID")));

            }

            writer.close();
            System.out.println("saved");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return x;
    }

    // this method just gets info about all taxi drivers available 
    public ResultSet getAllStudents() {
        java.sql.ResultSet u = null;

        try {
            java.sql.Statement s = conn.createStatement();
            String query = "SELECT * FROM students ";
            u = s.executeQuery(query);

        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        }
        return u;
    }

    public static void main(String[] args) {
        StudentData x = new StudentData();
        ResultSet y = x.saveToFile();
    }

}
