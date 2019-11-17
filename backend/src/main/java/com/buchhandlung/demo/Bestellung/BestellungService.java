package com.buchhandlung.demo.Bestellung;

import com.buchhandlung.demo.Kunde.Kunde;
import com.buchhandlung.demo.Kunde.KundeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BestellungService {

    @Autowired
    private BestellunRepo bestellunRepo;

    @Autowired
    private KundeRepo kundeRepo;

    public List<Bestellung> getAllBestellungbyKunde(int id) {

        Kunde kunde = this.kundeRepo.findById(id).get();
        return this.bestellunRepo.findByKunde(kunde);

    }

    public Bestellung createBestellung(Bestellung bestellung) {
        return this.bestellunRepo.save(bestellung);
    }

    public Bestellung updateBestellung(int bestellungid) {
        //TODO
        return null;
    }

    public Bestellung deleteBestellung(int bestellungid) {
        Bestellung deletedBestellung = this.bestellunRepo.findById(bestellungid).get();
        this.bestellunRepo.deleteById(bestellungid);
        return deletedBestellung;

    }
}
