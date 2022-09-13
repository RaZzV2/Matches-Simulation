package Tema2.Factory;

public class Main {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car firstCar = carFactory.getCar("Honda");
        firstCar.engine();

        try {
            Car secondCar = carFactory.getCar("Dacia");
            secondCar.engine();
        } catch (Exception e) {
            System.out.println("That car doesn't exist!");
        }
    }
}
