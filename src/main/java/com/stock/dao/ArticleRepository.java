package com.stock.dao;

import com.stock.entities.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleRepository  extends JpaRepository<Articles, Long> {
}
