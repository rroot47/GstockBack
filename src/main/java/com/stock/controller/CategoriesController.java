package com.stock.controller;

import com.stock.dao.CategoriesRepository;
import com.stock.entities.Categories;
import com.stock.entities.Categories;
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
public class CategoriesController {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @GetMapping("/categories")
    public List<Categories> getAllCategories(){
        System.out.println("GET ALL CategoriesS");
        List<Categories> categories=new ArrayList<>();
        categoriesRepository.findAll().forEach(categories::add);
        System.out.println(categories);
        return categories;
    }

    @GetMapping("/CategoriessById/{id}")
    public ResponseEntity<Categories> getCategoriesById(@PathVariable(value = "id") Long id_categories)
            throws RessourceNotFoundException {
        Categories categories=categoriesRepository.findById(id_categories)
                .orElseThrow(()->new RessourceNotFoundException("Categories Not Found : " +id_categories));
        System.out.println(ResponseEntity.ok().body(categories));
        return ResponseEntity.ok().body(categories);
    }
    @PostMapping("/ajouterCategories")
    public Categories saveCategories(@Validated @RequestBody Categories  categories){
        System.out.println("***********Debut***************");
        return categoriesRepository.save(categories);
    }
    @DeleteMapping("/deleteCategories/{id}")
    public Map<String, Boolean> deleteCategories(@PathVariable(value = "id") Long id_categories)
            throws RessourceNotFoundException {
        Categories categories=categoriesRepository.findById(id_categories)
                .orElseThrow(()->new RessourceNotFoundException("Categories Not Found : " +id_categories));
        System.out.println(categories);
        categoriesRepository.delete(categories);
        Map<String, Boolean> response=new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        System.out.println(response);
        return response;
    }

    @DeleteMapping("/deleteAllCategoriess")
    public ResponseEntity<String> deleteAllCategories(){
        System.out.println("Delete All Categoriess...");
        categoriesRepository.deleteAll();
        return new ResponseEntity<>("All Categoriess have been deleted", HttpStatus.OK);
    }
    @PutMapping("/updateCategories/{id}")
    public ResponseEntity<Categories> updateCategories(@PathVariable(value = "id") Long id_Categories ,@RequestBody Categories  categories){
        System.out.println("Update Categoriess widt ID = "+ id_Categories+ "...");
        Optional<Categories> categoriessInfo=categoriesRepository.findById(id_Categories);
        System.out.println(categoriessInfo);
        if(categoriessInfo.isPresent()){
            Categories categories1=categoriessInfo.get();
            System.out.println(categories1);
            categories1.setCode_cat(categories.getCode_cat());
            categories1.setLibelle_cat(categories.getLibelle_cat());

            return new ResponseEntity<>(categoriesRepository.save(categories1), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
