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

