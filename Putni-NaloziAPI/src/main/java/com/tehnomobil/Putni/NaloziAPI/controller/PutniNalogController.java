package com.tehnomobil.Putni.NaloziAPI.controller;

import com.tehnomobil.Putni.NaloziAPI.moduls.PutniNalog;
import com.tehnomobil.Putni.NaloziAPI.moduls.User;
import com.tehnomobil.Putni.NaloziAPI.services.PutniNalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PutniNalogController {


    @Autowired
    PutniNalogService putniNalogService;

    @RequestMapping("/putniNalozi")
    public List<PutniNalog> getAllPutniNalog() {

        return putniNalogService.getAllPutniNalog();

    }

    @RequestMapping("/user/{userId}/putniNalozi")
    public List<PutniNalog> getPutneNalogeByUser(@PathVariable int userId) {

        return putniNalogService.getPutneNalogeByUser(userId);

    }

    @RequestMapping("/user/{userId}/putniNalozi/{id}")
    public PutniNalog getPutniNalogByUser(@PathVariable int id) {

        return putniNalogService.getPutniNalogByUser(id);

    }

    @RequestMapping("/putniNalozi/nedefinirano")
    public List<PutniNalog> getAllPutneNalogeBezVozila() {

        return putniNalogService.getAllPutneNalogeBezVozila();

    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/{userId}/putniNalozi")
    public void addPutniNalog(@PathVariable int userId, @RequestBody PutniNalog putniNalog) {

          putniNalog.setKorisnik(new User(userId,"","","","","","",""));


        putniNalogService.addPutniNalog(putniNalog);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/user/{userId}/putniNalozi/{id}")
    public void updatePutniNalog(@PathVariable int userId, @RequestBody PutniNalog putniNalog) {

        putniNalog.setKorisnik(new User(userId,"","","","","","",""));

        putniNalogService.updatePutniNalog(putniNalog);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/putniNalozi/{id}")
    public void deletePutniNalog(@PathVariable int id) {

        putniNalogService.deletePutniNalog(id);

    }

    @RequestMapping("/putniNalozi/broj")
    public int brojPutnihNaloga(){

       return putniNalogService.brojPutnihNaloga();
    }


}
