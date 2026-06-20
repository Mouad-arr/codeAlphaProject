package codealphaproject.Task1;

import java.util.ArrayList;
import java.util.List;


public class Student {
    private String name;
    private double grade ;
    
    static int count =0;
    static private List<Student> stds = new ArrayList<>();
    
    public Student(){
        Student.count++;
    }
    
    public Student(String name,double grade){
        this.name=name;
        this.grade=grade;
        Student.count++;
    }
    
    
    public void setGrade(double grade){
        this.grade=grade;
    }
    public void setName(String name){
        this.name=name;
    }
    public double getGrade(){
        return this.grade;
    }
    public String getName(){
        return this.name;
    }
    
    public static double getAverage(){
        if(Student.count==0){
            System.out.println("No students yet ! ");
            return 0;
        }
        double avg=0;
        for(Student s:Student.stds){
            avg+= (s.getGrade()/Student.count);
        }
        return avg;
    }
    public static Student getHighest(){
        if(Student.count==0){
            System.out.println("No students yet ! ");
            return null;
        }
        double highest=stds.get(0).getGrade();
        Student highestStd = stds.get(0);
        for(Student s:stds){
            if(highest < s.getGrade()){
                highest=s.getGrade();
                highestStd=s;
            }
        }
        return highestStd;
    }
    public static double getMax(){
        return Student.getHighest().getGrade();
    }
    public static Student getLowest(){
        if(Student.count==0){
            System.out.println("No students yet ! ");
            return null;
        }
        double lowest=stds.get(0).getGrade();
        Student lowestStd = stds.get(0);
        for(Student s:stds){
            if(lowest > s.getGrade()){
                lowest=s.getGrade();
                lowestStd=s;
            }
        }
        return lowestStd;
    }
    public static double getMin(){
        return Student.getLowest().getGrade();
    }
    public static void addStudent(Student s){
        stds.add(s);
    }
    public static Student searchStudent(String name){
        for(Student s:stds){
            if(s.getName().equals(name))
                return s;
        }
        return null;
    }
    
    public static void displaySummaryReport(){
        System.out.println("-----------------------------------------------------");
        System.out.println("Student                 Grade    ");
        for(Student s:stds ){
            System.out.println(s.getName()+"                 "+s.getGrade());
        }
         System.out.println("--------------------"+"Avg = "+String.format("%.2f",Student.getAverage())+"---------------------------------");
         System.out.println("Lowest Student : "+Student.getLowest() );
         System.out.println("Higest Student : "+Student.getHighest());
    }
    
    public static List<Student> getStudents(){
        return Student.stds;
    }
    @Override
    public  String toString(){
        return "Name : "+this.name +" , Grade : "+this.grade ;
    }
}
