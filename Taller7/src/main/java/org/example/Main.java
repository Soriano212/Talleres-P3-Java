package org.example;

import modelo.EmailSender;

public class Main {
    public static void main(String[] args) {
        try {
            EmailSender sender = new EmailSender("smtp.gmail.com", "587", "usuario", "Contraseña");
            sender.sendEmailWithAttachment("autor", "destinatario", "Asunto del Mensaje", "Mensaje Java Mail", "src/main/resources/foto.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}