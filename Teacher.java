public class Teacher extends User {

public Teacher(String name, String id) {
    super(name, id);
}
 @Override
    public void displayInfo() {
        System.out.println("Teacher: " + name + " ID: " + id);
    }
}
