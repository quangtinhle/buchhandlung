package com.buchhandlung.demo.Kunde;


import org.hibernate.cache.spi.access.CachedDomainDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class KundeController {

    @Autowired
    private KundeService kundeService;

    @GetMapping("/kunde/{kundeId}")
    public Kunde getKunde(@PathVariable int kundeId) {
        return this.kundeService.getKunde(kundeId);
         }

    @GetMapping("/kunde")
    public List<Kunde> getAllKunden() {
        return this.kundeService.getAllKunde();
    }

    @PostMapping("/kunde}")
    public Kunde createKunde(@RequestBody Kunde kunde) {
        return this.kundeService.createKunde(kunde);
    }

    @PutMapping("/kunde/{kundeId}/{username}/{password}/{adresse}")
    public Kunde updateKunde(@PathVariable int kundeId,@PathVariable String username, @PathVariable String password, @PathVariable String adresse) {
        return this.kundeService.updateKunde(kundeId,username,password,adresse);
    }
    @DeleteMapping("/kunde/{kundeId}")
    public Kunde deleteKunde(@PathVariable int kundeId) {
        return this.kundeService.deleteKunde(kundeId);
    }
}
