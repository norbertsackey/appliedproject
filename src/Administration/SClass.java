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
public class SClass {
    private String subject;
    private String descrip;
    private int teacherID;
    private int periodID;
    private String classroom;
    
    public SClass(String subject, String descrip, int teacherID, int periodID, String classroom){
    this.subject = subject;
    this.descrip = descrip;
    this.teacherID = teacherID;
    this.periodID = periodID;
    this.classroom = classroom;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return descrip;
    }

    public void setDescription(String descrip) {
        this.descrip = descrip;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public int getPeriodID() {
        return periodID;
    }

    public void setPeriodID(int periodID) {
        this.periodID = periodID;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
            
    
}
