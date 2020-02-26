package com.buchhandlung.demo.Warenkorb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class WarenkorbController {

    @Autowired
    private WarenkorbService warenkorbService;


    @GetMapping("/warenkorb/{warenkorbId}")
    public Warenkorb getWarenkorb(@PathVariable int warenkorbId) {
        return this.warenkorbService.getWarenkorb(warenkorbId);
    }

    @PostMapping("/warenkorb/{anzahl}/{buchId}/{kundeId}/{lagerId}")
    public Warenkorb createWarenkorb(@PathVariable int anzahl, @PathVariable int buchId, @PathVariable int kundeId, @PathVariable int lagerId) {
        return this.warenkorbService.createWarenkorb(anzahl, buchId, kundeId, lagerId);
    }
}

