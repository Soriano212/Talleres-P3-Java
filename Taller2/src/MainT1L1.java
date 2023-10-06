public class MainT1L1 {
    public static void main(String[] args) {
        // Strings para el ejercicio 1.1
        String string1 = "Hola Juan, cómo estás?";
        String string2 = "5 manzanas y 3 peras";
        String string3 = "Esta cadena no tiene números";

        // Contar las letras 'a' en un string
        int conteoAString1 = contarEnTexto(string1, "a");
        int conteoAString2 = contarEnTexto(string2, "a");
        int conteoAString3 = contarEnTexto(string3, "a");

        System.out.println("Conteo de 'a' en string1: " + conteoAString1);
        System.out.println("Conteo de 'a' en string2: " + conteoAString2);
        System.out.println("Conteo de 'a' en string3: " + conteoAString3);

        // Contar el número de veces que aparece el número 5 en un string
        int conteo5String1 = contarEnTexto(string1, "5");
        int conteo5String2 = contarEnTexto(string2, "5");
        int conteo5String3 = contarEnTexto(string3, "5");

        System.out.println("Conteo de '5' en string1: " + conteo5String1);
        System.out.println("Conteo de '5' en string2: " + conteo5String2);
        System.out.println("Conteo de '5' en string3: " + conteo5String3);

        // Contar los espacios en blanco en un string
        int conteoEspaciosString1 = contarEnTexto(string1, " ");
        int conteoEspaciosString2 = contarEnTexto(string2, " ");
        int conteoEspaciosString3 = contarEnTexto(string3, " ");

        System.out.println("Conteo de espacios en string1: " + conteoEspaciosString1);
        System.out.println("Conteo de espacios en string2: " + conteoEspaciosString2);
        System.out.println("Conteo de espacios en string3: " + conteoEspaciosString3);

        // Contar cuántas veces aparece la palabra 'hola' en un string
        int conteoHolaString1 = contarPalabrasSeparadas(string1, "hola");
        int conteoHolaString2 = contarPalabrasSeparadas(string2, "hola");
        int conteoHolaString3 = contarPalabrasSeparadas(string3, "hola");

        System.out.println("Conteo de 'hola' en string1: " + conteoHolaString1);
        System.out.println("Conteo de 'hola' en string2: " + conteoHolaString2);
        System.out.println("Conteo de 'hola' en string3: " + conteoHolaString3);
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