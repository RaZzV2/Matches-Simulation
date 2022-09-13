package com.example.javapentalog.FirstModule.Tema1;

public class Dacia extends Car implements CarInterface{
    public Dacia(String name) {
        super(name);
    }

    @Override
    public void combustibleType() {
        System.out.println("I use gas as combustible");

    }

    public void printType(){
        System.out.println(name + " is my car");
    }
}

