import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)


    {
        //Has-A
        // Uni-Directional
        //Association
        //Department can have students
        //Students cannot have departments
        //and vice versa

        Student s1 = new Student("sadaf",1,"CS");
        Student s2 = new Student("ambreen",2,"CS");
        Student s3 = new Student("Umar",3,"CS");
        Student s4 = new Student("talha",4,"CS");
        Student s5 = new Student("tariq",5,"CS");

        List<Student> CS_Students = new ArrayList<Student>();
        CS_Students.add(s1);
        CS_Students.add(s2);
        CS_Students.add(s3);
        CS_Students.add(s4);
        CS_Students.add(s5);


        Student s6 = new Student("sadaf",6,"EE");
        Student s7 = new Student("ambreen",7,"EE");
        Student s8 = new Student("Umar",8,"EE");
        Student s9 = new Student("talha",9,"EE");
        Student s10 = new Student("tariq",10,"EE");

        List<Student> EE_Students = new ArrayList<Student>();
        EE_Students.add(s6);
        EE_Students.add(s7);
        EE_Students.add(s8);
        EE_Students.add(s9);
        EE_Students.add(s10);

        Department CS_dept = new Department("CS",CS_Students);
        Department EE_dept = new Department("EE",EE_Students);

        List<Department> departments = new ArrayList<Department>();
        departments.add(CS_dept);
        departments.add(EE_dept);

        Institute instituteObj = new Institute("BUKC",departments);
        System.out.println("Total students :");
        System.out.println(instituteObj.getTotalStudentsInInstitute());


    }
}
