package FirstModule.Tema5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int[]arr = new int[4];
        //in exemplul dat incercam sa atribuim o valoare care nu este alocata
        //prin urmare vom folosi un try and catch
        //in cazul nostru ne ducem pe ramura de catch
        try
        {
            int i = arr[4];
            System.out.println("Inside");
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Exception caught");
        }
        //blocul finally este mereu executat
        //exceptiile in care nu este sunt:
        //- daca exista o terminare anormala a programului
        //- un JVM crash
        //-System.exit(0)
        finally {
            System.out.println("finally block executed");
        }


        //checked exceptions - exceptii verificate in timpul compilarii
        // java: unreported exception java.io.IOException; must be caught or declared to be thrown -> pentru
        // a scapa de aceasta eroare trebuie sa specificam IOException in lista de throws
            FileReader file = new FileReader("D:\\abc.txt"); //citesc un fisier din pc
            BufferedReader fileInput = new BufferedReader(file); //creez un obiect pentru a lua datele
            for (int index = 0; index < 2; ++index) {
                System.out.println(fileInput.readLine());
            }
            fileInput.close();


        //unchecked exceptions - exceptii care nu sunt verificare in timpul compilarii
        //programul compileaza fara probleme dar ne arunca exceptia ArithmeticException
      //  int a = 87;
       // int b = 0;
        //int c = a/b;


        //null pointer exceptions (NPE)

        //cazul in care comparam un null cu un string
        String test = null;
        try {
            if(test.equals("abc")) // pentru a evita NPE folosim if("abc".equals(test))
                System.out.println("Same");
            else System.out.println("Different");
        }
        catch (NullPointerException e) {
            System.out.println("Null pointer exception!");
        }

        //inainte sa executam o functie trebuie sa verificam ca sirul sa fie diferit de null

        String aux = "";
        try
        {
            System.out.println(getLength(aux));
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("IllegalArgumentException caught");
        }
        //in primul caz returneaza valoarea 0 deoarece indeplineste toate conditiile (sir vid)


        //in acest caz prindem exceptia deoarece nu avem cum sa obtinem lungimea unui sir null
        //cand apelam o functie pe un string trebuie sa verificam intotdeauna daca este diferit de null
        aux=null;
        try
        {
            System.out.println(getLength(aux));
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("IllegalArgumentException caught");
        }
    }

    public static int getLength(String s){
        if (s == null){
            throw new IllegalArgumentException("The argument cannot be null!");
        }
        return s.length();
    }

}
