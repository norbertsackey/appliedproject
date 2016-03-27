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
public class Guardian {
    
    private String firstname;
    private String middlename;
    private String lastname;
    private String nationality;
    private String BirthDate;
    private String resAddr;
    private String phone;
    
    
    

    public Guardian(String firstname, String middlename, String lastname, String nationality, String BirthDate) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nationality = nationality;
        this.BirthDate = BirthDate;
    }

    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String BirthDate) {
        this.BirthDate = BirthDate;
    }
    
    
    
}
