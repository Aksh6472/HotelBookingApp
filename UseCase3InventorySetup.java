import java.util.HashMap;

/**
 * Use Case 3: Centralized Room Inventory with Details
 * Version 3.1
 */

// Room Class
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

// Inventory Class
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
        availability.put("Suite", 2);
    }

    public void displayInventory() {

        System.out.println("Hotel Room Inventory Status\n");

        for (String key : roomDetails.keySet()) {

            Room r = roomDetails.get(key);

            System.out.println(r.type + ":");
            System.out.println("Beds: " + r.beds);
            System.out.println("Size: " + r.size + " sqft");
            System.out.println("Price per night: " + r.price);
            System.out.println("Available Rooms: " + availability.get(key));
            System.out.println();
        }
    }
}

// Main Class
public class UseCase3InventorySetup {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        inventory.displayInventory();
    }
}