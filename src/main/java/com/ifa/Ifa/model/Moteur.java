package com.ifa.Ifa.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.ifa.Ifa.view.VueVoiture;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//les annotation permettent d'indiquer que c est une entité et qu'il faut etre attentif aux changements
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Moteur {

    //on indique sa clé primaire (son id) et la stratégie de génération automatique
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(VueVoiture.class)
    private Integer id;

    @JsonView(VueVoiture.class)
    private String nom;

    //liaison one to many vers moteur, un moteur pour plusieurs voiture
    @OneToMany(mappedBy = "moteur")
    List<Voiture> listeVoiture = new ArrayList<>();
    //on utilise ainsi une liste de voiture

    //on ajoute les getters et setters de toutes les propriétés
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Voiture> getListeVoiture() {
        return listeVoiture;
    }

    public void setListeVoiture(List<Voiture> listeVoiture) {
        this.listeVoiture = listeVoiture;
    }
}
