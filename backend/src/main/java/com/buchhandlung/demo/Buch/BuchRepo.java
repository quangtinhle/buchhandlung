package com.buchhandlung.demo.Buch;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuchRepo extends CrudRepository<Buch, Integer> {
}
