import java.io.Serializable;

public class DeliveryCar extends Car implements Serializable{

    public DeliveryCar(String licensePlate) {
        super(licensePlate);
        rate = 4.50;
        category = "Delivery Car";
    }
}
