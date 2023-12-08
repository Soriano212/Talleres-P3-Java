import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class SeleccionarArchivos {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        // Configura el selector para que permita seleccionar solo archivos
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            // Obtiene el archivo seleccionado
            File archivoSeleccionado = fileChooser.getSelectedFile();

            // Imprime la ruta del archivo seleccionado
            System.out.println("Archivo seleccionado: " + archivoSeleccionado.getAbsolutePath());
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }
}
