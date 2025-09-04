    public class Employee extends Person {
    private String position;
    private double salary;
    
    public Employee(String name, int age, String id, String position, double salary) {
        super(name, age, id);
        this.position = position;
        this.salary = salary;
    }
    
    public String getPosition() {
        return position;
    }
    
    public double getSalary() {
        return salary;
    }
    
    @Override
    public String getRole() {
        return "Employee";
    }
    
    @Override
    public void introduce() {
        super.introduce();
        System.out.println("I work as " + position + " and earn $" + salary);
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Position: " + position + ", Salary: $" + salary;
    }
}