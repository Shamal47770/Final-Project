import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
public class GUI extends JFrame {

    ArrayList<Student> students = FileManager.loadStudents();
    ArrayList<Course> courses = new ArrayList<>();
    ArrayList<Enrollment> enrollments = new ArrayList<>();

    JTextArea output;

    public GUI() {
        setTitle("Student Learning System");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JButton addStudentBtn = new JButton("Add Student");
        addStudentBtn.setBounds(20, 20, 150, 30);
        add(addStudentBtn);

        JButton addCourseBtn = new JButton("Add Course");
        addCourseBtn.setBounds(200, 20, 150, 30);
        add(addCourseBtn);

        JButton enrollBtn = new JButton("Enroll");
        enrollBtn.setBounds(20, 60, 150, 30);
        add(enrollBtn);

        JButton showBtn = new JButton("Show Data");
        showBtn.setBounds(200, 60, 150, 30);
        add(showBtn);

        output = new JTextArea();
        output.setBounds(20, 110, 330, 220);
        add(output);

   
        addStudentBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Enter name:");
                String idStr = JOptionPane.showInputDialog("Enter ID:");
                String id = idStr;
                Student s = new Student(name, id);
                students.add(s);
                FileManager.saveStudent(s);
                output.setText("Student added!\n");
            }
        });

       
        addCourseBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cname = JOptionPane.showInputDialog("Course name:");

                courses.add(new Course(cname));

                output.setText("Course added!\n");
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

                String sIndexStr = JOptionPane.showInputDialog("Choose student:\n" + sList);
                int sIndex = Integer.parseInt(sIndexStr);

                String cList = "";
                for (int i = 0; i < courses.size(); i++) {
                    cList += i + ": " + courses.get(i).getCourseName() + "\n";
                }

                String cIndexStr = JOptionPane.showInputDialog("Choose course:\n" + cList);
                int cIndex = Integer.parseInt(cIndexStr);

                Enrollment en = new Enrollment(students.get(sIndex), courses.get(cIndex));
                enrollments.add(en);

                output.setText("Enrolled successfully!\n");
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
