package com.buchhandlung.demo.Kunde;

import com.buchhandlung.demo.buchhandlung.Buch;
import com.buchhandlung.demo.buchhandlung.BuchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KundeService {

    @Autowired
    private KundeRepo kundeRepo;


    public Kunde getKunde(int kundeId) {

        return this.kundeRepo.findById(kundeId).get();
    }

    public List<Kunde> getAllKunde() {
        List<Kunde> liste = new ArrayList<>();
        this.kundeRepo.findAll().forEach(kunde -> liste.add(kunde));
        return liste;
    }

    public Kunde createKunde(Kunde kunde) {
        return this.kundeRepo.save(kunde);
    }

    public Kunde updateKunde(int kundeId, String username, String password, String adresse) {
        Kunde updatedKunde = this.kundeRepo.findById(kundeId).get();
        updatedKunde.setUsername(username);
        updatedKunde.setPassword(password);
        updatedKunde.setAdresse(adresse);

        return updatedKunde;
    }

    public Kunde deleteKunde(int kundeId) {
        Kunde deletedKunde = this.kundeRepo.findById(kundeId).get();
        this.kundeRepo.deleteById(kundeId);
        return deletedKunde;
    }
}
