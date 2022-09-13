package com.example.javapentalog.FirstModule.Tema3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

        Car firstCar = new Car("Honda",200);
        Car secondCar = new Car("Toyota",150);
        Car thirdCar = new Car("Mitsubishi",300);
        Car fourthCar = new Car("Volkswagen",140);
        Car fifthCar = new Car("Audi", 148);
        Car sixthCar = new Car("Dacia",190);

        List<Car> myCars = Arrays.asList(firstCar,secondCar,thirdCar,fourthCar,fifthCar);
        List<String> carsAbove200 = myCars.stream().filter(Car::hasOver200).map(Car::getName).collect(Collectors.toList());
      //  System.out.println(carsAbove200); //afisam masinile care sunt mai scumpe de 200

        //sa se afiseaze masinile care sunt mai ieftine de 200 si care incep cu litera A;
        List<String> doubleConditionCars = myCars.stream().filter(c -> c.getPrice() < 200 && c.getName().startsWith("A")).map(Car::getName).collect(Collectors.toList());
      //  System.out.println(doubleConditionCars);

        //se da o matrice de masini si sa se afiseze numele fiecarei masini cu o functie lambda
        Car[][] data = new Car[][]{{fifthCar,firstCar},{secondCar,sixthCar},{thirdCar,fourthCar}};
        List<String> carName = Arrays.stream(data).flatMap(x ->Arrays.stream(x).map(Car::getName)).collect(Collectors.toList());
        System.out.println(carName);

        //sa se afiseze masinile sortate
        List<String> sortedCars = myCars.stream().sorted(Car::compare).map(Car::getName).collect(Collectors.toList());
        System.out.println(sortedCars);

    }
}
