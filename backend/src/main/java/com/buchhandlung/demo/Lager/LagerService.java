package com.buchhandlung.demo.Lager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LagerService {

    @Autowired
    private LagerRepo lagerRepo;


    public List<Lager> getAllLager() {
        return (List<Lager>)this.lagerRepo.findAll();
    }

    public Lager createLager(Lager newLager) {
        return this.lagerRepo.save(newLager);
    }

    public Lager getLager(int lagerId) {
        return this.lagerRepo.findById(lagerId).get();
    }
}
