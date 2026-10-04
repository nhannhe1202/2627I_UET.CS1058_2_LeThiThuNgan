import java.io.*;
import java.util.*;

class Student{
    private int id;
    private String name;
    private double gpa;
    public Student(int id, String name, double gpa){
        this.id=id;
        this.name=name;
        this.gpa=gpa;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public double getGpa(){
        return gpa;
    }
    @Override
    public String toString(){
        return name;
    }
}
public class JavaSort {
    public static void main(String[] args){
        List<Student> studentList = new ArrayList<>();
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();

            double gpa = sc.nextDouble();
            studentList.add(new Student(id, name, gpa));
            sc.nextLine();
        }
        studentList.sort((s1, s2) -> {
            int gpaCompare = Double.compare(s2.getGpa(), s1.getGpa());
            if(gpaCompare !=0 ){
                return gpaCompare;
            }
            int nameCompare = s1.getName().compareTo(s2.getName());

            if (nameCompare != 0) {
                return nameCompare;
            }
            return Integer.compare(s1.getId(), s2.getId());
        });
        for (Student st : studentList) {
            System.out.println(st);
        }

        sc.close();
    }
}
