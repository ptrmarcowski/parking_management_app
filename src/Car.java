import java.io.Serializable;

public abstract class Car extends Vehicle implements Serializable{

    public Car(String licensePlate){
        super(licensePlate);
    }
}
