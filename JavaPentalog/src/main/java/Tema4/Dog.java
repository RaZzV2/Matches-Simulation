package Tema4;

import java.io.Serializable;

public class Dog implements Animal {
    @Override
    public void animalSound() {
        System.out.println("Ham, ham!");
    }

    @Override
    public void whatEat() {
        System.out.println("Pedigree");
    }
}
