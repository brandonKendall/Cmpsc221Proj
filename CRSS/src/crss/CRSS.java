package crss;
import java.util.ArrayList;
import java.util.Scanner;

public class CRSS 
{
    static Scanner input = new Scanner(System.in);
    static ArrayList<Student> stud = new ArrayList();
    static ArrayList<Course> crs = new ArrayList();
    static ArrayList<Room> rm = new ArrayList();
    
    public static void main(String[] args) 
    {
          while (true) {
            // choosing whether to add or delete an object
            System.out.print("Welcome to CRSS would you like to add(1), delete(2), or display(3): ");
            int choice = input.nextInt();
            boolean correctChoice = true; // for the while loop to add or del
            switch (choice) {
                case 1:
                    System.out.println("Which object would you like to add?");
                    System.out.print("Room(1), Course(2), Student(3): ");
                    int choice1 = input.nextInt();

                    while (correctChoice) {
                        switch (choice1) {
                            case 1:
                                addRoom();
                                correctChoice = false;
                                break;
                            case 2:
                                addCourse();
                                correctChoice = false;
                                break;
                            case 3:
                                addStudent();
                                correctChoice = false;                             
                                break;
                            default:
                                System.out.println("Didn't choose any of the correct options");
                        }
                    }
                    break;

                case 2:
                    System.out.println("Which object would you like to delete");
                    System.out.print("Room(1), Course(2), Student(3): ");
                    int choice2 = input.nextInt();

                    while (correctChoice) {
                        switch (choice2) {
                            case 1:
                                delRoom();
                                correctChoice = false;
                                break;
                            case 2:
                                delRoom();
                                correctChoice = false;
                                break;
                            case 3:
                                delStudent();
                                correctChoice = false;
                                break;
                            default:
                                System.out.println("Didn't choose any of the correct options");
                        }
                    }
                    break;
                    
                case 3:
                    display();
                    break;

                case 0:
                    System.out.print("Are you sure you want to exit(0 again to exit)");
                    input.nextInt();

                    if (input.nextInt() == 0) 
                        System.exit(0);

                    break;

                default:
                    System.out.println("You didn't pick the correct option");
            }
        }
    }
    
    public static void addRoom() 
    {
        while (true) {
            System.out.print("How many rooms would you like to add? ");
            int numRoom = input.nextInt();
        

            for (int i = 0; i < numRoom; i++) {
                System.out.print("What is the room number of the room you would like to add? ");
                int roomNum = input.nextInt();

                Room room = new Room();
                room.setNum(roomNum);
                
                rm.add(room);
            }
            
            System.out.print("Would you like to exit(0 to exit)");
            int choice = input.nextInt();
            
            if (choice == 0)
                break;
        }
    }
    
    public static void addCourse() 
    {
        while (true) {
            Course course = new Course();
            
            // input course name
            System.out.print("What's the name of the course would you like to add? ");
            String courseName = input.next();
            course.setCName(courseName);
            
            // input course time 
            System.out.print("What time for " + courseName + " (9am-5am): ");
            int courseTime = input.nextInt();
            while (true) {
                try {
                    if (courseTime > 12 || courseTime < 0 || (courseTime < 9 && courseTime > 6));
                    break;
                } catch (Exception E) {
                    System.out.println("Time is out of range please try again");
                    System.out.print("What time for " + courseName + " (9am-5am): ");
                    courseTime = input.nextInt();
                }
            }
            course.setCTm(courseTime);
            
            // input the room for the course
            System.out.println("Empty rooms for the class: ");
            // show open rooms for courses
        
            for (Room i : rm) {
                boolean isFree = i.getCourse().isEmpty(); // for inputting a room

                if (isFree == true)
                    System.out.println(i.getNum());
                else {
                    System.out.println("No rooms available");
                }
            }
            
            // choosing a room
            System.out.print("Please choose one of open rooms: ");
            int rmChoice = input.nextInt();

            for (Room i : rm) {
                boolean isFree = i.getCourse().isEmpty();
                if (isFree == true) {
                    if (i.getNum() == rmChoice) {
                        i.addCourse(course);
                        course.setCrm(i.getNum());
                        break;
                    }
                }
                
            }
            
            System.out.print("Add students to course? (1 for Y/ 0 for N): ");
            int stuChoice = input.nextInt();

            if (stuChoice == 1) {
                for (Student i : stud) {
                    if (stud.isEmpty() == true) {
                        System.out.println("No students currently in system");
                    } else {
                        System.out.println("Displaying students: ");
                        System.out.println(i.getFirst() + " " + i.getLast() + " " + i.getPhone());
                        System.out.print("Enter the students first name: ");
                        String first = input.next();
                        System.out.print("Enter the students last name: ");
                        String last = input.next();

                        for (Student j : stud) {
                            if (j.getFirst().equals(first) && j.getLast().equals(last))
                                j.addCourse(course);
                        }
                    }
                }
                
            }
            
            crs.add(course);
            // to exit add course
            System.out.print("Continue adding courses?(0 to exit): ");
            if (input.nextInt() == 0)
                break;
        
        }
    }
    
