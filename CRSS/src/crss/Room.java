package crss;

import java.util.ArrayList;

public class Room 
{
    // instance vars
    private int rmNum, rmClass;
    private ArrayList<Course> course = new ArrayList<>();

    // class constructor
    public Room() {}

    public Room(int rmNum) {
        this.rmNum = rmNum;
    }
    
    // getters and setters
    public void setNum(int rmNum) {
        this.rmNum = rmNum;
    }
    
    public void setClass(int rmClass) {
        this.rmClass = rmClass;
    }
    
    public int getClassNum() {
        return rmClass;
    }
    
    public int getNum() {
        return rmNum;
    }
    
    public void addCourse(Course crs) {
        course.add(crs);
    }
    public ArrayList<Course> getCourse() {
        return this.course;
    }
}