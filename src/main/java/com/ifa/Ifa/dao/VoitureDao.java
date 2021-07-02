package com.ifa.Ifa.dao;

import com.ifa.Ifa.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//on utilise l'annotation repository pour indiquer que c'est un dao
@Repository
public interface VoitureDao extends JpaRepository<Voiture, Integer> {
    //le dao nous permet de communiquer directemetn avec la base de données en utilisant Jpa
    //ici on lui indique que le dao concerne la classe voiture et que sa clé primaire est un integer
}
