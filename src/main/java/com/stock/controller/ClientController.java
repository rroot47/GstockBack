package com.stock.controller;

import com.stock.dao.ClientRepository;
import com.stock.entities.Clients;
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
public class ClientController {


    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<Clients> getAllClients(){
        System.out.println("GET ALL ClientsS");
        List<Clients> clients=new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);
        System.out.println(clients);
        return clients;
    }

    @GetMapping("/clients/clientsById/{id}")
    public ResponseEntity<Clients> getClientById(@PathVariable(value = "id") Long id_client)
            throws RessourceNotFoundException {
        Clients Clients=clientRepository.findById(id_client)
                .orElseThrow(()->new RessourceNotFoundException("Clients Not Found : " +id_client));
        System.out.println(ResponseEntity.ok().body(Clients));
        return ResponseEntity.ok().body(Clients);
    }
    @PostMapping("/clients/ajouterClients")
    public Clients saveClient(@Validated @RequestBody Clients  client){
        System.out.println("***********Debut***************");
        return clientRepository.save(client);
    }
    @DeleteMapping("/clients/deleteClient/{id}")
    public Map<String, Boolean> deleteClient(@PathVariable(value = "id") Long id_client)
            throws RessourceNotFoundException {
        Clients client=clientRepository.findById(id_client)
                .orElseThrow(()->new RessourceNotFoundException("Clients Not Found : " +id_client));
        System.out.println(client);
        clientRepository.delete(client);
        Map<String, Boolean> response=new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        System.out.println(response);
        return response;
    }

    @DeleteMapping("/clients/deleteAllClients")
    public ResponseEntity<String> deleteAllClients(){
        System.out.println("Delete All Clients...");
        clientRepository.deleteAll();
        return new ResponseEntity<>("All Clients have been deleted", HttpStatus.OK);
    }
    @PutMapping("/clients" +
            "/updateClient/{id}")
    public ResponseEntity<Clients> updateClient(@PathVariable(value = "id") Long id_client ,@RequestBody Clients  client){
        System.out.println("Update Clientss widt ID = "+ id_client+ "...");
        Optional<Clients> clientInfo=clientRepository.findById(id_client);
        System.out.println(clientInfo);
        if(clientInfo.isPresent()){
            Clients client1=clientInfo.get();
            System.out.println(client1);
            client1.setCode_client(client.getCode_client());
            client1.setLibelle_client(client.getLibelle_client());
            client1.setAdresse_client(client.getAdresse_client());
            client1.setContact_client(client.getContact_client());
            client1.setEmail_client(client.getEmail_client());
            client1.setLogin_client(client.getLogin_client());
            client1.setMatfis_client(client.getMatfis_client());
            client1.setPwd_client(client.getPwd_client());
            client1.setTel_client(client.getTel_client());
            client1.setSoldeinit_client(client.getSoldeinit_client());
            client1.setSolde_client(client.getSolde_client());
            client1.setTimbre_client(client.getTimbre_client());
            return new ResponseEntity<>(clientRepository.save(client1), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
