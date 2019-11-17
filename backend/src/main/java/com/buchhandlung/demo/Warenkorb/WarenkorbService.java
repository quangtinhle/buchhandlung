package com.buchhandlung.demo.Warenkorb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarenkorbService {

    @Autowired
    private WarenkorbRepo warenkorbRepo;

    public Warenkorb getWarenkorb(int id) {
        return this.warenkorbRepo.findById(id).get();
    }

    public Warenkorb createWarenkorb(Warenkorb warenkorb) {
        return this.warenkorbRepo.save(warenkorb);
    }

    public Warenkorb deleteWarenkorb(int id) {
        Warenkorb deletedWarenkorb = this.warenkorbRepo.findById(id).get();
        this.warenkorbRepo.deleteById(id);
        return deletedWarenkorb;
    }
}
