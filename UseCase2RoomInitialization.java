/**
 * Use Case 2: Basic Room Types & Static Availability
 * Demonstrates abstraction, inheritance, and polymorphism
 *
 * @author R B Akshayanivashini
 * @version 2.1
 */

// Abstract Class
abstract class Room {

    protected String roomType;
    protected int beds;
    protected double price;

    public Room(String roomType, int beds, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.price = price;
    }

    public void displayRoomDetails() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Beds: " + beds);
        System.out.println("Price per night: ₹" + price);
    }
}

// Single Room Class
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 2500);
    }
}

// Double Room Class
class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 4000);
    }
}

// Suite Room Class
class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 8000);
    }
}

// Main Class
public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("Hotel Booking System v2.1");
        System.out.println("Room Initialization");
        System.out.println("=================================\n");

        // Polymorphism (reference type = Room)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability (simple variables)
        int singleAvailability = 5;
        int doubleAvailability = 3;
        int suiteAvailability = 2;

        System.out.println("Available Rooms:\n");

        single.displayRoomDetails();
        System.out.println("Available: " + singleAvailability);
        System.out.println("--------------------------");

        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailability);
        System.out.println("--------------------------");

        suite.displayRoomDetails();
        System.out.println("Available: " + suiteAvailability);
        System.out.println("--------------------------");

        System.out.println("End of room listing.");
    }
}