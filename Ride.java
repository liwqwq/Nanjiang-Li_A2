import java.util.*;

// Updated Ride class implementing the Queue interface
public class Ride implements RideInterface {
    private String rideName;
    private String rideType;
    private Employee rideOperator;
    private Queue<Visitor> queue = new LinkedList<>(); // Use LinkedList to implement Queue
    private List<Visitor> rideHistory = new LinkedList<>(); // Use LinkedList for the ride history

    // Default constructor
    public Ride() {
        this.rideName = "Unknown";
        this.rideType = "Unknown";
        this.rideOperator = null;
    }

    // Parameterized constructor
    public Ride(String rideName, String rideType, Employee rideOperator) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.rideOperator = rideOperator;
    }

    // Getters and setters
    public String getRideName() {
        return rideName;
    }
    public void setRideName(String rideName) {
        this.rideName = rideName;
    }
    public String getRideType() {
        return rideType;
    }
    public void setRideType(String rideType) {
        this.rideType = rideType;
    }
    public Employee getRideOperator() {
        return rideOperator;
    }
    public void setRideOperator(Employee rideOperator) {
        this.rideOperator = rideOperator;
    }

    // Implementing methods from RideInterface

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            queue.add(visitor); // Add visitor to the queue
            System.out.println(visitor.getName() + " has been added to the queue.");
        } else {
            System.out.println("Visitor is null and cannot be added to the queue.");
        }
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (queue.contains(visitor)) {
            queue.remove(visitor); // Remove visitor from the queue
            System.out.println(visitor.getName() + " has been removed from the queue.");
        } else {
            System.out.println(visitor.getName() + " is not in the queue.");
        }
    }

    @Override
    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("No visitors in the queue.");
        } else {
            System.out.println("Visitors in the queue:");
            for (Visitor visitor : queue) {
                System.out.println("Name: " + visitor.getName() + ", Age: " + visitor.getAge() + ", Address: " + visitor.getAddress());
                System.out.println("Ticket Type: " + visitor.getTicketType() + ", VIP: " + visitor.isVIP());
            }
        }
    }

    @Override
    public void runOneCycle() {
        if (!queue.isEmpty()) {
            Visitor visitor = queue.poll(); // Remove the first visitor from the queue (FIFO)
            System.out.println(visitor.getName() + " is now riding the " + rideName);
            addVisitorToHistory(visitor); // Add the visitor to the ride history
        } else {
            System.out.println("No visitors in the queue to run the ride.");
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor); // Add visitor to the ride history
        System.out.println(visitor.getName() + " has been added to the ride history.");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean isInHistory = rideHistory.contains(visitor); // Check if the visitor is in the history
        System.out.println(visitor.getName() + " is " + (isInHistory ? "in" : "not in") + " the ride history.");
        return isInHistory;
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size(); // Return the number of visitors in the history
    }
public class Ride {
    private String rideName;
    private String rideType;
    private Employee rideOperator;
    private int maxRider; 
    private int numOfCycles; 
    private Queue<Visitor> queue; 
    private List<Visitor> rideHistory; 


    public Ride(String rideName, String rideType, Employee rideOperator, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.rideOperator = rideOperator;
        this.maxRider = maxRider;
        this.numOfCycles = 0;
        this.queue = new LinkedList<>();
        this.rideHistory = new ArrayList<>();
    }
    
}
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have ridden the " + rideName);
        } else {
            System.out.println("Visitors who have ridden the " + rideName + ":");
            Iterator<Visitor> iterator = rideHistory.iterator();
            while (iterator.hasNext()) {
                Visitor visitor = iterator.next();
                System.out.println("Name: " + visitor.getName() + ", Age: " + visitor.getAge() + ", Address: " + visitor.getAddress());
                System.out.println("Ticket Type: " + visitor.getTicketType() + ", VIP: " + visitor.isVIP());
            }
        }
    }
}
    }
}
