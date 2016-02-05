/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration;

import Administration.StudentData;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jacque
 */
public class Student {

    private int studentID;
    private String firstName;
    private String middleName;
    private String lastName;
    private String birthDate;
    private String gender;
    private int imageID;
    private String grade;
    private String nationality;
    private String dateEnrolled;
    private String fathersName;
    private int fPhone;
    private String mothersName;
    private int mPhone;
    private String resAddr;
    private String poBox;
    private int guard1ID;
    private int guard2ID;

    public Student() {

    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
      public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int personID) {
        this.studentID = personID;
    }

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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

   
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDateEnrolled() {
        return dateEnrolled;
    }

    public void setDateEnrolled(String dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public int getfPhone() {
        return fPhone;
    }

    public void setfPhone(int fPhone) {
        this.fPhone = fPhone;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public int getmPhone() {
        return mPhone;
    }

    public void setmPhone(int mPhone) {
        this.mPhone = mPhone;
    }

    public String getResAddr() {
        return resAddr;
    }

    public void setResAddr(String resAddr) {
        this.resAddr = resAddr;
    }

    public String getPoBox() {
        return poBox;
    }

    public void setPoBox(String poBox) {
        this.poBox = poBox;
    }

    public int getGuard1ID() {
        return guard1ID;
    }

    public void setGuard1ID(int guard1ID) {
        this.guard1ID = guard1ID;
    }

    public int getGuard2ID() {
        return guard2ID;
    }

    public void setGuard2ID(int guard2ID) {
        this.guard2ID = guard2ID;
    }

    public Student(String firstName,String middleName, String lastName, String grade, String gender,String nationality, int imageID, String birthDate, String fathersName, int fPhone,
            String mothersName, int mPhone, String poBox, String resAddr, String dateEnrolled, int guard1ID, int guard2ID) {

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.grade = grade;
        this.gender = gender;
        this.nationality = nationality;
        this.imageID = imageID;
        this.birthDate = birthDate;
        this.fathersName = fathersName;
        this.fPhone = fPhone;
        this.mothersName = mothersName;
        this.mPhone = mPhone;
        this.poBox = poBox;
        this.resAddr = resAddr;
        this.dateEnrolled = dateEnrolled;
        this.guard1ID = guard1ID;
        this.guard2ID = guard1ID;

    }


    public boolean isStudent() {
        return (this instanceof Student);
    }

    public static void main(String[] args) {
       
    }

}
