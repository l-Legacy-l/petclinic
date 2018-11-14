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
        List<Pet> pets = petDao.getEvents();
   
        return pets;
    }

    @Override
    public Collection<Pet> getPetsType(){
        List<Pet> pets = petDao.getPetType();

        return pets;
    }

   

    

   

    


}