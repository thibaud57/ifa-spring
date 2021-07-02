insert into vehicule (electrique, marque) values (false,"Peugeot"), (false,"Citroen"), (false,"Renault"), (true,"Tesla");
insert into moteur (nom) values ("v8"), ("v12");
insert into voiture (id, moteur_id) values (1,1), (2,2);
insert into piece (designation) values ("alternateur"), ("injecteur"), ("bougies");
insert into piece_vehicule (vehicule_id, piece_id) values (1,1), (1,2), (2,1), (2,3);