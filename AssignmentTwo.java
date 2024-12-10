// AssignmentTwo.java
public class AssignmentTwo {
    public static void main(String[] args) {
        // This is where you can create and manipulate objects for each class
        Employee employee1 = new Employee("John Doe", 30, "Male", "E123", "Ride Operator");
        Visitor visitor1 = new Visitor("Jane Smith", 25, "Female", "V456", "VIP");
        Ride ride1 = new Ride("Roller Coaster", 20, employee1);
        
        // Display some information
        System.out.println("Ride Name: " + ride1.getRideName());
        System.out.println("Operator: " + ride1.getRideOperator().getName());
        System.out.println("Visitor: " + visitor1.getName() + ", Ticket Number: " + visitor1.getTicketNumber());
    }

    public void partThree() {
        // Code for part 3 (e.g., more functionality or tests)
    }

    public void partFourA() {
        // Code for part 4A (e.g., testing or additional functionality)
    }

    public void partFourB() {
        // Code for part 4B (e.g., testing or additional functionality)
    }

    public void partFive() {
        // Code for part 5
    }

    public void partSix() {
        // Code for part 6
    }

    public void partSeven() {
        // Code for part 7
    }
}
