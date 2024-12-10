import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
public class Coches {
    public static void main(String[] args) {

   ArrayList<String> marcas = new ArrayList<String>();
   boolean nada = false;
   Scanner sc = new Scanner(System.in);

    System.out.println("Dime marcas de coche");
    String porsi;

    do {
        porsi = sc.nextLine();
        if (!porsi.isEmpty())
        marcas.add(porsi);
    }while (!porsi.isEmpty());

        Collections.sort(marcas);
        System.out.println(marcas);

    }
}