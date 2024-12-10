public class AssignmentTwo {
    public static void main(String[] args) {
        // Create objects for testing
        Employee employee = new Employee("John Doe", 30, "123 Park Lane", "Ride Operator", 45000);
        Visitor visitor1 = new Visitor("Jane Smith", 25, "456 Oak Street", "VIP", true);
        Visitor visitor2 = new Visitor("Tom Brown", 40, "789 Maple Ave", "Standard", false);

        // Create a Ride object
        Ride ride = new Ride("Roller Coaster", "Thrill", employee);

        // Add visitors to the queue
        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);

        // Display queue
        ride.printQueue();

        // Run the ride for one cycle
        ride.runOneCycle();

        // Display ride history
