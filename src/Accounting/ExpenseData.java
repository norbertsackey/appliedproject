/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounting;

import Accounting.Expense;
import Accounting.ExpenseData;
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
public class ExpenseData {

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

    public ExpenseData() {
        initialize();
    }

    //this method adds a Taxi to the database
    public void addExpense(Expense neo, int i) {
        int expenseType = neo.getExpenseType();
        int amount = neo.getAmount();
        String dateofExp = neo.getDateofExp();
        int payee = neo.getPayee(i);
        String desc = neo.getDescription();
        

        try {
            String stm = "INSERT INTO expenses(expenseType,amount,dateofExp,payee,descrip)VALUES(?,?,?,?,?)";
            p = conn.prepareStatement(stm);
            p.setInt(1, expenseType);
            p.setInt(2, amount);
            p.setString(3, dateofExp);
            p.setInt(4, payee);
            p.setString(5, desc);
           
            p.executeUpdate();

            System.out.println("New Expense Added");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //this method updates a Student in the database
    public void updateExpense(Expense neo, int i, int id) {
        int expenseType = neo.getExpenseType();
        int amount = neo.getAmount();
        String dateofExp = neo.getDateofExp();
        int payee = neo.getPayee(i);
        String desc = neo.getDescription();
       

        try {
            String stm = "update expenses set expenseType = ?,amount=?,dateofExp = ?, payee=?,descrip = ? where expenseID=?";
            p = conn.prepareStatement(stm);
            p.setInt(1, expenseType);
            p.setInt(2, amount);
            p.setString(3, dateofExp);
            p.setInt(4, payee);
            p.setString(5, desc);
            p.setInt(6,id);
            
            p.executeUpdate();
            System.out.println("Expense Data Updated");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    //this method deletes a Student in the database
    public void deleteExpense(int expenseID) {
        try {
            PreparedStatement r = conn.prepareStatement("DELETE FROM expense WHERE expenseID=?");
            r.setInt(1, expenseID);
            r.execute();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

// this method searches for a row with the given registration number and stores it in an arrayList
    public ArrayList<String> getSearchbyID(int expenseID) {
        ResultSet u = null;
        ArrayList<String> array = new ArrayList<>();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM Expense WHERE expenseID = '" + expenseID + "'";
            u = s.executeQuery(query);
            if (u.next()) {
                array.add(Integer.toString(u.getInt("ExpenseID")));
                array.add(u.getString("expenseType"));
                array.add(Integer.toString(u.getInt("amount")));
                array.add(u.getString("dateofExp"));
               array.add(Integer.toString(u.getInt("payee")));
                array.add(u.getString("descrip"));
               
            } else {
                JOptionPane.showMessageDialog(null, "No Expense with that ID number exist!");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        }
        return array;
    }

    public ArrayList<String> getSearchbyName(String expenseType) {
        ResultSet u = null;
        ArrayList<String> array = new ArrayList<>();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM Expense WHERE firstname = '" + expenseType + "'";
            u = s.executeQuery(query);
            if (u.next()) {
                array.add(Integer.toString(u.getInt("ExpenseID")));
                array.add(u.getString("expenseType"));
                array.add(Integer.toString(u.getInt("amount")));
                array.add(u.getString("dateofExp"));
               array.add(Integer.toString(u.getInt("payee")));
                array.add(u.getString("descrip"));
                

            } else {
                JOptionPane.showMessageDialog(null, "No Expense with that ID number exist!");
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
            String q1 = "SELECT * FROM Expenses ";
            u = s.executeQuery(q1);
            x = u;

            PrintWriter writer = new PrintWriter(new File("Expense.txt"));

            while (u.next()) {
                writer.println(Integer.toString(u.getInt("ExpenseID")));
                writer.println(u.getString("expenseType"));
                writer.println(Integer.toString(u.getInt("amount")));
                writer.println(u.getString("dateofExp"));
              writer.println(Integer.toString(u.getInt("payee")));
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
    public ResultSet getAllExpense() {
        java.sql.ResultSet u = null;

        try {
            java.sql.Statement s = conn.createStatement();
            String query = "SELECT * FROM Expenses ";
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