    public static void addStudent() 
    {
        while (true) {
            Student student = new Student();
            
            // creating student info
            System.out.print("What is the students first name? ");
            String studentF = input.next();
            System.out.print("What is the students last name? ");
            String studentL = input.next();
            
            // check if student is in list already
            boolean isThere = false;
            
            for (Student i : stud) {
                if (i.getFirst().equals(studentF)) {
                    if (i.getLast().equals(studentL)) {
                        System.out.println("Student is already in the system!");
                        isThere = true;
                        break;
                    }
                }
            }
            // student phone number
            System.out.print("What is the students phone number? ");
            String studentPhone = input.next();
            
            while(true) {
                try {
                    if(studentPhone.length() == 10)
                        break;
                } catch(Exception E) {
                    System.out.println("Number not correct length!");
                    System.out.print("What is the students phone number? ");
                    studentPhone = input.next();
                }
            }
            
            student.setFirst(studentF);
            student.setLast(studentL);
            student.setPhone(studentPhone);
            
            stud.add(student);
            
            System.out.print("Would you like to add another student(press anything) or exit(0)? ");
            if (input.nextInt() == 0)
                break;
        }
    }
    
    public static void delRoom() 
    {
        while (true) {
            
            boolean canDel = false;
            
            // displays rooms with no courses
            System.out.println("Displaying rooms that can be deleted: "); 
            for (Room i : rm) {
                boolean isFree = i.getCourse().isEmpty();
                
                if (isFree == true) {
                    System.out.println(i.getNum());
                    canDel = true;
                }
                else if (isFree == false)
                    System.out.println("Nothing to be deleted");
                
            }
            
            if (canDel == true) {
                System.out.print("Enter a room number to be deleted: ");
                int roomNum = input.nextInt();
                
                while (true) {
                    try {
                        roomNum = input.nextInt();
                    } catch (Exception E) {
                        if (roomNum != input.nextInt()) {
                            System.out.print("Not a room number");
                            System.out.print("Enter a room number to be deleted: ");
                            roomNum = input.nextInt();
                        }
                        else {
                            roomNum = input.nextInt();
                            break;
                        }                
                    }
                }

                for (Room i : rm) {
                    boolean isFree = i.getCourse().isEmpty();
                    if (isFree == true) {
                        if (roomNum == i.getNum()) {
                            rm.remove(i);
                            System.out.println("You've removed " + roomNum);
                            break;
                        }
                    }
                }
            }
            
            System.out.print("Exit(0) or Delete some more(anything): ");
            if (input.nextInt() == 0)
                break;
        }
    }
    
    public static void delCourse() 
    {
        while (true) {
            
            boolean canDel = false;
            
            // present courses with no students
            System.out.println("Courses that can be deleted: ");
            for (Course i : crs) {
                if ( i.isEmpty() ) {
                    System.out.println( i.getCName() );
                    canDel = true;
                }
                else if ( !i.isEmpty() )
                    System.out.println("Nothing to be deleted.");
                
            }
            
            // if something can be deleted prompt the user
            if (canDel == true) 
            {
                System.out.print("Choose a course to be deleted: ");
                String courseName = input.next();
                if (!courseName.equals(input.next()))
                    throw new IllegalArgumentException("Wrong value for name!");
                for (Course i :crs) {
                    if (i.isEmpty() == true) {
                        if (courseName.equals(i.getCName())) {
                            crs.remove(i);
                            break;
                        }
                    }
                }
                
            }
            
            System.out.print("Exit(0) or Delete some more(anything): ");
            if (input.nextInt() == 0)
                break;        
        }
    }
    
    public static void delStudent() 
    {
        while (true) {

            boolean canDel = false;
            
            // show students with no courses
            System.out.println("Students that can be deleted: ");
            for (Student i : stud) {
                if ( i.empty() ) {
                    System.out.println(i.getFirst() + i.getLast());
                    canDel = true;
                }
                else if ( !i.empty() )
                    System.out.println("Nothing to be deleted.");
            }
            
            // if can delete then present prompt
            if (canDel == true) 
            {
                System.out.print("Please enter a first name to be deleted: ");
                String studentF = input.next();
                System.out.print("Please enter a last name to be deleted: ");
                String studentL = input.next();

                for (Student i : stud) {
                    if ( i.empty() ) {
                        if (studentF.equals(i.getFirst()) && studentL.equals(i.getLast())) {
                            stud.remove(i);
                            break;
                        }
                    }
                }
                
            }
            
            System.out.print("Exit(0) or Delete some more(anything): ");
            if (input.nextInt() == 0)
                break;      
        }
    }
    
