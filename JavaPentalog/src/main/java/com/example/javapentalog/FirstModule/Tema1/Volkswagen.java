package com.example.javapentalog.FirstModule.Tema1;

public class Volkswagen extends Car{

    public Volkswagen(String name) {
        super(name);
    }
    @Override
    public void combustibleType() {
        System.out.println("I use diesel as combustible");
    }
}

