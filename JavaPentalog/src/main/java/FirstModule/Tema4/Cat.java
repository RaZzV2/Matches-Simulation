package FirstModule.Tema4;

public class Cat implements Animal {
    @Override
    public void animalSound() {
        System.out.println("Meow, meow!");
    }

    @Override
    public void whatEat() {
        System.out.println("Whiskas!");
    }
}
