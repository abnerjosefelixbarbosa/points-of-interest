package com.org.backendjava.repositories;

import com.org.backendjava.entities.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface POIRepository extends JpaRepository<POI, Long> {
}
