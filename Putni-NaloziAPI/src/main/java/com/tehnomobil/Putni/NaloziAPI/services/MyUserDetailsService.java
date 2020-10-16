package com.tehnomobil.Putni.NaloziAPI.services;


import com.tehnomobil.Putni.NaloziAPI.moduls.MyUserDetails;
import com.tehnomobil.Putni.NaloziAPI.moduls.User;
import com.tehnomobil.Putni.NaloziAPI.moduls.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.lang.module.FindException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;

    @Override
        public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEMail(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Korisnik sa e-mail adresom " + username + " Ne postoji."));
        return user.map(MyUserDetails::new).get();
    }

    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }


    public User getUser(int id) {

        User userObj = new User();
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            userObj = user.get();

        }
        ;
        user.orElseThrow(() -> new NoSuchElementException("Korisnik ne postoji."));

        return userObj;
    }

    public void addUser(User user) {

        Optional<User> users = userRepository.findByEMail(user.getEMail());
        if (users.isEmpty()){
            userRepository.save(user);

        }

    }



    public void posaljiLozinku(String email) throws Exception {

        Optional<User> user = userRepository.findByEMail(email);

        if (user.isPresent()) {

            String sifriranaLozinka = user.get().getLozinka();

            emailService.posaljiLozinku(email,dekripcija(sifriranaLozinka));

        }

        user.orElseThrow(()-> new FindException("Korisnik sa ovom email poštom ne postoji."));

    }

    private String dekripcija(String password) throws Exception {

        SecretKeySpec key = generirajKljuc();
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, key);
        byte [] value= Base64.getMimeDecoder().decode(password);
        byte [] dekodiraj= c.doFinal(value);
        return new String(dekodiraj);

    }

    private SecretKeySpec generirajKljuc() throws Exception {

        final MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = "Tehnomobil123#".getBytes(StandardCharsets.UTF_8);
        messageDigest.update(bytes, 0, bytes.length);
        byte[] key = messageDigest.digest();
        return new SecretKeySpec(key, "AES");
    }
}
