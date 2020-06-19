package com.stock.controller;

import com.stock.dao.ScategorieRepository;
import com.stock.entities.Scategorie;
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
public class ScategorieController {

    @Autowired
    private ScategorieRepository scategorieRepository;

    @GetMapping("/Scategories")
    public List<Scategorie> getAllScategorie(){
        System.out.println("GET ALL ScategorieS");
        List<Scategorie> scategorie=new ArrayList<>();
        scategorieRepository.findAll().forEach(scategorie::add);
        System.out.println(scategorie);
        return scategorie;
    }

    @GetMapping("/scategoriesById/{id}")
    public ResponseEntity<Scategorie> getScategorieById(@PathVariable(value = "id") Long id_scat)
            throws RessourceNotFoundException {
        Scategorie scategorie=scategorieRepository.findById(id_scat)
                .orElseThrow(()->new RessourceNotFoundException("Scategorie Not Found : " +id_scat));
        System.out.println(ResponseEntity.ok().body(scategorie));
        return ResponseEntity.ok().body(scategorie);
    }
    @PostMapping("/ajouterScategorie")
    public Scategorie saveScategorie(@Validated @RequestBody Scategorie  scategorie){
        System.out.println("***********Debut***************");
        return scategorieRepository.save(scategorie);
    }
    @DeleteMapping("/deleteScategorie/{id}")
    public Map<String, Boolean> deleteScategorie(@PathVariable(value = "id") Long id_scat)
            throws RessourceNotFoundException {
        Scategorie scategorie=scategorieRepository.findById(id_scat)
                .orElseThrow(()->new RessourceNotFoundException("Scategorie Not Found : " +id_scat));
        System.out.println(scategorie);
        scategorieRepository.delete(scategorie);
        Map<String, Boolean> response=new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        System.out.println(response);
        return response;
    }

    @DeleteMapping("/deleteAllScategories")
    public ResponseEntity<String> deleteAllScategorie(){
        System.out.println("Delete All Scategories...");
        scategorieRepository.deleteAll();
        return new ResponseEntity<>("All Scategories have been deleted", HttpStatus.OK);
    }
    @PutMapping("/updateScategorie/{id}")
    public ResponseEntity<Scategorie> updateScategorie(@PathVariable(value = "id") Long id_scat ,@RequestBody Scategorie  scategorie){
        System.out.println("Update Scategories widt ID = "+ id_scat+ "...");
        Optional<Scategorie> scategoriesInfo=scategorieRepository.findById(id_scat);
        System.out.println(scategoriesInfo);
        if(scategoriesInfo.isPresent()){
            Scategorie scategorie1=scategoriesInfo.get();
            System.out.println(scategorie1);
            scategorie1.setCode_scat(scategorie.getCode_scat());
            scategorie1.setLibelle_scat(scategorie.getLibelle_scat());
            scategorie1.setId_cat(scategorie.getId_cat());
            return new ResponseEntity<>(scategorieRepository.save(scategorie1), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
