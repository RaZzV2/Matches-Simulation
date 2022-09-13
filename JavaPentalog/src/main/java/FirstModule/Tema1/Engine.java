package FirstModule.Tema1;

public class Engine {

    String name;
    public Engine(String name) {
        this.name=name;
    }

    public void startEngine(){
        System.out.println(name +" engine started!");
    }
    public void stopEngine(){
        System.out.println(name + " engine stopped!");
    }
}

