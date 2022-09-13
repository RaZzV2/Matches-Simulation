package FirstModule.Tema1;

public class Main {
    public static void main(String[] args) {
        Car firstCar = new Honda("Honda Civic"); //example for abstract class
        firstCar.printType();
        firstCar.combustibleType();
        System.out.println("\n");

        Car secondCar = new Volkswagen("Volkswagen Passat"); //example for abstract class
        secondCar.printType();
        secondCar.combustibleType();
        System.out.println("\n");

        CarInterface thirdCar = new Dacia("Dacia Logan"); //example for interface
        thirdCar.printType();
        thirdCar.combustibleType();
        System.out.println("\n");

        secondCar.startCar(); //example for composition
        firstCar.startCar(); //example for composition
        secondCar.stopCar(); //example for composition


    }
}

// composition vs inheritance}
