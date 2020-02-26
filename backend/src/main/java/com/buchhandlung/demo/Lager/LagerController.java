package com.buchhandlung.demo.Lager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LagerController {

    @Autowired
    private LagerService lagerService;

    @GetMapping("/lagers")
    public List<Lager> getAllLager() {
        return this.lagerService.getAllLager();
    }

    @PostMapping("/lagers")
    public Lager createLager(@RequestBody Lager newLager) {
        return this.lagerService.createLager(newLager);
    }

}
