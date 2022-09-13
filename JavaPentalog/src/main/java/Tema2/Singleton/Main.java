package Tema2.Singleton;

public class Main {
    public static void main(String[] args) {
        Database db;
        db = Database.getInstance();
        db.getConnection();

        Database db1;
        db1= Database.getInstance();
        db1.getConnection();
    }
}

//Singleton este un design pattern care asigura ca o clasa poate avea un singur obiect.