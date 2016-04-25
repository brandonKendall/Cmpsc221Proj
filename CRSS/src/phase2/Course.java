package phase2;

import crss.*;
import java.util.ArrayList;

public class Course {
    // instance vars
    private String crsName;
    private int crsTm;
    
    // these are for storing the instance of students in the course
    private int room;
    private Student student;
    private ArrayList<Student> stud = new ArrayList<>();
    // class constructor
    public Course() {}
    
    // getters and setters
    public void setCName(String crsName) {
        this.crsName = crsName;
    }
    
    public void setCTm(int crsTm) {
        if (crsTm > 9.00 && crsTm < 17.00) {
            this.crsTm = crsTm;
        }
    }
    
    public void setCrm(int room) {
        this.room = room;
    }
    
    public void setStu(Student student) {
        this.student = student;
        stud.add(student);
    }
    
    public ArrayList<Student> getStud() {
        return this.stud;
    }
    public String getCName() {
        return crsName;
    }
    
    public int getCtm() {
        return crsTm;
    }
    
    public int getCrm() {
        return room;
    }
    
    public Student getStu() {
        return student;
    }

    public boolean isEmpty() {
        if (this.stud.isEmpty())
            return true;
        else 
            return false;
    }
}