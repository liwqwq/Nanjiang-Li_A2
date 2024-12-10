// Visitor.java
public class Visitor extends Person {
    private String ticketNumber;
    private String membershipType;

    // Default constructor
    public Visitor() {
        super();  // Call Person's default constructor
        this.ticketNumber = "Unknown";
        this.membershipType = "Regular";
    }

    // Parameterized constructor
    public Visitor(String name, int age, String gender, String ticketNumber, String membershipType) {
        super(name, age, gender);  // Call Person's constructor
        this.ticketNumber = ticketNumber;
        this.membershipType = membershipType;
    }

    // Getters and setters
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
}
