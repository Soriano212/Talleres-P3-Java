package Modelo;

import java.io.*;

public class FileOperations {
    public static byte[] readFile(String filePath) throws IOException {
        File file = new File(filePath);
        byte[] fileData = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(fileData);
        fis.close();
        return fileData;
    }

    public static void saveFile(String filePath, byte[] data) throws IOException {
        FileOutputStream fos = new FileOutputStream(filePath);
        fos.write(data);
        fos.close();
    }
}
