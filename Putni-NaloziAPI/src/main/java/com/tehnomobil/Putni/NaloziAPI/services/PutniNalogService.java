package com.tehnomobil.Putni.NaloziAPI.services;

import com.tehnomobil.Putni.NaloziAPI.moduls.PutniNalog;
import com.tehnomobil.Putni.NaloziAPI.moduls.PutniNalogRepository;
import com.tehnomobil.Putni.NaloziAPI.moduls.User;
import com.tehnomobil.Putni.NaloziAPI.moduls.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PutniNalogService {

    @Autowired
    PutniNalogRepository putniNalogRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;

    public List<PutniNalog> getAllPutniNalog() {

        List<PutniNalog> putninalog = new ArrayList<>();

        putniNalogRepository.findAll().forEach(putninalog::add);
        putninalog.removeIf(putniNalog -> putniNalog.getAuto().equals("AUTO"));
        return putninalog;
    }

    public List<PutniNalog> getPutneNalogeByUser(int userId) {

        List<PutniNalog> putniNalogList = new ArrayList<>(putniNalogRepository.findByKorisnikID(userId));

        putniNalogList.removeIf(putniNalog -> putniNalog.getAuto().equals("AUTO"));

        return putniNalogList;


    }

    public PutniNalog getPutniNalogByUser(int id) {

        PutniNalog putniNalogObj = new PutniNalog();
        Optional<PutniNalog> putniNalog = putniNalogRepository.findById(id);


        if (putniNalog.isPresent()) {

            putniNalog.filter(putninalog -> !putninalog.getAuto().equals("AUTO"));
            putniNalogObj = putniNalog.get();
        }

        putniNalog.orElseThrow(() -> new NoSuchElementException("Putni nalog ne postoji."));


        return putniNalogObj;
    }


    public void addPutniNalog(PutniNalog putniNalog) {

        Optional<User> user = userRepository.findById(putniNalog.getKorisnik().getID());

        if (user.isPresent()) {
            if (user.get().getRoles().equals("USER")) {
                List<User> adminList = new ArrayList<>(userRepository.findByRoles("ADMIN"));
                for (User admin : adminList) {

                    emailService.posaljiEmailZaDodaniPutniNalog(admin.getEMail());
                }
            }
        }

        user.orElseThrow(() -> new NoSuchElementException("Putni nalog ne postoji."));

        putniNalogRepository.save(putniNalog);
    }

    public void updatePutniNalog(PutniNalog putniNalog) {

        putniNalogRepository.save(putniNalog);

    }

    public void deletePutniNalog(int id) {

        Optional<PutniNalog> putninalog = putniNalogRepository.findById(id);

        if (putninalog.isPresent()) {
            User korisnik = putninalog.get().getKorisnik();

            emailService.posaljiEmailZaIzbrisaniPutniNalog(korisnik.getEMail());

        }

        putniNalogRepository.deleteById(id);
    }


    public List<PutniNalog> getAllPutneNalogeBezVozila() {

        List<PutniNalog> nedefiniraniNalog = new ArrayList<>();

        putniNalogRepository.findAll().forEach(nedefiniraniNalog::add);
        nedefiniraniNalog.removeIf(putniNalog -> !putniNalog.getAuto().equals("AUTO"));
        return nedefiniraniNalog;

    }


    public int brojPutnihNaloga() {

        List<PutniNalog> putniNalog = new ArrayList<>();
        putniNalogRepository.findAll().forEach(putniNalog::add);
        putniNalog.removeIf(putni -> putni.getAuto().equals("AUTO"));

        return putniNalog.size();
    }
}
