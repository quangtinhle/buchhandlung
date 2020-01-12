package com.buchhandlung.demo.Warenkorb;

import com.buchhandlung.demo.Buch.Buch;
import com.buchhandlung.demo.Buch.BuchRepo;
import com.buchhandlung.demo.Kunde.Kunde;
import com.buchhandlung.demo.Kunde.KundeRepo;
import com.buchhandlung.demo.Lager.Lager;
import com.buchhandlung.demo.Lager.LagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarenkorbService {

    @Autowired
    private WarenkorbRepo warenkorbRepo;
    @Autowired
    private BuchRepo buchRepo;
    @Autowired
    private KundeRepo kundeRepo;
    @Autowired
    private LagerRepo lagerRepo;


    public Warenkorb getWarenkorb(int warenkorbId) {
        return this.warenkorbRepo.findById(warenkorbId).get();
    }

    public Warenkorb createWarenkorb(int anzahl, int buchId, int kundeId, int lagerId) {
        Buch newBuch = this.buchRepo.findById(buchId).get();
        Kunde newKunde = this.kundeRepo.findById(kundeId).get();
        Lager newLager = this.lagerRepo.findById(lagerId).get();

        Warenkorb newWarenkorb = new Warenkorb();
        newWarenkorb.setAnzahl(anzahl);
        newWarenkorb.setBuch(newBuch);
        newWarenkorb.setKunde(newKunde);
        newWarenkorb.setLager(newLager);

        return this.warenkorbRepo.save(newWarenkorb);
    }
}
