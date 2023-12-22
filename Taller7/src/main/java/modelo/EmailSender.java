package modelo;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;

public class EmailSender {

    private final Session session;
    public EmailSender(String host, String port, final String username, final String password) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        this.session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    public void sendEmailWithAttachment(String from, String to, String subject, String body, String attachmentPath) throws MessagingException, FileNotFoundException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(body);

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        // Verifica si la imagen existe
        if (attachmentPath != null || attachmentPath.isEmpty()) {
            File file = new File(attachmentPath);
            if (file.exists()) {
                messageBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(attachmentPath);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(file.getName());
                multipart.addBodyPart(messageBodyPart);
            } else {
                throw new FileNotFoundException("Archivo no encontrado en la ruta especificada: " + attachmentPath);
            }
        }

        message.setContent(multipart);
        Transport.send(message);
        System.out.println("Correo Electrónico Enviado con Éxito");
    }
}
