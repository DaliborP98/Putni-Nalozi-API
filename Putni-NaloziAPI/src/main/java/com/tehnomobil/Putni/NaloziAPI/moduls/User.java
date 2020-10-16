package com.tehnomobil.Putni.NaloziAPI.moduls;

import javax.persistence.*;

@Entity
@Table(name = "korisnici")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String Ime;
    private String Prezime;
    private String RadnoMjesto;
    private String Zvanje;
    private String EMail;
    private String Lozinka;
    @Column(name="Roles")
    private String roles;

    public User(int ID, String ime, String prezime, String radnoMjesto, String zvanje, String EMail, String lozinka, String roles) {
        this.ID = ID;
        Ime = ime;
        Prezime = prezime;
        RadnoMjesto = radnoMjesto;
        Zvanje = zvanje;
        this.EMail = EMail;
        Lozinka = lozinka;
        this.roles = roles;
    }

    public User() {
    }

    public User(User user) {
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String ime) {
        Ime = ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public void setPrezime(String prezime) {
        Prezime = prezime;
    }

    public String getRadnoMjesto() {
        return RadnoMjesto;
    }

    public void setRadnoMjesto(String radnoMjesto) {
        RadnoMjesto = radnoMjesto;
    }

    public String getZvanje() {
        return Zvanje;
    }

    public void setZvanje(String zvanje) {
        Zvanje = zvanje;
    }

    public String getEMail() {
        return EMail;
    }

    public void setEMail(String EMail) {
        this.EMail = EMail;
    }

    public String getLozinka() {
        return Lozinka;
    }

    public void setLozinka(String lozinka) {
        Lozinka = lozinka;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
