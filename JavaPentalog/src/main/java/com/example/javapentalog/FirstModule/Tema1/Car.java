package com.example.javapentalog.FirstModule.Tema1;

public abstract class Car {
    protected String name;
    private final Engine engine;
    public Car(String name) {
        this.name = name;
        engine = new Engine(name);
    }

    public abstract void combustibleType();
    public void startCar(){
        engine.startEngine();
    }

    public void stopCar(){
        engine.stopEngine();
    }

    public void printType(){
        System.out.println(name + " is my car");
    }
}
