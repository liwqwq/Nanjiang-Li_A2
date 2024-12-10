// Employee.java
public class Employee extends Person {
    private String employeeId;
    private String role;

    // Default constructor
    public Employee() {
        super();  // Call Person's default constructor
        this.employeeId = "Unknown";
        this.role = "Unknown";
    }

    // Parameterized constructor
    public Employee(String name, int age, String gender, String employeeId, String role) {
        super(name, age, gender);  // Call Person's constructor
        this.employeeId = employeeId;
        this.role = role;
    }

    // Getters and setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
