public class AssignmentTwo {
    public static void main(String[] args) {
        // Create objects for testing
        Employee employee = new Employee("John Doe", 30, "123 Park Lane", "Ride Operator", 45000);
        Visitor visitor1 = new Visitor("Jane Smith", 25, "456 Oak Street", "VIP", true);
        Visitor visitor2 = new Visitor("Tom Brown", 40, "789 Maple Ave", "Standard", false);
        Visitor visitor3 = new Visitor("Sarah Johnson", 30, "101 Pine Street", "Standard", false);
        Visitor visitor4 = new Visitor("Mark Lee", 22, "202 Cedar Road", "VIP", true);
        Visitor visitor5 = new Visitor("Emily Davis", 27, "303 Birch Blvd", "Standard", false);
        
        // Create a Ride object
        Ride ride = new Ride("Roller Coaster", "Thrill", employee);
        
        // Add visitors to the queue
        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);
        ride.addVisitorToQueue(visitor3);
        ride.addVisitorToQueue(visitor4);
        ride.addVisitorToQueue(visitor5);
        
        // Print the queue
        ride.printQueue();
        
        // Remove a visitor from the queue
        ride.removeVisitorFromQueue(visitor3); // Remove Sarah Johnson
        // Print the queue after removal
        ride.printQueue();
        
        // Run the ride for one cycle
        ride.runOneCycle(); // Run the ride for the first visitor
        
        // Print the ride history
        ride.printRideHistory();
        
        // Check if a visitor is in the history
        System.out.println("Is Jane Smith in the ride history? " + ride.checkVisitorFromHistory(visitor1));
        
        // Display the number of visitors in the history
        System.out.println("Number of visitors in the ride history: " + ride.numberOfVisitors());
        
        // Part 4A demonstration
        partFourA(ride); // Call the method to demonstrate Part 4A functionality
    }

    // Method for Part 4A demonstration
    public static void partFourA(Ride ride) {
        // Add visitors to the ride history using runOneCycle
        System.out.println("\nDemonstrating Part 4A:");
        ride.runOneCycle(); // First visitor
        ride.runOneCycle(); // Second visitor
        ride.runOneCycle(); // Third visitor
        ride.runOneCycle(); // Fourth visitor
        ride.runOneCycle(); // Fifth visitor
        
        // Print the number of visitors in the ride history
        System.out.println("Number of visitors in the ride history: " + ride.numberOfVisitors());
        
        // Print the details of all visitors in the ride history
        ride.printRideHistory();
        
        // Check if a visitor is in the ride history
        Visitor checkVisitor = new Visitor("Tom Brown", 40, "789 Maple Ave", "Standard", false);
        System.out.println("Is Tom Brown in the ride history? " + ride.checkVisitorFromHistory(checkVisitor));
    }
    public static void partFive() {
    Employee employee = new Employee("John Doe", 30, "123 Park Lane", "Ride Operator", 45000);
    

    Ride ride = new Ride("Roller Coaster", "Thrill", employee, 5);
    

    for (int i = 1; i <= 10; i++) {
        Visitor visitor = new Visitor("Visitor " + i, 20 + i, "Address " + i, "Standard", false);
        ride.addVisitorToQueue(visitor);
    }
    

    System.out.println("Visitors in the queue:");
    ride.printQueue();
    
 
    ride.runOneCycle();
    
   
    System.out.println("Visitors in the queue after one cycle:");
    ride.printQueue();
    

    System.out.println("Visitors in the ride history:");
    ride.printRideHistory();
}
    public static void partSix() {
    // Create a new Ride object
    Employee employee = new Employee("John Doe", 30, "123 Park Lane", "Ride Operator", 45000);
    Ride ride = new Ride("Ferris Wheel", "Family", employee);
    
    // Add visitors to the ride history
    Visitor visitor1 = new Visitor("Alice", 28, "123 Apple St", "VIP", true);
    Visitor visitor2 = new Visitor("Bob", 22, "456 Banana Ave", "Standard", false);
    Visitor visitor3 = new Visitor("Charlie", 35, "789 Cherry Blvd", "Standard", false);
    Visitor visitor4 = new Visitor("David", 22, "101 Date Rd", "VIP", true);
    Visitor visitor5 = new Visitor("Eve", 30, "202 Elderberry Ct", "Standard", false);
    
    ride.addVisitorToHistory(visitor1);
    ride.addVisitorToHistory(visitor2);
    ride.addVisitorToHistory(visitor3);
    ride.addVisitorToHistory(visitor4);
    ride.addVisitorToHistory(visitor5);
    
    // Export the Visitors to a file
    ride.exportRideHistory("rideHistory.txt");
}
}
