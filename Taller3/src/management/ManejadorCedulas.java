package management;
import java.util.*;

public class ManejadorCedulas {

    private Map<String, ManejadorPersonas> cedulas = new HashMap<>();

    public ManejadorCedulas() {
        for(int i = 0; i <= 9; i++) {
            cedulas.put(Integer.toString(i), new ManejadorPersonas());
        }
    }

    public boolean agregarPersona(String numeroDeCedula, String nombres, String apellidos, Date fechaDeNacimiento) {
        String ultimoDigito = numeroDeCedula.substring(numeroDeCedula.length() - 1);
        ManejadorPersonas manejador = cedulas.get(ultimoDigito);
        return manejador.registrarPersona(numeroDeCedula, nombres, apellidos, fechaDeNacimiento);
    }

    public ManejadorPersonas obtenerManejadorPersonas(String numeroDeCedula) {
        String ultimoDigito = numeroDeCedula.substring(numeroDeCedula.length() - 1);
        return cedulas.get(ultimoDigito);
    }
}

