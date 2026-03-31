public abstract class User {
    protected String name;
    protected String id;
    public User(String name, String id) { 
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
     public abstract void displayInfo();
}
