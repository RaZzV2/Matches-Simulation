package FirstModule.Tema4;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //am creat o clasa generica printer pentru a afisa un anumit int, string, double, etc
        Printer<Integer> printer = new Printer<>(10);
        printer.print();

        Printer<String> printer1 = new Printer<>("test");
        printer1.print();

        //sa se creeze o clasa generica pentru a afisa un anumit sunet in functie de animal

        AnimalPrinter<Cat> catAnimalPrinter = new AnimalPrinter<>(new Cat());
        catAnimalPrinter.animalSound();
        catAnimalPrinter.whatEat();

        System.out.println('\n');

        AnimalPrinter<Dog> dogAnimalPrinter = new AnimalPrinter<>(new Dog());
        dogAnimalPrinter.animalSound();
        dogAnimalPrinter.whatEat();

        //mai jos o sa dau un exemplu de wild card
        //wild card ul este este notat cu '?' in programarea generica
        //acesta reprezinta un tip necunoscut

        List<Integer> firstList = Arrays.asList(7,8,9,100);
        List<Double> secondList = Arrays.asList(8.9,10.7,55.4);
        List<String> thirdList = Arrays.asList("andrei","ana","gicu");
        printMyList(firstList);
        printMyList(secondList);
        printMyList(thirdList);
        System.out.println(sum(secondList));

    }

    private static void printMyList(List<?> list){
        System.out.println(list);
    }

    private static double sum (List<? extends Number> list){
        double sum = 0;
        for(Number index : list){
            sum += index.doubleValue();
        }
        return sum;
    }

}
