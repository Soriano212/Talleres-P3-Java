package Modelo;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.nio.file.*;

public class SignatureUtils {
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

    public static void signFile(String privateKeyFilePath, String filePath) throws Exception {
        byte[] fileData = FileOperations.readFile(filePath);
        PrivateKey privateKey = loadPrivateKey(privateKeyFilePath);

        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(fileData);

        FileOperations.saveFile(filePath + ".sig", signature.sign());
    }

    public static boolean verifyFileSignature(String publicKeyFilePath, String filePath, String signatureFilePath) throws Exception {
        byte[] fileData = FileOperations.readFile(filePath);
        PublicKey publicKey = loadPublicKey(publicKeyFilePath);

        byte[] signatureBytes = FileOperations.readFile(signatureFilePath);

        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(fileData);

        return signature.verify(signatureBytes);
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
