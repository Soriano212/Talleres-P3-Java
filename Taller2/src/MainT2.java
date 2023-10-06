public class MainT2 {
    public static void main(String[] args) {
        // Frase proporcionada
        String frase = "juan tiene una bicicleta y juan tiene un coche, pero juan no tiene miedo.";

        // Eliminar todas las letras 'b' del string
        frase = frase.replaceAll("b", "");

        // Eliminar el primer substring 'juan' que encuentren en la frase
        frase = frase.replaceFirst("juan", "");

        // Separar cada palabra de la frase y guardarlas en un array de strings
        String[] palabras = frase.split(" ");

        System.out.println("Frase sin 'b' y sin el primer 'juan':");
        System.out.println(frase);

        System.out.println("\nPalabras en un array:");
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
    }
}
