package phase2;

import crss.*;
import java.util.ArrayList;

public class Student {
    // instance vars
    private String stuFirst, stuLast, stuPhone;
    private ArrayList<Course> course = new ArrayList<>();
    private Course crs;
    // class constructor
    public Student(String stuFirst, String stuLast, String stuPhone) {
        course = new ArrayList<>();
        this.stuFirst = stuFirst;
        this.stuLast = stuLast;
        this.stuPhone = stuPhone;
    }
    
    // getters and setters
    public void setFirst(String stuFirst) {
        this.stuFirst = stuFirst;
    }
    
    public void setLast(String stuLast) {
        this.stuLast = stuLast;
    }
    
    public void setPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }
    
    public String getFirst() {
        return stuFirst;
    }
    
    public String getLast() {
        return stuLast;
    }
    
    public String getPhone() {
        return stuPhone;
    }
    
    public ArrayList<Course> getCourse() {
        return this.course;
    }
    
    public void addCourse(Course crs) {
        course.add(crs);
    }
    public boolean isEmpty() {
        if (this.course.isEmpty())
            return true;
        else
            return false;
    }
}