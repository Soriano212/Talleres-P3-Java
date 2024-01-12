package Modelo;

import javax.crypto.Cipher;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class CryptoRSA {
    public static void generateKeyPair(String privateKeyFilePath, String publicKeyFilePath) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        byte[] privateKeyBytes = privateKey.getEncoded();
        Files.write(Paths.get(privateKeyFilePath), privateKeyBytes);

        byte[] publicKeyBytes = publicKey.getEncoded();
        Files.write(Paths.get(publicKeyFilePath), publicKeyBytes);
    }

    public static void encryptFile(String publicKeyFilePath, String filePath) throws Exception {
        byte[] fileData = FileOperations.readFile(filePath);
        PublicKey publicKey = loadPublicKey(publicKeyFilePath);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] encryptedData = cipher.doFinal(fileData);
        FileOperations.saveFile(filePath + ".en", encryptedData);
    }

    public static void decryptFile(String privateKeyFilePath, String encryptedFilePath) throws Exception {
        byte[] encryptedData = FileOperations.readFile(encryptedFilePath);
        PrivateKey privateKey = loadPrivateKey(privateKeyFilePath);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] decryptedData = cipher.doFinal(encryptedData);
        FileOperations.saveFile(encryptedFilePath + ".des", decryptedData);
    }


    private static PrivateKey loadPrivateKey(String privateKeyFilePath) throws Exception {
        byte[] privateKeyBytes = Files.readAllBytes(Paths.get(privateKeyFilePath));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        return keyFactory.generatePrivate(keySpec);
    }

    private static PublicKey loadPublicKey(String publicKeyFilePath) throws Exception {
        byte[] publicKeyBytes = Files.readAllBytes(Paths.get(publicKeyFilePath));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        return keyFactory.generatePublic(keySpec);
    }
}
