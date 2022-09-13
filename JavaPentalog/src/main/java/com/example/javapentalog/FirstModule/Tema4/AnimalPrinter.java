package com.example.javapentalog.FirstModule.Tema4;

import java.io.Serializable;

public class AnimalPrinter <T extends Animal & Serializable>{
    T animalPrinter;

    public AnimalPrinter(T animalPrinter) {
        this.animalPrinter=animalPrinter;
    }

    void animalSound(){
        animalPrinter.animalSound();
    }
    void whatEat(){
        animalPrinter.whatEat();
    }
}
