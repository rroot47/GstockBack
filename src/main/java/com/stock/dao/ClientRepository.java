package com.stock.dao;

import com.stock.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository  extends JpaRepository<Clients, Long> {
}
