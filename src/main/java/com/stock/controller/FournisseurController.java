package com.stock.controller;

import com.stock.dao.FournisseurRepository;
import com.stock.entities.Fournisseur;
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
public class FournisseurController {


    @Autowired
    private FournisseurRepository fournisseurRepository;

    @GetMapping("/fournisseur")
    public List<Fournisseur> getAllFournisseur(){
        System.out.println("GET ALL FournisseurS");
        List<Fournisseur> fournisseur=new ArrayList<>();
        fournisseurRepository.findAll().forEach(fournisseur::add);
        System.out.println(fournisseur);
        return fournisseur;
    }

    @GetMapping("/fournisseurById/{id}")
    public ResponseEntity<Fournisseur> getFourniseurById(@PathVariable(value = "id") Long id_f)
            throws RessourceNotFoundException {
        Fournisseur fournisseur=fournisseurRepository.findById(id_f)
                .orElseThrow(()->new RessourceNotFoundException("Fournisseur Not Found : " +id_f));
        System.out.println(ResponseEntity.ok().body(fournisseur));
        return ResponseEntity.ok().body(fournisseur);
    }
    @PostMapping("/ajouterFournisseur")
    public Fournisseur saveFourniseur(@Validated @RequestBody Fournisseur  fournisseur){
        System.out.println("***********Debut***************");
        return  fournisseurRepository.save(fournisseur);
    }
    @DeleteMapping("/deleteFournisseur/{id}")
    public Map<String, Boolean> deleteFourniseurs(@PathVariable(value = "id") Long id_f)
            throws RessourceNotFoundException {
        Fournisseur fournisseur=fournisseurRepository.findById(id_f)
                .orElseThrow(()->new RessourceNotFoundException("Fournisseur Not Found : " +id_f));
        System.out.println(fournisseur);
        fournisseurRepository.delete(fournisseur);
        Map<String, Boolean> response=new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        System.out.println(response);
        return response;
    }

    @DeleteMapping("/deleteAllFournisseurs")
    public ResponseEntity<String> deleteAllFournisseur(){
        System.out.println("Delete All Fournisseur...");
        fournisseurRepository.deleteAll();
        return new ResponseEntity<>("All Fournisseur have been deleted", HttpStatus.OK);
    }
    @PutMapping("/updateFourniseur/{id}")
    public ResponseEntity<Fournisseur> updateFourniseur(@PathVariable(value = "id") Long id_f ,@RequestBody Fournisseur  fournisseur){
        System.out.println("Update Fournisseur widt ID = "+ id_f+ "...");
        Optional<Fournisseur> fournisseurInfo=fournisseurRepository.findById(id_f);
        System.out.println(fournisseurInfo);
        if(fournisseurInfo.isPresent()){
            Fournisseur fournisseur1=fournisseurInfo.get();
            System.out.println(fournisseur1);
            fournisseur1.setCode_f(fournisseur.getCode_f());
            fournisseur1.setLibelle_f(fournisseur.getLibelle_f());
            fournisseur1.setAdresse_f(fournisseur.getAdresse_f());
            fournisseur1.setContact_f(fournisseur.getContact_f());
            fournisseur1.setEmail_f(fournisseur.getEmail_f());
            fournisseur1.setLogin_f(fournisseur.getLogin_f());
            fournisseur1.setMatfis_f(fournisseur.getMatfis_f());
            fournisseur1.setTel_f(fournisseur.getTel_f());
            fournisseur1.setSoldeinit_f(fournisseur.getSoldeinit_f());
            fournisseur1.setSolde_f(fournisseur.getSolde_f());
            fournisseur1.setPwd_f(fournisseur.getPwd_f());
            return new ResponseEntity<>(fournisseurRepository.save(fournisseur1), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
