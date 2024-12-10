// RideInterface Interface
public interface RideInterface {

    // Method to add a visitor to the queue
    void addVisitorToQueue(Visitor visitor);

    // Method to remove a visitor from the queue
    void removeVisitorFromQueue(Visitor visitor);

    // Method to print the list of visitors in the queue
    void printQueue();

    // Method to run the ride for one cycle
    void runOneCycle();

    // Method to add a visitor to the ride history
    void addVisitorToHistory(Visitor visitor);

    // Method to check if a visitor is in the ride history
    boolean checkVisitorFromHistory(Visitor visitor);

    // Method to get the number of visitors in the ride history
    int numberOfVisitors();

    // Method to print the list of visitors in the ride history
    void printRideHistory();
}
