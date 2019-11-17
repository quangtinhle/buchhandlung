package com.buchhandlung.demo.Warenkorb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WarenkorbController {

    @Autowired
    private WarenkorbService warenkorbService;

    @GetMapping("/warenkorb/{warenkorbId}")
    public Warenkorb getWarenkorb(@PathVariable int id) {
        return this.warenkorbService.getWarenkorb(id);
    }

    @PostMapping("/warenkorb")
    public Warenkorb createWarenkorb(@RequestBody Warenkorb warenkorb) {
        return this.warenkorbService.createWarenkorb(warenkorb);
    }

    @PutMapping("/warenkorb")
    public Warenkorb updateWarenkorb() {
        //TODO
        return null;
    }

    @DeleteMapping("/warenkorb/{warenkorbId}")
    public Warenkorb deleteWarenkorb(@PathVariable int id) {
        return this.warenkorbService.deleteWarenkorb(id);
    }
}
