import java.io.*;
import java.util.ArrayList;

public class FileManager {



    public static void saveStudent(Student s) {
        try {
            FileWriter writer = new FileWriter("students.txt", true);
            writer.write(s.getName() + "," + s.getId() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving student");
        }
    }

    public static ArrayList<Student> loadStudents() {
        ArrayList<Student> students = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                students.add(new Student(parts[0], parts[1]));
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("No students file yet");
        }

        return students;
    }

    public static void saveAllStudents(ArrayList<Student> students) {
        try {
            FileWriter writer = new FileWriter("students.txt"); 

            for (Student s : students) {
                writer.write(s.getName() + "," + s.getId() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving students");
        }
    }



    public static void saveCourse(Course c) {
        try {
            FileWriter writer = new FileWriter("courses.txt", true);
            writer.write(c.getCourseName() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving course");
        }
    }

    public static ArrayList<Course> loadCourses() {
        ArrayList<Course> courses = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("courses.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                courses.add(new Course(line));
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("No courses file yet");
        }

        return courses;
    }

    public static void saveAllCourses(ArrayList<Course> courses) {
        try {
            FileWriter writer = new FileWriter("courses.txt");

            for (Course c : courses) {
                writer.write(c.getCourseName() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving courses");
        }
    }
}
