/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration;

import java.awt.Image;
import java.util.Date;

/**
 *
 * @author Jacque
 */
public class Person {

   
    
    protected int personID;
    protected String  firstName;
    protected String  lastName;
    protected String  birthDate;
    protected String gender;
    protected String imageID;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return birthDate;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.birthDate = dateOfBirth;
    }

   

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImagePath() {
        return imageID;
    }

    public void setProfilePhoto(String imageID) {
        this.imageID = imageID;
    }
    
     public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }
    
    public boolean isMale() {
    return("Male".equals(this.gender));
    }
    
    public boolean isFemale() {
    return("Female".equals(this.gender));
    }
}
