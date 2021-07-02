package com.ifa.Ifa.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.ifa.Ifa.view.VueVoiture;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

//voiture hérite de vehicule
@Entity
public class Voiture extends Vehicule {

    //on a un many to one vers moteur, car plusieurs moteurs pour en selectionner un pour notre voiture
    @ManyToOne
    @JsonView(VueVoiture.class)
    private Moteur moteur;

    public Moteur getMoteur() {
        return moteur;
    }

    public void setMoteur(Moteur moteur) {
        this.moteur = moteur;
    }
}
