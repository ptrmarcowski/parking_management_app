import java.io.Serializable;

public class PassengerCar extends Car implements Serializable {

    public PassengerCar(String licensePlate) {
        super(licensePlate);
        rate = 3.50;
        category = "Passenger Car";
    }
}
