
package codealphaproject.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String []args){
    Scanner in = new Scanner(System.in);
    
    
    do {
        int choise;
        System.out.println("-------------- Menu ---------- ");
        System.out.println("1: Add Student ");
        System.out.println("2 : Search a student ");
        System.out.println("3 : Display a summary report of all students ");
        System.out.println("4 : Display a summary report of all students and exit");
        System.out.println("5 : exit ");
        System.out.print("choise : ");
        while(!in.hasNextInt()){
            System.out.println("Choise must be an integer !");
            in.nextLine();
        }
        choise = in.nextInt();
        switch(choise){
            case 1:
                String name;
                double grade ;
                System.out.print("Name : ");
                in.nextLine();
                name=in.nextLine();
                System.out.print("Grae : ");
                grade=in.nextDouble();
                Student.addStudent(new Student(name,grade));
                System.out.println("Student added succefully ! ");
                break;
            case 2 :
                System.out.print("Name : ");
                in.nextLine();
                name=in.nextLine();
                Student s = Student.searchStudent(name);
                if(s==null){
                    System.out.println("Student doesn't existe ! ");
                }
                else{
                    System.out.println(s);
                }
                break;
            case 3 :
                Student.displaySummaryReport();
                break;
            case 4 : 
                Student.displaySummaryReport();
                in.close();
                System.exit(0);
            case 5 :
                in.close();
               System.exit(0);
            default :
                System.out.println("Invalid choise  !");
        }
    }while(true);
    }
}
