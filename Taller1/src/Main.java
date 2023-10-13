import data.Familia;
import data.Persona;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Ingresa el nombre de la familia: ");

        Scanner scanner = new Scanner(System.in);
        String nombreFamilia = scanner.nextLine();

        System.out.println("Ingresa los datos de los familiares:");

        Familia familia = new Familia(nombreFamilia);

        for (int i = 0; i < 3; i++) {
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
            familia.agregarMiembro(familiar, i);
        }

        System.out.println("\n--------------------");
        System.out.println(familia);
        scanner.close();
    }
}