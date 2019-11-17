package com.buchhandlung.demo.LagerhasBuch;

import com.buchhandlung.demo.Lager.Lager;
import com.buchhandlung.demo.buchhandlung.Buch;

import javax.persistence.*;

@Entity
public class LagerHasBuch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int bestand;

    public int getBestand() {
        return bestand;
    }

    public void setBestand(int bestand) {
        this.bestand = bestand;
    }

    @ManyToOne
    private Buch buch;
    @ManyToOne
    private Lager lager;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Buch getBuch() {
        return buch;
    }

    public void setBuch(Buch buch) {
        this.buch = buch;
    }

    public Lager getLager() {
        return lager;
    }

    public void setLager(Lager lager) {
        this.lager = lager;
    }
}
