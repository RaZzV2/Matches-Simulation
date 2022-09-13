package Tema2.Factory;

public class CarFactory {
    public Car getCar(String carType){
        if(carType.equalsIgnoreCase("Honda")){
            return new Honda();
        }
        else if(carType.equalsIgnoreCase("Toyota")){
            return new Toyota();
        }
        return null;
    }
}
