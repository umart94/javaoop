import java.util.List;

public class Institute {

    public String instituteName;
    private List<Department> departments;

    public Institute(String instituteName, List<Department> departments) {
        this.instituteName = instituteName;
        this.departments = departments;
    }

    //count total students of all departments in institute

    public int getTotalStudentsInInstitute(){

        int numOfStudewnts = 0;
        List<Student> students;
        for(Department dept : departments){

            students = dept.getStudents();
            for(Student s : students){
                numOfStudewnts++;
            }
        }
        return numOfStudewnts;
    }

}
