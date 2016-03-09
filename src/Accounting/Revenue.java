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

    protected int revenueType;
    protected int amount;
    protected String dateRec;
    protected int[] payers;
    protected String desc;

    public Revenue(int revenueType, int amount, String dateRec, String[] payers, String desc) {
        this.revenueType = revenueType;
        this.amount = amount;
        this.dateRec = dateRec;
        this.desc = desc;
        this.payers = new int [100];
    for(int i = 0 ; i < payers.length; i++){
       this.payers[i] = Integer.parseInt(payers[i]);
       
    }
        
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getRevenueType() {
        return revenueType;
    }

    public void setRevenueType(int revenueType) {
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

    public int[] getPayers() {
        return payers;
    }

    public void setPayers(int[] payers) {
        this.payers = payers;
    }

  

    public int getPayer(int i) {

        return payers[i];
    }

}
