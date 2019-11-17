package com.buchhandlung.demo.Warenkorb;

import com.buchhandlung.demo.Kunde.Kunde;
import com.buchhandlung.demo.Lager.Lager;
import com.buchhandlung.demo.buchhandlung.Buch;

import javax.persistence.*;

@Entity
public class Warenkorb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int anzahl;

    @ManyToOne
    private Kunde kunde;

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

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
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
