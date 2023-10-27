import management.ManejadorCedulas;
import management.ManejadorPersonas;
import management.Persona;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    private static ManejadorCedulas manejadorCedulas = new ManejadorCedulas();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        while(menu()) {
            // Continuar mostrando el menú mientras el usuario no elija salir
        }
    }

    public static boolean menu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1) Agregar Persona");
        System.out.println("2) Listar personas por nombre según último dígito");
        System.out.println("3) Obtener Persona");
        System.out.println("4) Salir");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        boolean continuar = true;

        switch(opcion) {
            case 1:
                agregarPersona();
                break;
            case 2:
                listarPersonas();
                break;
            case 3:
                obtenerPersona();
                break;
            case 4:
                System.out.println("Programa finalizado.");
                continuar = false;
                break;
            default:
                System.out.println("Opción inválida.");
                break;
        }

        pause();

        return continuar;
    }

    public static void agregarPersona() {
        System.out.print("Número de cédula: ");
        String numeroDeCedula = scanner.nextLine();
        System.out.print("Nombres: ");
        String nombres = scanner.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Fecha de nacimiento (dd/MM/yyyy): ");
        String fechaStr = scanner.nextLine();
        Date fechaDeNacimiento = null;
        try {
            fechaDeNacimiento = formatoFecha.parse(fechaStr);
        } catch (ParseException e) {
            System.out.println("Fecha inválida. Persona no agregada.");
            return;
        }

        boolean agregado = manejadorCedulas.agregarPersona(numeroDeCedula, nombres, apellidos, fechaDeNacimiento);
        if (agregado) {
            System.out.println("Persona agregada correctamente.");
        } else {
            System.out.println("El número de cédula ya ha sido agregado anteriormente.");
        }
    }

    public static void listarPersonas() {
        System.out.print("Ingrese el último dígito de la cédula: ");
        String ultimoDigito = scanner.nextLine();
        ManejadorPersonas manejador = manejadorCedulas.obtenerManejadorPersonas(ultimoDigito);
        if (manejador != null && manejador.obtenerPersonasOrdenadas().size() > 0) {
            for (Persona persona : manejador.obtenerPersonasOrdenadas()) {
                System.out.println(persona);
            }
        } else {
            System.out.println("No hay personas registradas con ese último dígito.");
        }
    }

    public static void obtenerPersona() {
        System.out.print("Ingrese el número de cédula: ");
        String numeroDeCedula = scanner.nextLine();
        ManejadorPersonas manejador = manejadorCedulas.obtenerManejadorPersonas(numeroDeCedula);
        if (manejador != null) {
            Persona persona = manejador.obtenerPersona(numeroDeCedula);
            if (persona != null) {
                System.out.println(persona);
            } else {
                System.out.println("No existe una persona con esa cédula.");
            }
        } else {
            System.out.println("No hay personas registradas con ese último dígito.");
        }
    }

    public static void pause() {
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();  // Espera que el usuario presione Enter
    }
}
