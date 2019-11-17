package com.buchhandlung.demo.Bestellung;

import com.buchhandlung.demo.Kunde.Kunde;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BestellunRepo extends CrudRepository<Bestellung, Integer> {
    public List<Bestellung> findByKunde(Kunde kunde);
}
