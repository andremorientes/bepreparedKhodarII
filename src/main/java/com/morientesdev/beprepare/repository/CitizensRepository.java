package com.morientesdev.beprepare.repository;

import com.morientesdev.beprepare.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizensRepository extends JpaRepository<Citizen, Long> {
}
