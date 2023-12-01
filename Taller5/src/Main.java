import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static int calcularFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Número negativo");
        }
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static boolean esPalindromo(String texto) {
        String textoLimpio = texto.replaceAll("\\s+", "").toLowerCase();
        int i = 0;
        int j = textoLimpio.length() - 1;
        while (i < j) {
            if (textoLimpio.charAt(i) != textoLimpio.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static int busquedaBinaria(ArrayList<Integer> lista, int elemento) {
        int bajo = 0;
        int alto = lista.size() - 1;
        while (bajo <= alto) {
            int medio = bajo + (alto - bajo) / 2;
            if (lista.get(medio) == elemento) {
                return medio;
            }
            if (lista.get(medio) < elemento) {
                bajo = medio + 1;
            } else {
                alto = medio - 1;
            }
        }
        return -1;
    }
}