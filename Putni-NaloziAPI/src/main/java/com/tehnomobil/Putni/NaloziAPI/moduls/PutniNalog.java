package com.tehnomobil.Putni.NaloziAPI.moduls;

import javax.persistence.*;

@Entity
@Table(name = "putniNalozi")
public class PutniNalog {


    @ManyToOne
    private User korisnik;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String NazivDrustva;
    private int broj;
    private String mjestoFirme;
    private String dana;
    private String sluzbenoOtputuje;
    private String mjestoPutovanja;
    private String zadaca;
    private int trajanjePutovanja;
    private String trajanjePutovanjaSlovima;
    private String auto;  //vrsta Prijevoznog Sredstva
    private String troskoviPutovanjaTerete;
    private String isplataPredujma;
    private String odDatum;
    private String doDatum;
    private String pocetnoStanjeBrojila;
    private String zavrsnoStanjeBrojila;
    private int razlikaBrojila;
    private double brojSati;
    private int brojDnevnica;
    private int brojPoludnevnica;
    private String ukupno;


    public PutniNalog(String nazivDrustva, int ID, int broj, String mjestoFirme, String dana, String sluzbenoOtputuje,
                      String mjestoPutovanja, String zadaca, int trajanjePutovanja, String trajanjePutovanjaSlovima,
                      String auto, String troskoviPutovanjaTerete, String isplataPredujma, int userId,String odDatum, String doDatum, String pocetnoStanjeBrojila,
                      String zavrsnoStanjeBrojila, int razlikaBrojila, double brojSati, int brojDnevnica, int brojPoludnevnica, String ukupno) {


        this.korisnik = new User(userId, "", "", "", "", "", "", "");
        this.NazivDrustva = nazivDrustva;
        this.ID = ID;
        this.broj = broj;
        this.mjestoFirme = mjestoFirme;
        this.dana = dana;
        this.sluzbenoOtputuje = sluzbenoOtputuje;
        this.mjestoPutovanja = mjestoPutovanja;
        this.zadaca = zadaca;
        this.trajanjePutovanja = trajanjePutovanja;
        this.trajanjePutovanjaSlovima = trajanjePutovanjaSlovima;
        this.auto = auto;
        this.troskoviPutovanjaTerete = troskoviPutovanjaTerete;
        this.isplataPredujma = isplataPredujma;
        this.odDatum = odDatum;
        this.doDatum = doDatum;
        this.pocetnoStanjeBrojila = pocetnoStanjeBrojila;
        this.zavrsnoStanjeBrojila = zavrsnoStanjeBrojila;
        this.razlikaBrojila = razlikaBrojila;
        this.brojSati = brojSati;
        this.brojDnevnica = brojDnevnica;
        this.brojPoludnevnica = brojPoludnevnica;
        this.ukupno = ukupno;
    }

    public PutniNalog() {
    }


    public String getOdDatum() {
        return odDatum;
    }

    public void setOdDatum(String odDatum) {
        this.odDatum = odDatum;
    }

    public String getDoDatum() {
        return doDatum;
    }

    public void setDoDatum(String doDatum) {
        this.doDatum = doDatum;
    }

    public String getPocetnoStanjeBrojila() {
        return pocetnoStanjeBrojila;
    }

    public void setPocetnoStanjeBrojila(String pocetnoStanjeBrojila) {
        this.pocetnoStanjeBrojila = pocetnoStanjeBrojila;
    }

    public String getZavrsnoStanjeBrojila() {
        return zavrsnoStanjeBrojila;
    }

    public void setZavrsnoStanjeBrojila(String zavrsnoStanjeBrojila) {
        this.zavrsnoStanjeBrojila = zavrsnoStanjeBrojila;
    }

    public int getRazlikaBrojila() {
        return razlikaBrojila;
    }

    public void setRazlikaBrojila(int razlikaBrojila) {
        this.razlikaBrojila = razlikaBrojila;
    }

    public double getBrojSati() {
        return brojSati;
    }

    public void setBrojSati(double brojSati) {
        this.brojSati = brojSati;
    }

    public int getBrojDnevnica() {
        return brojDnevnica;
    }

    public void setBrojDnevnica(int brojDnevnica) {
        this.brojDnevnica = brojDnevnica;
    }

    public int getBrojPoludnevnica() {
        return brojPoludnevnica;
    }

    public void setBrojPoludnevnica(int brojPoludnevnica) {
        this.brojPoludnevnica = brojPoludnevnica;
    }

    public String getUkupno() {
        return ukupno;
    }

    public void setUkupno(String ukupno) {
        this.ukupno = ukupno;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNazivDrustva() {
        return NazivDrustva;
    }

    public void setNazivDrustva(String nazivDrustva) {
        NazivDrustva = nazivDrustva;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public String getMjestoFirme() {
        return mjestoFirme;
    }

    public void setMjestoFirme(String mjestoFirme) {
        this.mjestoFirme = mjestoFirme;
    }

    public String getDana() {
        return dana;
    }

    public void setDana(String dana) {
        this.dana = dana;
    }

    public String getSluzbenoOtputuje() {
        return sluzbenoOtputuje;
    }

    public void setSluzbenoOtputuje(String sluzbenoOtputuje) {
        this.sluzbenoOtputuje = sluzbenoOtputuje;
    }

    public String getMjestoPutovanja() {
        return mjestoPutovanja;
    }

    public void setMjestoPutovanja(String mjestoPutovanja) {
        this.mjestoPutovanja = mjestoPutovanja;
    }

    public String getZadaca() {
        return zadaca;
    }

    public void setZadaca(String zadaca) {
        this.zadaca = zadaca;
    }

    public int getTrajanjePutovanja() {
        return trajanjePutovanja;
    }

    public void setTrajanjePutovanja(int trajanjePutovanja) {
        this.trajanjePutovanja = trajanjePutovanja;
    }

    public String getTrajanjePutovanjaSlovima() {
        return trajanjePutovanjaSlovima;
    }

    public void setTrajanjePutovanjaSlovima(String trajanjePutovanjaSlovima) {
        this.trajanjePutovanjaSlovima = trajanjePutovanjaSlovima;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getTroskoviPutovanjaTerete() {
        return troskoviPutovanjaTerete;
    }

    public void setTroskoviPutovanjaTerete(String troskoviPutovanjaTerete) {
        this.troskoviPutovanjaTerete = troskoviPutovanjaTerete;
    }

    public String getIsplataPredujma() {
        return isplataPredujma;
    }

    public void setIsplataPredujma(String isplataPredujma) {
        this.isplataPredujma = isplataPredujma;
    }

    public User getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(User korisnik) {
        this.korisnik = korisnik;
    }
}
