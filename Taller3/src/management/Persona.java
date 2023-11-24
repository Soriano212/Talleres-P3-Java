package management;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Persona {

    private String numeroDeCedula;
    private String nombres;
    private String apellidos;
    private Date fechaDeNacimiento;

    public Persona(String numeroDeCedula, String nombres, String apellidos, Date fechaDeNacimiento) {
        this.numeroDeCedula = numeroDeCedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getNombres() {
        return nombres;
    }

    public static boolean validarCedula(String id) {
        if (id == null || id.length() != 10 || !id.matches("\\d+")) {
            return false;
        }

        int[] coefficients = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int digit = Character.getNumericValue(id.charAt(i));
            int product = digit * coefficients[i];

            sum += product > 9 ? product - 9 : product;
        }

        int lastDigit = Character.getNumericValue(id.charAt(9));
        int checkDigit = sum % 10 == 0 ? 0 : 10 - (sum % 10);

        return checkDigit == lastDigit;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = formatoFecha.format(fechaDeNacimiento);
        return "Número de Cédula: " + numeroDeCedula +
                ", Nombres: " + nombres +
                ", Apellidos: " + apellidos +
                ", Fecha de Nacimiento: " + fecha;
    }
}

