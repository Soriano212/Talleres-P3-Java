import Controlador.ControladorDatos;
import Vista.InterfazDatos;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                InterfazDatos vista = new InterfazDatos();
                ControladorDatos controlador = new ControladorDatos(vista);
            }
        });
    }
}
