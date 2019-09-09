package com.codegym.tnlbe.repository;

import com.codegym.tnlbe.entity.LandLord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LandLordRepository extends CrudRepository<LandLord, Long> {
    Optional<LandLord> findByName(String name);
    Boolean existsByName(String name);
    Boolean existsByEmail(String email);
}
