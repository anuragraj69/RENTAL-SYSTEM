package carRent;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String username;
    private String password;
    private String role;
    private List<Booking> bookingHistory;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.bookingHistory = new ArrayList<>();
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public List<Booking> getBookingHistory() {
        return bookingHistory;
    }

    public void addBooking(Booking booking) {
        bookingHistory.add(booking);
    }
}
