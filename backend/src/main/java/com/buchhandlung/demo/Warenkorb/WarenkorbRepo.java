package com.buchhandlung.demo.Warenkorb;

import com.buchhandlung.demo.Kunde.Kunde;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarenkorbRepo extends CrudRepository<Warenkorb, Integer> {
    List<Warenkorb> findByKunde(Kunde kunde);
}
