import java.util.HashMap;

/**
 * Use Case 4: Room Search & Availability Check
 * Version 4.0
 */

// Room Class (Domain Model)
class Room {
    String type;
    int beds;
    int size;
    double price;

    public Room(String type, int beds, int size, double price) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }
}

// Inventory Class (Read-only usage here)
class RoomInventory {

    private HashMap<String, Room> roomDetails;
    private HashMap<String, Integer> availability;

    public RoomInventory() {

        roomDetails = new HashMap<>();
        availability = new HashMap<>();

        // Room details
        roomDetails.put("Single", new Room("Single Room", 1, 250, 1500));
        roomDetails.put("Double", new Room("Double Room", 2, 400, 2500));
        roomDetails.put("Suite", new Room("Suite Room", 3, 750, 5000));

        // Availability
        availability.put("Single", 5);
        availability.put("Double", 3);
        availability.put("Suite", 0); // Example: unavailable
    }

    // Read-only getters
    public HashMap<String, Room> getRoomDetails() {
        return roomDetails;
    }

    public HashMap<String, Integer> getAvailability() {
        return availability;
    }
}

// Search Service (Use Case 4)
class RoomSearchService {

    private RoomInventory inventory;

    public RoomSearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void searchAvailableRooms() {

        System.out.println("Available Rooms:\n");

        HashMap<String, Room> rooms = inventory.getRoomDetails();
        HashMap<String, Integer> availability = inventory.getAvailability();

        for (String key : rooms.keySet()) {

            int available = availability.getOrDefault(key, 0);

            // Filter unavailable rooms
            if (available > 0) {

                Room r = rooms.get(key);

                System.out.println(r.type + ":");
                System.out.println("Beds: " + r.beds);
                System.out.println("Size: " + r.size + " sqft");
                System.out.println("Price per night: " + r.price);
                System.out.println("Available Rooms: " + available);
                System.out.println();
            }
        }
    }
}

// Main Class
public class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("Hotel Booking System v4.0");
        System.out.println("Room Search");
        System.out.println("=================================\n");

        RoomInventory inventory = new RoomInventory();

        // Read-only search
        RoomSearchService searchService = new RoomSearchService(inventory);
        searchService.searchAvailableRooms();

        System.out.println("Search completed. No data modified.");
    }
}