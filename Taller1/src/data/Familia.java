package data;

import java.util.Arrays;

public class Familia {

    private String nombre;
    private final Persona[] familiares;

    public Familia(String nombre) {
        this.nombre = nombre;
        this.familiares = new Persona[3];
    }

    public Familia(String nombre, Persona[] familiares) {
        this.nombre = nombre;
        this.familiares = familiares;
    }

    public void agregarMiembro(Persona familiar, int position) {
        this.familiares[position] = familiar;
    }

    @Override
    public String toString() {
        String result = "Familia: " + this.nombre + "\n" + "Familiares: \n";
        for (Persona familiar : this.familiares) {
            result += familiar + "\n";
        }
        return result;
    }
}
