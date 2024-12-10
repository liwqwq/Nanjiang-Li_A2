import java.util.*;

public class Ride implements RideInterface {
    private String rideName;
    private String rideType;
    private Employee rideOperator;
    private List<Visitor> queue = new ArrayList<>();
    private List<Visitor> rideHistory = new ArrayList<>();

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

    // Implementing the methods of the RideInterface
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.add(visitor);
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        queue.remove(visitor);
    }

    @Override
    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("No visitors in the queue.");
        } else {
            System.out.println("Visitors in the queue:");
            for (Visitor visitor : queue) {
                System.out.println(visitor.getName());
            }
        }
    }

    @Override
    public void runOneCycle() {
        if (!queue.isEmpty()) {
            Visitor visitor = queue.remove(0); // Simulate running the ride for one visitor
            System.out.println(visitor.getName() + " is now riding the " + rideName);
            addVisitorToHistory(visitor);  // Add the visitor to the ride history
        } else {
            System.out.println("No visitors in the queue to run the ride.");
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have ridden the " + rideName);
        } else {
            System.out.println("Visitors who have ridden the " + rideName + ":");
            for (Visitor visitor : rideHistory) {
                System.out.println(visitor.getName());
            }
        }
    }
}
    }
}
