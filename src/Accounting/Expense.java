/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounting;

/**
 *
 * @author Jacque
 */
public class Expense {

   
    protected String expenseType ;
    protected int amount;
    protected String dateofExp;
    protected String payee ;
    protected String desc ;
    
    
    public Expense(){
    
    }
    
    public Expense(String expenseType, int amount, String dateofExp, String description, String payee){
    this.expenseType = expenseType;
    this.amount = amount;
    this.dateofExp = dateofExp;
    this.desc  = description;
    this.payee = payee;
  
    }
    
    
    
    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDateofExp() {
        return dateofExp;
    }

    public void setDateofExp(String dateofExp) {
        this.dateofExp = dateofExp;
    }

    public String getDescription() {
        return desc;
    }

    public void setDescription(String description) {
        this.desc = description;
    }
    public String getPayee(){
      
        return payee;
    }
    
    public void setPayee(String payees) {
        this.payee = payees;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    
    
}
