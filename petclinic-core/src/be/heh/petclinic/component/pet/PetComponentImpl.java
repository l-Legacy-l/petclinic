package be.heh.petclinic.component.pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import javax.sql.DataSource;

import be.heh.petclinic.domain.*;

class PetComponentImpl implements PetComponent {

    private JdbcPetDao petDao;
    
  
    public PetComponentImpl(DataSource dataSource){
        petDao = new JdbcPetDao(dataSource); 
    }

    @Override
    public Collection<Pet> getPets() {
        List<Pet> pets = petDao.getPets();
   
        return pets;
    }

    @Override
    public Collection<Pet> getPetsBySearch(String search){
        List<Pet> pets = petDao.getPetsBySearch(search);

        return pets;
    }

    @Override
    public void addPetById(String type, String name, String birthdate, int ownerId) {
        petDao.addPetById(type, name, birthdate, ownerId);
    }

    @Override
    public Collection<Pet> getPetsByOwnerId(int ownerId) {
        List<Pet> pets = petDao.getPetsByOwnerId(ownerId);

        return pets;
    }

    @Override
    public void updatePet(int id, String type, String name, String birthdate, int ownerId) {
        petDao.updatePet(id,type,name,birthdate,ownerId);
    }

    @Override
    public void deletePet(int id) {
        petDao.deletePet(id);

    }

    @Override
    public Collection<Pet> getPetById(int id) {
        List<Pet> pets = petDao.getPetById(id);

        return pets;
    }



}