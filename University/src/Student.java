  public class Student extends Person {
    private String major;
    private double gpa;
    
    public Student(String name, int age, String id, String major, double gpa) {
        super(name, age, id);
        this.major = major;
        this.gpa = gpa;
    }
    
    public String getMajor() {
        return major;
    }
    
    public double getGpa() {
        return gpa;
    }
    
    @Override
    public String getRole() {
        return "Student";
    }
    
    @Override
    public void introduce() {
        super.introduce();
        System.out.println("I study " + major + " and my GPA is " + gpa);
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Major: " + major + ", GPA: " + gpa;
    }
}