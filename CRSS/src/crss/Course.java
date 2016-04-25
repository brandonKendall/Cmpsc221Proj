package crss;

import java.util.ArrayList;

public class Course {
    // instance vars
    private String crsName;
    private int crsTm;
    // these are for storing the instance of students in the course
    private Student student;
    private ArrayList<Student> stud = new ArrayList<>();
    private Room room;

    public Course() {}
    
    // class constructor
    public Course(String crsName, int crsTm, Room room) {
        this.crsName = crsName;
        this.crsTm = crsTm;
        this.room = room;
    }

    public Course(String crsName, int crsTm, Room room, ArrayList<Student> stud) {
        this.crsName = crsName;
        this.crsTm = crsTm;
        this.room = room;
        this.stud = stud;
    }
    
    // getters and setters
    public void setCName(String crsName) {
        this.crsName = crsName;
    }
    
    public void setCTm(int crsTm) {
            this.crsTm = crsTm;
    }
    
    
    public void setStu(Student student) {
        this.student = student;
        stud.add(student);
    }
    
    public ArrayList<Student> getStud() {
        return this.stud;
    }
    public String getCName() {
        return this.crsName;
    }
    
    public int getCtm() {
        return this.crsTm;
    }
    
    public Room getCrm() {
        return this.room;
    }
    
    public Student getStu() {
        return this.student;
    }

    public boolean empty() {
        if (this.stud.isEmpty())
            return true;
        else 
            return false;
    }
}