import java.util.Scanner;

public class University {
    private Person[] people;
    private int count;
    private Scanner scanner;
    
    public University() {
        people = new Person[10];
        count = 0;
        scanner = new Scanner(System.in);
    }
    // Method for add Persom
    public void addPerson(Person person) {
        if (count >= people.length) {
            Person[] newPeople = new Person[people.length * 2];
            for (int i = 0; i < people.length; i++) {
                newPeople[i] = people[i];
            }
            people = newPeople;
        }
        people[count] = person;
        count++;
    }
    // Method for Student
    public Student[] getAllStudents() {
        Student[] students = new Student[count];
        int studentCount = 0;
        
        for (int i = 0; i < count; i++) {
            if (people[i] instanceof Student) {
                students[studentCount] = (Student) people[i];
                studentCount++;
            }
        }
        
        Student[] result = new Student[studentCount];
        for (int i = 0; i < studentCount; i++) {
            result[i] = students[i];
        }
        
        return result;
    }
    // Method for Employee
    public Employee[] getAllEmployees() {
        Employee[] employees = new Employee[count];
        int employeeCount = 0;
        
        for (int i = 0; i < count; i++) {
            if (people[i] instanceof Employee) {
                employees[employeeCount] = (Employee) people[i];
                employeeCount++;
            }
        }
        
        Employee[] result = new Employee[employeeCount];
        for (int i = 0; i < employeeCount; i++) {
            result[i] = employees[i];
        }
        
        return result;
    }
    //Method for show Alll People
    public void showAllPeople() {
        System.out.println("\n=== ALL PEOPLE ===");
        for (int i = 0; i < count; i++) {
            System.out.println(people[i]);
        }
        System.out.println();
    }
    // Show students
    public void showStudents() {
        Student[] students = getAllStudents();
        System.out.println("\n=== STUDENTS ===");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
    //Method for show Employee
    public void showEmployees() {
        Employee[] employees = getAllEmployees();
        System.out.println("\n=== EMPLOYEES ===");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println();
    }
    // Method for add student
    public void addStudentFromInput() {
        System.out.println("\n=== ADD NEW STUDENT ===");
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter student age: ");
        int age = getValidNumber();
        
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter student major: ");
        String major = scanner.nextLine();
        
        System.out.print("Enter student GPA (0.0-4.0): ");
        double gpa = getValidGPA();
        
        addPerson(new Student(name, age, id, major, gpa));
        System.out.println("Student added successfully!\n");
    }
    
    public void addEmployeeFromInput() {
        System.out.println("\n=== ADD NEW EMPLOYEE ===");
        
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter employee age: ");
        int age = getValidNumber();
        
        System.out.print("Enter employee ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter employee position: ");
        String position = scanner.nextLine();
        
        System.out.print("Enter employee salary: ");
        double salary = getValidDouble();
        
        addPerson(new Employee(name, age, id, position, salary));
        System.out.println("Employee added successfully!\n");
    }
    // Methods for valid number
    //(Farrel,2023)
    private int getValidNumber() {
        while (true) {
            try {
                int number = Integer.parseInt(scanner.nextLine());
                if (number > 0) {
                    return number;
                } else {
                    System.out.print("Please enter a positive number: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
    // Method for Get Valid double
    // (GeeksforGeeks,2024).
    private double getValidDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
    //Method for get valid GpA
    private double getValidGPA() {
        while (true) {
            try {
                double gpa = Double.parseDouble(scanner.nextLine());
                if (gpa >= 1 && gpa <= 4) {
                    return gpa;
                } else {
                    System.out.print("GPA must be between 0.0 and 4.0: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    } 
    public void showMenu() {
        System.out.println("=== UNIVERSITY MANAGEMENT SYSTEM ===");
        System.out.println("1. Add Student");
        System.out.println("2. Add Employee");
        System.out.println("3. View All People");
        System.out.println("4. View Students Only");
        System.out.println("5. View Employees Only");
        System.out.println("6. Exit");
        System.out.print("Choose an option (1-6): ");
    }
    
    public void run() {
        boolean running = true;
        
        
        while (running) {
            showMenu();
            String choice = scanner.nextLine();
            
    // W3Schools.com Switch
            switch (choice) {
                case "1":
                    addStudentFromInput();
                    break;
                case "2":
                    addEmployeeFromInput();
                    break;
                case "3":
                    showAllPeople();
                    break;
                case "4":
                    showStudents();
                    break;
                case "5":
                    showEmployees();
                    break;
                case "6":
                    running = false;
                    System.out.println("Thank you for using University Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1-6.\n");
            }
        }
        scanner.close();
    }
    
    public static void main(String[] args) {
        University university = new University();
        university.run();
    }
}