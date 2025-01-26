package carRent;

public class Car {
	private String make;
    private String model;
    private double pricePerDay;
    private boolean isAvailable;

    public Car(String make, String model, double pricePerDay) {
        this.make = make;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.isAvailable = true;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return make + " " + model + " - $" + pricePerDay + "/day - Available: " + isAvailable;
    }
}
