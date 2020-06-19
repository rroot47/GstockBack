package com.stock.controller;

import com.stock.dao.ArticleRepository;
import com.stock.entities.Articles;
import com.stock.exception.RessourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles")
    public List<Articles> getAllArticles(){
        System.out.println("GET ALL ARTICLES");
        List<Articles> articles=new ArrayList<>();
        articleRepository.findAll().forEach(articles::add);
        System.out.println(articles);
        return articles;
    }

    @GetMapping("/articlesById/{id}")
    public ResponseEntity<Articles> getArticleById(@PathVariable(value = "id") Long id_article)
    throws RessourceNotFoundException {
        Articles articles=articleRepository.findById(id_article)
                .orElseThrow(()->new RessourceNotFoundException("Article Not Found : " +id_article));
        System.out.println(ResponseEntity.ok().body(articles));
        return ResponseEntity.ok().body(articles);
    }
    @PostMapping("/ajouterArticle")
    public Articles saveArticle(@Validated @RequestBody Articles  articles){
        System.out.println("***********Debut***************");
        return articleRepository.save(articles);
    }
    @DeleteMapping("/deleteArticles/{id}")
    public Map<String, Boolean> deleteArticle(@PathVariable(value = "id") Long id_article)
            throws RessourceNotFoundException {
        Articles articles=articleRepository.findById(id_article)
                .orElseThrow(()->new RessourceNotFoundException("Article Not Found : " +id_article));
        System.out.println(articles);
        articleRepository.delete(articles);
        Map<String, Boolean> response=new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        System.out.println(response);
        return response;
    }

    @DeleteMapping("/deleteAllArticles")
    public ResponseEntity<String> deleteAllArticles(){
        System.out.println("Delete All Articles...");
        articleRepository.deleteAll();
        return new ResponseEntity<>("All Articles have been deleted", HttpStatus.OK);
    }
    @PutMapping("/updateArticle/{id}")
    public ResponseEntity<Articles> updateArticle(@PathVariable(value = "id") Long id_article ,@RequestBody Articles  articles){
        System.out.println("Update Articles widt ID = "+ id_article+ "...");
        Optional<Articles> articlesInfo=articleRepository.findById(id_article);
        System.out.println(articlesInfo);
        if(articlesInfo.isPresent()){
            Articles articles1=articlesInfo.get();
            System.out.println(articles1);
            articles1.setCode_art(articles.getCode_art());
            articles1.setLibelle_art(articles.getLibelle_art());
            articles1.setPrixachat_art(articles.getPrixachat_art());
            articles1.setTva_art(articles.getTva_art());
            articles1.setFodec_art(articles.getFodec_art());
            articles1.setDc(articles.getDc());
            articles1.setPrixvente_art(articles.getPrixvente_art());
            articles1.setId_cat(articles.getId_cat());
            articles1.setId_scat(articles.getId_scat());

         return new ResponseEntity<>(articleRepository.save(articles1), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}