import data.Familia;
import data.Persona;

import java.util.Scanner;

public class MainAlterno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el nombre de la familia: ");
        String nombreFamilia = scanner.nextLine();

        System.out.print("Ingresa la cantidad de familiares: ");
        int cant = scanner.nextInt();
        scanner.nextLine();

        Persona[] familiares = new Persona[cant];

        System.out.println("Ingresa los datos de los familiares:");

        for (int i = 0; i < cant; i++) {
            System.out.println("--------------------");
            System.out.println("Familiar " + (i + 1));

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Parentesco: ");
            String parentesco = scanner.nextLine();

            Persona familiar = new Persona(nombre, edad, parentesco);
            familiares[i] = familiar;
        }

        Familia familia = new Familia(nombreFamilia, familiares);

        System.out.println("\n--------------------");
        System.out.println(familia);
        scanner.close();
    }
}
