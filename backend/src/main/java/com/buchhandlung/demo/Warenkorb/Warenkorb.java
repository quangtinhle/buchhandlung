package com.buchhandlung.demo.Warenkorb;

import com.buchhandlung.demo.Buch.Buch;
import com.buchhandlung.demo.Kunde.Kunde;
import com.buchhandlung.demo.Lager.Lager;


import javax.persistence.*;

@Entity
public class Warenkorb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    private int anzahl;

    @ManyToOne
    private Buch buch;

    @ManyToOne
    private Lager lager;

    @ManyToOne
    private Kunde kunde;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
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

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
