package com.ifa.Ifa.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.ifa.Ifa.view.VueVoiture;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(VueVoiture.class)
    private Integer id;

    @JsonView(VueVoiture.class)
    private Boolean electrique;

    @JsonView(VueVoiture.class)
    private String marque;

    //liaison many to many vers piece
    @ManyToMany
    @JoinTable(
            name="vehicule_piece",
            joinColumns = @JoinColumn(name = "vehicule_id"),
            inverseJoinColumns = @JoinColumn(name = "piece_id")
    )
    @JsonView(VueVoiture.class)
    List<Piece> listePiece = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getElectrique() {
        return electrique;
    }

    public void setElectrique(Boolean electrique) {
        this.electrique = electrique;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public List<Piece> getListePiece() {
        return listePiece;
    }

    public void setListePiece(List<Piece> listePiece) {
        this.listePiece = listePiece;
    }
}
