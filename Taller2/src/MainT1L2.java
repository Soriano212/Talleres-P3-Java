import java.util.Scanner;

public class MainT1L2 {
    public static void main(String[] args) {
        // Array de Strings
        String[] array = {"manzana", "banana", "naranja", "pera", "uva"};

        // Pedir al usuario el término de búsqueda
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el término de búsqueda: ");
        String terminoBusqueda = scanner.nextLine();
        scanner.close();

        // Contar cuántos elementos coinciden con el término de búsqueda
        int conteoCoincidencias = 0;
        for (String palabra : array) {
            if (palabra.contains(terminoBusqueda)) {
                conteoCoincidencias++;
            }
        }

        // Crear un nuevo array con el tamaño adecuado
        String[] subArray = new String[conteoCoincidencias];

        // Llenar el nuevo array con los elementos que coinciden con el término de búsqueda
        int index = 0;
        for (String elemento : array) {
            if (elemento.contains(terminoBusqueda)) {
                subArray[index] = elemento;
                index++;
            }
        }

        // Imprimir el sub-array resultante
        System.out.println("Sub-array resultante:");
        for (String elemento : subArray) {
            System.out.println(elemento);
        }
    }
}
