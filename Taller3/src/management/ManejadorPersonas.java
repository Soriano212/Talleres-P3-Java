package management;
import java.util.*;

public class ManejadorPersonas {

    private Map<String, Persona> personas = new HashMap<>();

    public boolean registrarPersona(String numeroDeCedula, String nombres, String apellidos, Date fechaDeNacimiento) {
        // Verificar si la persona ya está registrada
        if(personas.containsKey(numeroDeCedula)) {
            return false;
        }
        // Crear nuevo objeto Persona
        Persona nuevaPersona = new Persona(numeroDeCedula, nombres, apellidos, fechaDeNacimiento);

        personas.put(numeroDeCedula, nuevaPersona);
        return true;
    }

    public Persona obtenerPersona(String numeroDeCedula) {
        return personas.get(numeroDeCedula);  // Retorna null si la persona no está registrada
    }

    public ArrayList<Persona> obtenerPersonasOrdenadas() {
        ArrayList<Persona> listaPersonas = new ArrayList<>(personas.values());
        Collections.sort(listaPersonas, new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p1.getNombres().compareTo(p2.getNombres());
            }
        });
        return listaPersonas;
    }
}
