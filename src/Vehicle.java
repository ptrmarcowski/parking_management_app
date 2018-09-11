import java.io.Serializable;

public abstract class Vehicle implements Serializable {

    public String licensePlate;
    public double rate;
    public String category;
    public int place = 0;
    public long entryTime;

    public Vehicle(String licensePlate){
        this.licensePlate = licensePlate;
    }

    public String toString() {
        return "License plate's number: " + licensePlate + " " + category + " place: " + place;

    }

    public String getLicensePlate(){
        return licensePlate;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vehicle other = (Vehicle) obj;
        if (licensePlate == null) {
            if (other.licensePlate != null)
                return false;
        } else if (!licensePlate.equals(other.licensePlate))
            return false;
        return true;
    }
}
