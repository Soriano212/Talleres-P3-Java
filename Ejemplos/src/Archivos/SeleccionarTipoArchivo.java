import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class SeleccionarTipoArchivo {

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();

        // Configura un filtro para mostrar archivos JPG y PNG
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Imagen", "jpg", "jpeg", "png");
        fileChooser.setFileFilter(filter);

        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            // Obtiene el archivo seleccionado
            File archivoSeleccionado = fileChooser.getSelectedFile();

            // Imprime la ruta del archivo seleccionado
            System.out.println("Archivo seleccionado: " + archivoSeleccionado.getAbsolutePath());
        } else {
            System.out.println("No se seleccionó ningún archivo de imagen.");
        }
    }
}
