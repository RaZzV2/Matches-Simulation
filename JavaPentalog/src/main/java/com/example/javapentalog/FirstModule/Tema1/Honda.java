package com.example.javapentalog.FirstModule.Tema1;

public class Honda extends Car{
    public Honda(String name) {
        super(name);
    }

    @Override
    public void combustibleType() {
        System.out.printf("I use gasoline as combustible");
    }

}

