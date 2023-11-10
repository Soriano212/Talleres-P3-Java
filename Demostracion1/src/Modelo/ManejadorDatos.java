package Modelo;

import java.util.ArrayList;

public class ManejadorDatos {
    private final ArrayList<String> paises;
    private final ArrayList<String[]> selecciones;

    public ManejadorDatos() {
        paises = new ArrayList<>();
        selecciones = new ArrayList<>();
    }

    public void agregarPais(String pais) {
        paises.add(pais);
    }

    public void agregarSeleccion(String pais, String paquete, String extras) {
        selecciones.add(new String[]{pais, paquete, extras});
    }

    public String[] obtenerPaises() {
        return paises.toArray(new String[0]);
    }

    public String[][] obtenerSelecciones() {
        return selecciones.toArray(new String[0][0]);
    }
}
