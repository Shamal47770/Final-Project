import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI extends JFrame {

    ArrayList<Student> students = FileManager.loadStudents();
    ArrayList<Course> courses = FileManager.loadCourses();
    ArrayList<Enrollment> enrollments = new ArrayList<>();

    JTextArea output;

    public GUI() {
        setTitle("Student Learning System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JButton addStudentBtn = new JButton("Add Student");
        addStudentBtn.setBounds(20, 20, 150, 30);
        add(addStudentBtn);

        JButton deleteStudentBtn = new JButton("Delete Student");
        deleteStudentBtn.setBounds(20, 60, 150, 30);
        add(deleteStudentBtn);

        JButton addCourseBtn = new JButton("Add Course");
        addCourseBtn.setBounds(200, 20, 150, 30);
        add(addCourseBtn);

        JButton deleteCourseBtn = new JButton("Delete Course");
        deleteCourseBtn.setBounds(200, 60, 150, 30);
        add(deleteCourseBtn);

        JButton enrollBtn = new JButton("Enroll");
        enrollBtn.setBounds(380, 20, 150, 30);
        add(enrollBtn);

        JButton showBtn = new JButton("Show Data");
        showBtn.setBounds(380, 60, 150, 30);
        add(showBtn);

        output = new JTextArea();
        output.setBounds(20, 110, 510, 220);
        add(output);

        
        addStudentBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Enter name:");
                String id = JOptionPane.showInputDialog("Enter ID:");

                Student s = new Student(name, id);
                students.add(s);
                FileManager.saveStudent(s);

                output.setText("Student added!");
            }
        });

        
        deleteStudentBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (students.size() == 0) {
                    output.setText("No students to delete!");
                    return;
                }

                String list = "";
                for (int i = 0; i < students.size(); i++) {
                    list += i + ": " + students.get(i).getName() + "\n";
                }

                try {
                    int index = Integer.parseInt(
                        JOptionPane.showInputDialog("Choose student:\n" + list)
                    );

                    students.remove(index);
                    FileManager.saveAllStudents(students);

                    output.setText("Student deleted!");
                } catch (Exception ex) {
                    output.setText("Invalid input!");
                }
            }
        });

        
        addCourseBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cname = JOptionPane.showInputDialog("Course name:");

                Course c = new Course(cname);
                courses.add(c);
                FileManager.saveCourse(c);

                output.setText("Course added!");
            }
        });

      
        deleteCourseBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (courses.size() == 0) {
                    output.setText("No courses to delete!");
                    return;
                }

                String list = "";
                for (int i = 0; i < courses.size(); i++) {
                    list += i + ": " + courses.get(i).getCourseName() + "\n";
                }

                try {
                    int index = Integer.parseInt(
                        JOptionPane.showInputDialog("Choose course:\n" + list)
                    );

                    courses.remove(index);
                    FileManager.saveAllCourses(courses);

                    output.setText("Course deleted!");
                } catch (Exception ex) {
                    output.setText("Invalid input!");
                }
            }
        });

        
        enrollBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (students.size() == 0 || courses.size() == 0) {
                    output.setText("Add students and courses first!");
                    return;
                }

                String sList = "";
                for (int i = 0; i < students.size(); i++) {
                    sList += i + ": " + students.get(i).getName() + "\n";
                }

                int sIndex = Integer.parseInt(
                    JOptionPane.showInputDialog("Choose student:\n" + sList)
                );

                String cList = "";
                for (int i = 0; i < courses.size(); i++) {
                    cList += i + ": " + courses.get(i).getCourseName() + "\n";
                }

                int cIndex = Integer.parseInt(
                    JOptionPane.showInputDialog("Choose course:\n" + cList)
                );

                enrollments.add(new Enrollment(
                    students.get(sIndex),
                    courses.get(cIndex)
                ));

                output.setText("Enrolled successfully!");
            }
        });

       
        showBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String text = "Students:\n";
                for (Student s : students) {
                    text += s.getName() + "\n";
                }

                text += "\nCourses:\n";
                for (Course c : courses) {
                    text += c.getCourseName() + "\n";
                }

                output.setText(text);
            }
        });
    }

    public static void main(String[] args) {
        new GUI().setVisible(true);
    }
}
