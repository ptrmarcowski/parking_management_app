import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class ParkingTest implements Serializable {
    public static void main(String[] args) throws IOException, InterruptedException {

        CarsList w = new CarsList();
        int count = 1;
        int x;
        String z;
        Vehicle p;
        w.makePlaces();

        do {
            System.out.println("Welcome to the car park! \n");
            System.out.println("Enter the number of the action you want to do:");
            System.out.println("1. Add a vehicle to the list of authorized vehicles to use the car park");
            System.out.println("2. Remove the vehicle from the list of vehicles");
            System.out.println("3. Entry of vehicle to car park");
            System.out.println("4. Departure of vehicle from car park");
            System.out.println("5. Display and export the list of parked cars");
            System.out.println("6. Display and export the list of free parking places");
            System.out.println("7. Display and export the daily charges list");
            System.out.println("8. Display and export the list of authorized vehicles to use the car park");

            Scanner scanner = new Scanner(System.in);
            try {
                x = scanner.nextInt();

                switch (x) {
                    case 1:
                        int y;

                        System.out.println("Choose nubmer of vehicles category");
                        System.out.println("1. Passenger Car");
                        System.out.println("2. Delivery Car");
                        System.out.println("3. Motorcycle");
                        y = scanner.nextInt();
                        switch (y) {
                            case 1:
                                System.out.println("Enter number of license plate:");
                                z = scanner.next();
                                w.addVehicle(new PassengerCar(z));
                                sleep(2000);
                                break;

                            case 2:
                                System.out.println("Enter number of license plate:");
                                z = scanner.next();
                                w.addVehicle(new DeliveryCar(z));
                                sleep(2000);
                                break;

                            case 3:
                                System.out.println("Enter number of license plate:");
                                z = scanner.next();
                                w.addVehicle(new Motorcycle(z));
                                sleep(2000);
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("Enter number of license plate, which you want to remove:");
                        z = scanner.next();
                        w.removeVehicle(w.findLicense(z));
                        sleep(2000);
                        break;
                    case 3:
                        System.out.println("Enter number of license plate:");
                        z = scanner.next();
                        w.drivein(w.findLicense(z));
                        sleep(2000);
                        break;
                    case 4:
                        System.out.println("Enter number of license plate:");
                        z = scanner.next();
                        w.driveout(w.findLicense(z));
                        sleep(2000);
                        break;
                    case 5:
                        System.out.println("Current list of parked cars:");
                        w.displayCurrent();
                        System.out.println();
                        System.out.println("Write name of file: ");
                        z = scanner.next();
                        w.writer(w.currentList, z);
                        sleep(2000);
                        break;
                    case 6:
                        System.out.println("Free parking places:");
                        w.displayFree();
                        System.out.println();
                        System.out.println("Write name of file: ");
                        z = scanner.next();
                        w.writer(w.freePlaces, z);
                        sleep(2000);
                        break;
                    case 7:
                        System.out.println("Chrges list:");
                        w.showCharges();
                        System.out.println();
                        System.out.println("Write name of file: ");
                        z = scanner.next();
                        w.writer(w.chargesList, z);
                        sleep(2000);
                        break;
                    case 8:
                        System.out.println("List of authorized vehicles: ");
                        w.display();
                        System.out.println();
                        System.out.println("Write name of file: ");
                        z = scanner.next();
                        w.writer(w.list, z);
                        sleep(2000);
                        break;
                    default:
                        System.out.println("The activity number was not recognized. Try again! \n");
                }
            } catch (InputMismatchException e){
                System.out.println("The activity number was not recognized. Try again! \n");
            }

            count++;
            System.out.println("\n\n\n");

        } while (count < 100);
    }
}
