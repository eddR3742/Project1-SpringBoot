package spring.eduardo.projectspringbooteduardo;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotaion.Autowired;
import java.util.ArrayList;
import java.util.List;

@Component
public class Students {

    private double gpa;
    private String first_name;
    private String email;
    private String gender;
    private List<Course> course;

    public Students(String first_name, double gpa, String email, String gender, List<Course> course) {

        this.first_name = first_name;
        this.gpa = gpa;
        this.email = email;
        this.gender = gender;

    }

    public Students(String string, int parseInt, List<Course> courseList, Object object) {
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(ArrayList<Course> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student [first_name=" + first_name + ", gpa=" + gpa + ", email=" + email + ", gender="
                + gender + "]";
    }
}
