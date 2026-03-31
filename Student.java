public class Student extends User {

    public Student(String name, String id) {
        super(name, id);
    }
    @Override
    public void displayInfo() {
        System.out.println("Student: " + name + " ID: " + id);
    }
}
