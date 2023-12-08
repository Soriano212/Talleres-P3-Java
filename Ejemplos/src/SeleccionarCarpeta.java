import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class SeleccionarCarpeta {

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        // Configura el selector para que solo permita seleccionar carpetas
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            // Obtiene la carpeta seleccionada
            File carpetaSeleccionada = fileChooser.getSelectedFile();

            // Imprime la ruta de la carpeta seleccionada
            System.out.println("Carpeta seleccionada: " + carpetaSeleccionada.getAbsolutePath());
        } else {
            System.out.println("No se seleccionó ninguna carpeta.");
        }
    }
}
