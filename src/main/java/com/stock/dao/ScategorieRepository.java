package com.stock.dao;

import com.stock.entities.Scategorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScategorieRepository extends JpaRepository<Scategorie, Long> {
}
