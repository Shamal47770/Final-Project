import java.io.*;
import java.util.ArrayList;
public class FileManager {
 public static void saveStudent(Student s) {
        try {
            FileWriter writer = new FileWriter("students.txt", true);
            writer.write(s.getName() + "," + s.getId() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving file");
        }
    }
    public static ArrayList<Student> loadStudents() {
        ArrayList<Student> list = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                String id = parts[1];

                list.add(new Student(name, id));
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("No file yet");
        }

        return list;
    }
}
