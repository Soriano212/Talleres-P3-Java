package data;

public class Persona {
    private String nombre;
    private int edad;
    private String parentesco;

    public Persona(String nombre, int edad, String parentesco) {
        this.nombre = nombre;
        this.edad = edad;
        this.parentesco = parentesco;
    }

    @Override
    public String toString() {
        return "Persona(" +
                "nombre='" + nombre +
                ", edad=" + edad +
                ", parentesco='" + parentesco +
                ')';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
}
