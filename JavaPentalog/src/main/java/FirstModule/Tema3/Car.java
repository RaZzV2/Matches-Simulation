package FirstModule.Tema3;

public class Car {
    String name;
    double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean hasOver200(){
        return this.price > 200;
    }

    public static int compare(Car c1, Car c2){
        return c1.getName().compareToIgnoreCase(c2.getName());
    }
}
