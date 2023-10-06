import java.util.Arrays;
import java.util.Collections;

public class MainT3 {
    public static void main(String[] args) {
        // Array de nombres de personas
        String[] nombres = {
                "Juan Pérez",
                "Ana Sánchez",
                "Luis García",
                "María Rodríguez",
                "Pedro Martínez"
        };

        // Ordenar de A-Z
        Arrays.sort(nombres);

        System.out.println("Nombres ordenados de A-Z:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        // Invertir el array
        Arrays.sort(nombres, Collections.reverseOrder());

        // Ordenado de Z-A
        System.out.println("Array de nombres invertido (Z-A):");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }
}
