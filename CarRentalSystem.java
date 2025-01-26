package carRent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
	private List<User> users = new ArrayList<>();
    private List<Car> cars = new ArrayList<>();

    public CarRentalSystem() {

        cars.add(new Car("Toyota", "Camry", 50.0));
        cars.add(new Car("Honda", "Civic", 40.0));
        cars.add(new Car("Ford", "Mustang", 80.0));

        users.add(new User("admin", "admin123", "admin"));
        users.add(new User("customer1", "pass123", "customer"));
    }

    public void registerUser(String username, String password, String role) {
        users.add(new User(username, password, role));
        System.out.println("User registered successfully!");
    }

    public void displayAvailableCars() {
        System.out.println("Available Cars:");
        for (Car car : cars) {
            if (car.isAvailable()) {
                System.out.println(car);
            }
        }
    }

    public void bookCar(User user, Car car, LocalDate startDate, LocalDate endDate) {
        if (car.isAvailable()) {
            Booking booking = new Booking(user, car, startDate, endDate);
            user.addBooking(booking);
            car.setAvailable(false);
            System.out.println("Booking successful! " + booking);
        } else {
            System.out.println("Car is not available for booking.");
        }
    }

    public User authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CarRentalSystem system = new CarRentalSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Car Rental System!");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = system.authenticate(username, password);
        if (user != null) {
            System.out.println("Login successful!");

            if (user.getRole().equals("admin")) {
                System.out.println("Admin options are under development.");

            } else {

                system.displayAvailableCars();

                System.out.print("Enter car make to book: ");
                String carMake = scanner.nextLine();

                for (Car car : system.cars) {
                    if (car.getMake().equalsIgnoreCase(carMake) && car.isAvailable()) {
                        System.out.print("Enter start date (YYYY-MM-DD): ");
                        LocalDate startDate = LocalDate.parse(scanner.nextLine());
                        System.out.print("Enter end date (YYYY-MM-DD): ");
                        LocalDate endDate = LocalDate.parse(scanner.nextLine());

                        system.bookCar(user, car, startDate, endDate);
                        break;
                    }
                }
            }
        } else {
            System.out.println("Invalid credentials!");
        }

        scanner.close();
    }
}
