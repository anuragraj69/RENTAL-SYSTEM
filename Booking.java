package carRent;

import java.time.LocalDate;

public class Booking {
	private User user;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalCost;

    public Booking(User user, Car car, LocalDate startDate, LocalDate endDate) {
        this.user = user;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = calculateTotalCost();
    }

    private double calculateTotalCost() {
        long days = startDate.until(endDate).getDays();
        return days * car.getPricePerDay();
    }

    public User getUser() {
        return user;
    }

    public Car getCar() {
        return car;
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return "Booking: " + car.getMake() + " " + car.getModel() + " | Dates: " + startDate + " to " + endDate + " | Total: $" + totalCost;
    }
}
