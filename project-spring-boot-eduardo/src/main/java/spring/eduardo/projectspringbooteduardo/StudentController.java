package spring.eduardo.projectspringbooteduardo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentController {
    @GetMapping("/students")
    public List<Students> student() throws IOException {
        return readData();
    }

    Scanner sc = new Scanner(System.in);

    @GetMapping("/students/{first_name}")
    public Students student(@PathVariable String first_name) throws IOException {
        System.out.println("search student by first name: " + first_name);
        List<Students> students = readData();
        System.out.println("Enter a student name to search: ");
        String name = sc.nextLine();
        for (Students student : students) {
            if (student.getFirst_name().equals(name)) {
                System.out.println("Found!");
                break;
            }
        }

    }

    @GetMapping("/students/{course}")
    public Students student(@RequestParam List<Course> course) throws IOException {
        System.out.println("search student by course: " + course);
        List<Students> students = readData();
        System.out.println("Enter a course number to search: ");
        String courseN = sc.nextLine();
        for (Students student : students) {
        if(student.getCourse() != null) {
            for (Course cr : student.getCourse()) {
                if(courseN.equals(cr.getCourseNo())){
        System.out.println("Course found!");
                break;
                    }
        
        }
    System.out.println("GPA of each student:");
        for (Students studentG : students) {
            double total = 0;
        if(student.getCourse() != null){
                for (Course courseG : student.getCourse()) {
                    total += getMarksFromGrades(courseG.getGrade());
                }
            }
        // number of courses for students
        int count = student.getCourse() == null ? 0 : student.getCourse().size();
        // calculate average
        if (count != 0) {
            total = total / count;
        }
        System.out.printf("GPA of %s is %.2f\n", student.getFirst_name(), total);
        }
    }

    private double getMarksFromGrades(String grade) {
        return 0;
    }

    public List<Students> readData() throws IOException {
        FileReader fileReader = new FileReader("src/main/resources/student.json");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<Students> studentList = new ArrayList();
        List<Course> courseList = new ArrayList();

        String header = bufferedReader.readLine();
        String line = bufferedReader.readLine();

        while (line != null) {
            String[] data = line.split(",");
            Course course = new Course(data[2], line, 0);
            courseList.add(course);
            Students students = new Students(data[0], Integer.parseInt(data[1]), courseList, null);
            studentList.add(student(null));
            line = bufferedReader.readLine();
            courseList = new ArrayList();
        }
        return studentList;

    }
}