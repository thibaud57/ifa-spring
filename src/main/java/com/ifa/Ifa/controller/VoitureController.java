package com.ifa.Ifa.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.ifa.Ifa.dao.VoitureDao;
import com.ifa.Ifa.model.Voiture;
import com.ifa.Ifa.view.VueVoiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

//l'annotation ci-dessous nous permet d'indiquer que c'est un rest controller
@RestController
public class VoitureController {

    //on ajoute le dao
    private VoitureDao voitureDao;

    //on injecte avec autowired
    @Autowired
    VoitureController(VoitureDao voitureDao){
        this.voitureDao = voitureDao;
    }


    //ensuite on réalise un crud simple à l'aide des mappings et on rajoute son url
    @GetMapping("/liste-voiture")
    @JsonView(VueVoiture.class)
    public List<Voiture> afficheListeVoiture () {
        return voitureDao.findAll();
        //on peut directement utilisé les methodes du dao proposés par jpa
    }


    @GetMapping("/voiture/{id}")
    @JsonView(VueVoiture.class)
    public ResponseEntity<Voiture> afficheVoiture(@PathVariable Integer id) {
        //quand on utilise une valeur externe comme un id, on a besoin d'indiquer @path variable qui va check dans l'url
        Optional<Voiture> voiture = voitureDao.findById(id);

        if(voiture.isPresent()){
            return ResponseEntity.ok(voiture.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/voiture")
    public ResponseEntity<String> ajouterVoiture(@RequestBody Voiture voiture) {

        voitureDao.saveAndFlush(voiture);

        return ResponseEntity.created(
                URI.create("/voiture/" + voiture.getId())
        ).build();
    }

    @DeleteMapping("/voiture/{id}")
    public ResponseEntity<Integer> supprimerVoiture(@PathVariable int id){

        if(voitureDao.existsById(id)) {
            voitureDao.deleteById(id);
            return ResponseEntity.ok(id);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
