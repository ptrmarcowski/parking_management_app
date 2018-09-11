import java.io.Serializable;

public class Motorcycle extends Vehicle implements Serializable {

    public Motorcycle(String licensePlate){
        super(licensePlate);
        rate = 2.50;
        category = "Motorcycle";
    }

}
