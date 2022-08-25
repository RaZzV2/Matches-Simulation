package Tema2.Facade;

public class CarMaker {
    private Car myCar;

    public CarMaker(){
        myCar = new Car();
    }

    public void startCar(){
        myCar.lights();
        myCar.engine();
        myCar.brake();
    }
}
