package be.heh.petclinic.web;

import java.util.Collection;

import be.heh.petclinic.component.owner.OwnerComponent;
import be.heh.petclinic.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;

import be.heh.petclinic.component.vet.VetComponent;
import be.heh.petclinic.domain.Vet;

import java.util.List;
import java.util.Collection;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController

public class OwnerRestController {

	public String nom;
	public String prenom;

	@Autowired
	private OwnerComponent OwnerComponentImpl;

	//@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@CrossOrigin
	@RequestMapping("api/v1/owners")
	public ResponseEntity<Collection<Owner>> getOwners(){

		Collection<Owner> owners = OwnerComponentImpl.getOwners();
		if(owners.isEmpty()){
			return new ResponseEntity<Collection<Owner>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Owner>>(owners,HttpStatus.OK);
	}

	@RequestMapping(value="api/v1/ownerInsert",params = {"firstname","lastname","address","city",
			"telephone"},method = GET)
	@ResponseBody
	public ResponseEntity<Owner> insertPet(@RequestParam Map<String,String> param)
	{
		String firstname = param.get("firstname");
		String lastname = param.get("lastname");
		String address = param.get("address");
		String city = param.get("city");
		String telephone = param.get("telephone");

		OwnerComponentImpl.addOwner(firstname,lastname,address,city,telephone);
		return new ResponseEntity<Owner>(HttpStatus.CREATED);
	}
	@RequestMapping(value = "api/v1/owners/tri",params = {"firstname","lastname"}, method = RequestMethod.GET)
	@ResponseBody
		public ResponseEntity<Collection<Owner>> getOwnersName(@RequestParam Map<String,String>param)
		{
			nom = param.get("lastname");
			prenom = param.get("firstname");

			Collection<Owner> owners = OwnerComponentImpl.getOwnersName(prenom,nom);
			if(owners.isEmpty()){
				return new ResponseEntity<Collection<Owner>>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Collection<Owner>>(owners,HttpStatus.OK);
		}
}