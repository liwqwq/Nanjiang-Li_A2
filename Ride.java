import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

// Updated Ride class implementing the Queue interface
public class Ride implements RideInterface {
    private String rideName;
    private String rideType;
    private Employee rideOperator;
    private int maxRider;
    private int numOfCycles;
    private Queue<Visitor> queue = new LinkedList<>(); // Use LinkedList to implement Queue
    private List<Visitor> rideHistory = new LinkedList<>(); // Use LinkedList for the ride history
    
    public void exportRideHistory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.getName() + ", " + visitor.getAge() + ", " + visitor.getAddress() + ", " + visitor.getTicketType() + ", " + visitor.isVIP());
                writer.newLine(); // Write each visitor on a new line
            }
            System.out.println("Ride history has been successfully exported to " + filename);
        } catch (IOException e) {
            System.err.println("An error occurred while exporting ride history: " + e.getMessage());
        }
    }
    
    public void sortRideHistory() {
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("Ride history has been sorted.");}
    // Default constructor
    public Ride(String rideName, String rideType, Employee rideOperator, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.rideOperator = rideOperator;
        this.maxRider = maxRider;
        this.numOfCycles = 0;
        this.queue = new LinkedList<>();
        this.rideHistory = new ArrayList<>();
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
            queue.add(visitor);
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
                System.out.println("Name: " + visitor.getName());
            }
        }
    }

    @Override
    public void runOneCycle() {
        if (rideOperator == null) {
            System.out.println("The ride cannot be run because there is no ride operator assigned.");
            return;
        }

        if (queue.isEmpty()) {
            System.out.println("The ride cannot be run because there are no waiting visitors in the queue.");
            return;
        }

        int riders = Math.min(maxRider, queue.size());
        for (int i = 0; i < riders; i++) {
            Visitor visitor = queue.poll();
            System.out.println(visitor.getName() + " is now riding the " + rideName);
            addVisitorToHistory(visitor);
        }

        numOfCycles++;
        System.out.println("The ride has been run for " + riders + " visitors. Total cycles run: " + numOfCycles);
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
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

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have ridden the " + rideName);
        } else {
            System.out.println("Visitors who have ridden the " + rideName + ":");
            for (Visitor visitor : rideHistory) {
                System.out.println("Name: " + visitor.getName());
            }
        }
    }
    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] visitorData = line.split(","); 
                if (visitorData.length == 5) { 
                    String name = visitorData[0].trim();
                    int age = Integer.parseInt(visitorData[1].trim());
                    String address = visitorData[2].trim();
                    String ticketType = visitorData[3].trim();
                    boolean isVIP = Boolean.parseBoolean(visitorData[4].trim());

                    Visitor visitor = new Visitor(name, age, address, ticketType, isVIP);
                    // Add tourists to history
                    addVisitorToHistory(visitor);
                } else {
                    System.err.println("Invalid data format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing visitor data: " + e.getMessage());
        }
    }
}
