    public class Person {
    private String name;
    private int age;
    private String id;
    
    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getId() {
        return id;
    }
    
    public String getRole() {
        return "Person";
    }
    
    public void introduce() {
        System.out.println("Hello, I'm " + name);
    }
    
    public String toString() {
        return name + " (ID: " + id + ", Age: " + age + ")";
    }
}