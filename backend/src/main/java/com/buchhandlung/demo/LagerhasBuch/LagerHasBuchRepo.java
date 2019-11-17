package com.buchhandlung.demo.LagerhasBuch;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LagerHasBuchRepo extends CrudRepository<LagerHasBuch, Integer> {
}
