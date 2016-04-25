package crss;

import java.util.ArrayList;

public class Room 
{
    // instance vars
    private int rmNum;
    private ArrayList<Course> course = new ArrayList<>();
    private boolean empty;

    // class constructor
    public Room() {}

    public Room(int rmNum) {
        this.rmNum = rmNum;
        this.course = course;
        this.empty = true;
    }
    
    // getters and setters
    public void setNum(int rmNum) {
        this.rmNum = rmNum;
    }
    
    public int getNum() {
        return rmNum;
    }
    
    public boolean addCourse(Course crs) {
        if (course.contains(crs)) {
            return false;
        }
        else {
            for (Course c : course) {
                if(c.getCtm() == crs.getCtm()) {
                    return false;
                }
            }
        }
        course.add(crs);
        this.empty = false;
        return true;
    }
    
    public ArrayList<Course> getCourse() {
        return this.course;
    }
    
    public boolean empty() {
        return this.empty;
    }
}