--liquibase formatted sql

--changeset fabio:3

USE petclinic;
INSERT INTO vet (lastname, firstname, speciality) VALUES ("James", "James", "none");

INSERT INTO vet (lastname, firstname, speciality) VALUES ("Helen", "Helen", "radiology");

INSERT INTO vet (lastname, firstname, speciality) VALUES ("Linda", "Linda", "surgery");

INSERT INTO owner (lastname, firstname, address, city, telephone) VALUES("Nick", "Nick", "49 Rue de la paix", "Paris", "0494012345");

INSERT INTO owner (lastname, firstname, address, city, telephone) VALUES("Jane", "Jane", "50 Rue de la croix", "Paris", "0494123456");

INSERT INTO owner (lastname, firstname, address, city, telephone) VALUES("Jim", "Jim", "51 Rue de la fosse", "Bruxelles", "0494234567");

INSERT INTO pet (type, name, birthdate,ownerId) VALUES ("Chien", "Medor", "2016-04-12","3");

INSERT INTO pet (type, name, birthdate,ownerId) VALUES ("Chat", "Flo", "2011-08-08","1");

INSERT INTO pet (type, name, birthdate,ownerId) VALUES ("Tortue", "Tortette", "2014-08-23","2");

INSERT INTO visit (date, description, petId, vetId) VALUES ("2012-12-24", "description de visite 1", "2","1");

INSERT INTO visit (date, description, petId, vetId) VALUES ("2013-11-24", "description de visite 2", "3","1");

INSERT INTO visit (date, description, petId, vetId) VALUES ("2009-09-18", "description de visite 3", "2","3");

INSERT INTO visit (date, description, petId, vetId) VALUES ("2015-01-02", "description de visite 4", "1","2");

