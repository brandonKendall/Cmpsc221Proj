package crss;

import java.util.ArrayList;

public class Course {
    // instance vars
    private String crsName;
    private int crsTm;
    private int rm;
    // these are for storing the instance of students in the course
    private Student student;
    private ArrayList<Student> stud = new ArrayList<>();
    private Room room;

    public Course() {}
    
    // class constructor
    public Course(String crsName, int crsTime, Room room) {
        this.crsName = crsName;
        this.crsTm = crsTm;
        this.room = room;
    }

    public Course(String crsName, int crsTime, Room room, ArrayList<Student> stud) {
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
        if (crsTm > 9.00 && crsTm < 17.00) {
            this.crsTm = crsTm;
        }
    }
    
    public void setCrm(int rm) {
        this.rm = rm;
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
    
    public Room getCrm() {
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