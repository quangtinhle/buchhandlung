package com.buchhandlung.demo.Bestellung;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BestellungController {
    @Autowired
    private BestellungService bestellungService;

    @GetMapping("/bestellung/{bestellungId}")
    public Bestellung getBestellung(@PathVariable int bestellungId) {
        //TODO
        return null;
    }

    @GetMapping("/bestellung/{kundeId}")
    public List<Bestellung> getAllBestellungbyKunde(@PathVariable int id) {
        return this.bestellungService.getAllBestellungbyKunde(id);
    }

    @PostMapping("/bestellung")
    public Bestellung createBestellung(@RequestBody Bestellung bestellung) {
        return this.bestellungService.createBestellung(bestellung);
    }

    @PutMapping("/bestellung/{bestellungId}")
    public Bestellung updateBestellung(@PathVariable int bestellungid) {
        return this.bestellungService.updateBestellung(bestellungid);
    }

    @DeleteMapping("/bestellung/{bestellungId}")
    public Bestellung deleteBestellung(@PathVariable int bestellungid) {
        return this.bestellungService.deleteBestellung(bestellungid);
    }
}
