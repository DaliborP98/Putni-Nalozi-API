package com.tehnomobil.Putni.NaloziAPI.moduls;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class MyUserDetails implements UserDetails {

    private int ID;
    private String ime;
    private String prezime;
    private String radnoMjesto;
    private String zvanje;
    private String EMail;
    private String lozinka;
    private String Roles;


    public MyUserDetails(User user) {
        this.ID=user.getID();
        this.ime = user.getIme();
        this.prezime = user.getPrezime();
        this.radnoMjesto = user.getRadnoMjesto();
        this.zvanje = user.getZvanje();
        this.EMail = user.getEMail();
        this.lozinka = user.getLozinka();
        this.Roles = user.getRoles();

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("Roles"));
    }

    @Override
    public String getPassword() {
        return lozinka;
    }

    @Override
    public String getUsername() {
        return EMail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public int getID(){

        return ID;
    }

    public String getRoles() {
        return Roles;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getRadnoMjesto() {
        return radnoMjesto;
    }

    public String getZvanje() {
        return zvanje;
    }

}
