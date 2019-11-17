package com.buchhandlung.demo.LagerhasBuch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LagerHasBuchController {

    @Autowired
    private LagerHasBuchService lagerHasBuchService;

    @GetMapping("/lagerhasbuch/{lagerhasbuchId}")
    public LagerHasBuch getLagerHasBuch(@PathVariable int lagerhasbuchId){
        return this.lagerHasBuchService.getLagerHasBuch(lagerhasbuchId);
    }

    @GetMapping("/lagerhasbuch")
    public List<LagerHasBuch> getAllLagerHasBuch() {
        return this.lagerHasBuchService.getAllLagerHasBuch();
    }

    @PostMapping("/lagerhasbuch/{buchId}/{lagerId}/{bestand}")
    public LagerHasBuch createLagerHasBuch(@PathVariable int buchId, @PathVariable int lagerId, @PathVariable int bestand){
        return this.lagerHasBuchService.createLagerHasBuch(buchId, lagerId, bestand);
    }


    @PutMapping("/lagerhasbuch/{lagerhasBuchId}/{buchId}/{lagerId}/{bestand}")
    public LagerHasBuch updateLagerHasBuch(@PathVariable int lagerhasbuchId, @PathVariable int buchId, @PathVariable int lagerId, @PathVariable int bestand) {
        return this.lagerHasBuchService.updateLagerHasBuch(lagerhasbuchId,buchId,lagerId,bestand);
    }

    @DeleteMapping("/lagerhasbuch/{lagerhasbuchId}")
    public LagerHasBuch deleteLagerHasBuch(@PathVariable int lagerhasbuchId) {
        return this.lagerHasBuchService.deleteLagerHasBuch(lagerhasbuchId);
    }

}
