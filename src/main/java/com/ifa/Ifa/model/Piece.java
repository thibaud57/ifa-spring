package com.ifa.Ifa.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.ifa.Ifa.view.VueVoiture;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Piece {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(VueVoiture.class)
    private Integer id;

    @JsonView(VueVoiture.class)
    private String designation;

    //liaison many to many vers vehicule plusieurs vehicules pour plusieurs pieces et inversement
    @ManyToMany
    @JoinTable(
            name="vehicule_piece",
            joinColumns = @JoinColumn(name = "piece_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicule_id")
    )
    @JsonView(VueVoiture.class)
    List<Piece> listeVehicule = new ArrayList<>();
    //on utilise une liste (ici de vehicule)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<Piece> getListeVehicule() {
        return listeVehicule;
    }

    public void setListeVehicule(List<Piece> listeVehicule) {
        this.listeVehicule = listeVehicule;
    }
}
