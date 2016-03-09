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

   
    protected int expenseType ;
    protected int amount;
    protected String dateofExp;
    protected int[] payees ;
    protected String desc ;
    
    
    public Expense(){
    
    }
    
    public Expense(int expenseType, int amount, String dateofExp, String description, String [] payees){
    this.expenseType = expenseType;
    this.amount = amount;
    this.dateofExp = dateofExp;
    this.desc  = description;
    this.payees = new int [100];
  
    
    for(int i = 0 ; i < payees.length; i++){
       this.payees[i] = Integer.parseInt(payees[i]);
       
    }
    }
    public int getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(int expenseType) {
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
    public int getPayee(int i){
      
        return payees[i];
    }

    public int[] getPayees() {
        return payees;
    }

    public void setPayees(int[] payees) {
        this.payees = payees;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    
    
}
