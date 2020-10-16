package com.tehnomobil.Putni.NaloziAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final SimpleMailMessage simpleMailMessage = new SimpleMailMessage();


    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void posaljiEmailZaIzbrisaniPutniNalog(String email) {
        simpleMailMessage.setTo(email);
        simpleMailMessage.setFrom("tehnomobil.elsting.putni.nalozi@gmail.com");
        simpleMailMessage.setSubject("ODBIJENO!");
        simpleMailMessage.setText("Vaš putni nalog je ODBIJEN. Pokušajte ponovo ili kontaktirajte nadležnog.");


        javaMailSender.send(simpleMailMessage);

    }

    public void posaljiEmailZaDodaniPutniNalog(String email) {
        simpleMailMessage.setTo(email);
        simpleMailMessage.setFrom("tehnomobil.elsting.putni.nalozi@gmail.com");
        simpleMailMessage.setSubject("NOVI PUTNI NALOG ZA PREGLEDATI!");
        simpleMailMessage.setText("Imate novi putni nalog za pregledati.");

        javaMailSender.send(simpleMailMessage);

    }

    public void posaljiLozinku(String email, String lozinka) {
        simpleMailMessage.setTo(email);
        simpleMailMessage.setFrom("tehnomobil.elsting.putni.nalozi@gmail.com");
        simpleMailMessage.setSubject("VAŠA LOZINKA");
        simpleMailMessage.setText("Vaša lozinka je: " + lozinka);

        javaMailSender.send(simpleMailMessage);

    }
}
