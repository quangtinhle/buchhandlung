package com.buchhandlung.demo.Bestellung;

import com.buchhandlung.demo.Kunde.Kunde;
import com.buchhandlung.demo.Lager.Lager;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Bestellung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date bestellungdatum;
    private String bestellungstatus;
    private double summe;


    @ManyToOne
    private Kunde kunde;
    @ManyToOne
    private Lager lager;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBestellungdatum() {
        return bestellungdatum;
    }

    public void setBestellungdatum(Date bestellungdatum) {
        this.bestellungdatum = bestellungdatum;
    }

    public String getBestellungstatus() {
        return bestellungstatus;
    }

    public void setBestellungstatus(String bestellungstatus) {
        this.bestellungstatus = bestellungstatus;
    }

    public double getSumme() {
        return summe;
    }

    public void setSumme(double summe) {
        this.summe = summe;
    }
}

