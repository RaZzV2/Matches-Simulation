package Tema2.Facade;

public class Main {
    public static void main(String[] args) {
        CarMaker carMaker = new CarMaker();
        carMaker.startCar();
    }
}

//Acest design pattern implica o singura clasa care oferta metode simplificate cerute de client.