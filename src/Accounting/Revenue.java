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
public class Revenue {

    protected String revenueType;
    protected int amount;
    protected String dateRec;
    protected String payer;
    protected String desc;

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }
    

    public Revenue(String revenueType, int amount, String dateRec, String payer, String desc) {
        this.revenueType = revenueType;
        this.amount = amount;
        this.dateRec = dateRec;
        this.desc = desc;
        this.payer = payer;
       
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRevenueType() {
        return revenueType;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDateRec() {
        return dateRec;
    }

    public void setDateRec(String dateRec) {
        this.dateRec = dateRec;
    }

   

}
