import java.util.Scanner;

public class MainT1L1 {
    public static void main(String[] args) {
        // Strings para el ejercicio 1.1
        String string1 = "Hola Juan, cómo estás?";
        String string2 = "5 manzanas y 3 peras";
        String string3 = "Esta cadena no tiene números";

        Scanner scan = new Scanner(System.in);

        System.out.print("Ingrese una letra: ");
        String letra = scan.nextLine();

        // Contar las letras '' en un string
        int conteoString1 = contarEnTexto(string1, letra);
        int conteoString2 = contarEnTexto(string2, letra);
        int conteoString3 = contarEnTexto(string3, letra);

        System.out.println("Conteo de '"+ letra +"' en string1: " + conteoString1);
        System.out.println("Conteo de '"+ letra +"' en string2: " + conteoString2);
        System.out.println("Conteo de '"+ letra +"' en string3: " + conteoString3);

        System.out.print("Ingrese una palabra: ");
        String palabra = scan.nextLine();

        // Contar cuántas veces aparece la palabra '' en un string
        int conteoPalabraString1 = contarPalabrasSeparadas(string1, palabra);
        int conteoPalabraString2 = contarPalabrasSeparadas(string2, palabra);
        int conteoPalabraString3 = contarPalabrasSeparadas(string3, palabra);

        System.out.println("Conteo de 'hola' en string1: " + conteoPalabraString1);
        System.out.println("Conteo de 'hola' en string2: " + conteoPalabraString2);
        System.out.println("Conteo de 'hola' en string3: " + conteoPalabraString3);

        scan.close();
    }

    public static int contarEnTexto(String str, String reemplazar) {
        return str.length() - str.replace(reemplazar, "").length();
    }

    public static int contarPalabrasSeparadas(String str, String palabra_buscar) {
        String[] palabras = str.split(" ");
        int conteo = 0;
        for (String palabra : palabras) {
            if (palabra.equalsIgnoreCase(palabra_buscar)) {
                conteo++;
            }
        }
        return conteo;
    }
}