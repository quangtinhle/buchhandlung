package com.buchhandlung.demo.Lager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