    public static void display() 
    {
        while (true) {
            System.out.print("Display Course(0), Student Schedule(1), Rooms(2): ");
            int choice = input.nextInt();
            
            while (true) {
                try {
                    choice = input.nextInt();
                    break;
                } catch(Exception E) {
                    System.out.println("Not a number!");
                    System.out.print("Display Course(0), Student Schedule(1), Rooms(2), Exit(3): ");
                    choice = input.nextInt();
                }
            }
            
            switch(choice) {
                // display courses
                case 0:
                    while (true) {
                        System.out.print("Display All Courses(0) or at a specific time(1): ");
                        int courseChoice = input.nextInt();
                    
                        switch (courseChoice) {
                            // displaying all courses
                            case 0:
                                System.out.println("Displaying all of the courses: ");
                                for (Course i : crs) {
                                    System.out.println(i.getCName() + " " + 
                                            i.getCtm() + " " + i.getCrm());
                                }
                                
                                break;
                                
                            case 1:
                                // displaying times at specific time
                                // input course time
                                System.out.print("What time for (9am-5am): ");
                                int courseTime = input.nextInt();

                                while (true) {
                                    try {
                                        if (courseTime > 12 || courseTime < 0 || (courseTime < 9 && courseTime > 6));
                                            break;
                                    } catch (Exception E) {
                                        System.out.println("Time is out of range please try again");
                                        System.out.print("What time for (9am-5am): ");
                                        courseTime = input.nextInt();
                                    }
                                }
                                    for (Course i : crs) {
                                        if (i.getCtm() == courseTime)
                                            System.out.println(i.getCName() + " " + i.getCtm() + " " + i.getCrm());
                                    }   
                                break;
                                
                            default:
                                // if not correct choice
                                System.out.println("Incorrect choice");
                                
                        }
                        
                        System.out.print("Exit(0) or continue(anything): ");
                        if (input.nextInt() == 0) 
                            break;
                    }
                    break;
                    
                case 1:
                    // display the current students
                    while (true) {
                        System.out.println("Displaying current students: ");
                        for (Student i : stud) {
                            if (i.empty() == false)
                                System.out.println(i.getFirst() + " " + i.getLast() + " " + i.getPhone());
                            else {
                                System.out.println("There are no current registered students");
                                break;
                            }
                        }
                        
                        System.out.print("Would you like to display a current student schedule(Y/N): ");
                        if ("Y".equals(input.next()) || "y".equals(input.next())) {
                            System.out.print("Enter the students first name: ");
                            String first = input.next();
                            System.out.print("Enter the students last name: ");
                            String last = input.next();
                            
                            for (Student i : stud) {
                                if (i.getFirst().equals(first) && i.getLast().equals(last)) {
                                    System.out.println(first + " " + last + " scedule: ");
                                    // put students courses in arraylist for display
                                    ArrayList<Course> studentsCourse = i.getCourse();
                                    
                                    for (Course j : studentsCourse) {
                                        System.out.println(j.getCName() + " " + j.getCrm() + " " + j.getCtm());
                                    }
                                    
                                }
                                break;
                            }
                        }
                        
                        System.out.print("Exit(0) or continue(anything): ");
                        if (input.nextInt() == 0) 
                            break;
                    }
                    break;
                    
                case 2:
                    while (true) {
                        // display rooms with courses
                        System.out.println("Rooms with courses: ");
                        
                        for (Room i : rm) {
                            boolean isFree = i.getCourse().isEmpty();
                            if (isFree == false) {
                                System.out.println(i.getNum());
                            }
                        }
                        
                        System.out.print("Select room number for courses in it: ");
                        int roomNum = input.nextInt();
                        
                        for (Room i : rm) {
                            if (i.getNum() == roomNum) {
                                // for display courses
                                ArrayList<Course> courseList = i.getCourse();
                                System.out.println("Displaying courses for " + i.getNum());
                                for (Course j : courseList) {
                                    System.out.println(j.getCName() + " " + j.getCtm());
                                }
                                break;
                            }
                        }
                        
                        System.out.print("Exit(0) or continue(anything): ");
                        if (input.nextInt() == 0) 
                            break;
                    }
                    break;
                    
                default:
                    System.out.println("Didn't press correct option!");
            }
            
            System.out.print("Exit(0) or Delete some more(anything): ");
            if (input.nextInt() == 0)
                break; 
        }
    }
}
