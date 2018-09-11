import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CarsList implements Serializable{

    public List<Vehicle> list = new ArrayList<Vehicle>();
    public List<Vehicle> currentList = new ArrayList<Vehicle>();
    public List<Double> chargesList = new ArrayList<>();
    public List<Integer> freePlaces = new ArrayList<>();
    final int MAX_SIZE = 10;

    public void makePlaces(){
        for(int i = 1; i<=MAX_SIZE; i++){
            freePlaces.add(i);
        }
    }

    public void display() {
        for (Vehicle p : list) {
            System.out.println(p);
        }
    }

    public void displayFree() {
        for (Integer i : freePlaces) {
            System.out.println(i);
        }
    }

    public void displayCurrent() {
        for (Vehicle p : currentList) {
            System.out.println(p);
        }
    }

    public void showCharges() {
        for (Double d : chargesList) {
            System.out.println(d);
        }
    }

    public void addVehicle(Vehicle p) {
        if(list.contains(p)){
            System.out.println("The vehicle is already on the authorized list.");
        } else {
            System.out.println("The vehicle was added to the authorized list.");
            list.add(p);
        }
    }

    public void removeVehicle(Vehicle p) {
        list.remove(p);
        System.out.println("The vehicle was removed from the list.");
    }

    public void drivein(Vehicle p) {
        if ((list.contains(p))&&!freePlaces.isEmpty()){
            System.out.println("The vehicle is on the authorized list.");
            Calendar c = Calendar.getInstance();
            p.entryTime = c.getTimeInMillis();
            currentList.add(p);
            p.place = (int) freePlaces.get(0);
            freePlaces.remove(0);
            System.out.println("Your place: " + p.place);
        } else {
            System.out.println("The vehicle is not on the list of authorized vehicles or there are no more places in the car park.");
        }
    }

    public void driveout(Vehicle p) {
        Calendar c = Calendar.getInstance();
        currentList.remove(p);
        freePlaces.add(p.place);
        p.place = 0;
        double dozaplaty = (double) ((1+(c.getTimeInMillis() - p.entryTime)/(1000*60*60))*p.rate);
        chargesList.add(dozaplaty);
        p.entryTime = 0;
        System.out.println("Parking fee: " + dozaplaty);
        System.out.println("Good bye!");
    }

    public Vehicle findLicense(String s){
        int i = 0;
        for(Vehicle p : list){
            if (p.licensePlate.equals(s)){
                i=1;
                return p;
            }
        }
        if(i == 0){
            System.out.println("There is no such vehicle on the list.");
        }
        return null;
    }

    public  void writer(List w, String z) throws IOException {

        PrintWriter pw = null;
        FileOutputStream fo = null;
        File file = null;
        try {
            file = new File(z+".txt");
            pw = new PrintWriter(new FileOutputStream(file));
            fo = new FileOutputStream(file);
            int datList = w.size();
            for (int i = 0; i < datList; i++) {
                pw.write(w.get(i).toString() + "\n");
            }
        } finally {
            pw.flush();
            pw.close();
            fo.close();
            System.out.println("The file was saved as " + z + ".txt");
        }
    }
}