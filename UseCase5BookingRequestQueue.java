import java.util.LinkedList;
import java.util.Queue;

/**
 * Use Case 5: Booking Request Queue (FIFO)
 * Version 5.0
 */

// Reservation Class (represents booking request)
class Reservation {

    String guestName;
    String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public void display() {
        System.out.println("Guest: " + guestName + " | Room Type: " + roomType);
    }
}

// Booking Queue Class
class BookingRequestQueue {

    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    // Add request (enqueue)
    public void addRequest(Reservation r) {
        queue.offer(r);
        System.out.println("Request added for " + r.guestName);
    }

    // View all requests (FIFO order)
    public void displayQueue() {
        System.out.println("\nBooking Requests (FIFO Order):\n");

        for (Reservation r : queue) {
            r.display();
        }
    }
}

// Main Class
public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("Hotel Booking System v5.0");
        System.out.println("Booking Request Queue");
        System.out.println("=================================\n");

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Adding requests (arrival order)
        bookingQueue.addRequest(new Reservation("Akshaya", "Single Room"));
        bookingQueue.addRequest(new Reservation("Rahul", "Double Room"));
        bookingQueue.addRequest(new Reservation("Priya", "Suite Room"));

        // Display queue
        bookingQueue.displayQueue();

        System.out.println("\nAll requests stored. No allocation done yet.");
    }
}