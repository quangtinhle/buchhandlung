package com.buchhandlung.demo.LagerhasBuch;

import com.buchhandlung.demo.Lager.Lager;
import com.buchhandlung.demo.Lager.LagerService;
import com.buchhandlung.demo.Buch.Buch;
import com.buchhandlung.demo.Buch.BuchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LagerHasBuchService {

    @Autowired
    private BuchService buchService;
    @Autowired
    private LagerService lagerService;
    @Autowired
    private LagerHasBuchRepo lagerHasBuchRepo;


    public List<LagerHasBuch> getAllLagerHasBuch() {
        return (List<LagerHasBuch>)this.lagerHasBuchRepo.findAll();
    }

    public LagerHasBuch createLagerHasBuch(int buchId, int lagerId, int bestand) {
        Buch buch = this.buchService.getBuch(buchId);
        Lager lager = this.lagerService.getLager(lagerId);

        LagerHasBuch lagerHasBuch = new LagerHasBuch();
        lagerHasBuch.setBuch(buch);
        lagerHasBuch.setLager(lager);
        lagerHasBuch.setBestand(bestand);
        return this.lagerHasBuchRepo.save(lagerHasBuch);
    }

    public LagerHasBuch deleteLagerHasBuch(int lagerhasbuchId) {
        LagerHasBuch lagerHasBuch = new LagerHasBuch();
        lagerHasBuch = this.lagerHasBuchRepo.findById(lagerhasbuchId).get();
        this.lagerHasBuchRepo.deleteById(lagerhasbuchId);
        return lagerHasBuch;
    }

    public LagerHasBuch getLagerHasBuch(int lagerhasbuchId) {
        return this.lagerHasBuchRepo.findById(lagerhasbuchId).get();
    }

    public LagerHasBuch updateLagerHasBuch(int lagerhasbuchId, int buchId, int lagerId, int bestand) {
        LagerHasBuch updatedLagerhasBuch = this.lagerHasBuchRepo.findById(lagerhasbuchId).get();

        updatedLagerhasBuch.setBuch(this.buchService.getBuch(buchId));
        updatedLagerhasBuch.setLager(this.lagerService.getLager(lagerId));
        updatedLagerhasBuch.setBestand(bestand);

        return updatedLagerhasBuch;
    }
}
