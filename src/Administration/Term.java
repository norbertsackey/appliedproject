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
public class Term {
    private String name;
    private String startdate;
    private String enddate;

   public Term(String name,String startdate,String enddate){
    this.name = name;
    this.startdate = startdate;
    this.enddate = enddate;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
    
    
    
    
}
