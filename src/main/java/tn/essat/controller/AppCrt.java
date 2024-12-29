package tn.essat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.essat.dao.IAdherant;
import tn.essat.dao.IAdministrateur;
import tn.essat.dao.IReservation;
import tn.essat.dao.ITerrain;
import tn.essat.dao.IUserDao;
import tn.essat.model.Adherant;
import tn.essat.model.Reservation;
import tn.essat.model.Terrain;



@CrossOrigin("*")
@RestController
@RequestMapping("/api")

public class AppCrt {
	   @Autowired
	    private IAdherant dao_add;

	    @Autowired
	    private IAdministrateur dao_admin;

	    @Autowired
	    private IReservation dao_Rev;

	    @Autowired
	    private ITerrain dao_Ter;
	    
	    @Autowired
		IUserDao dao_user;

	    // Terrain 

	    @GetMapping("/terrains")
	    public List<Terrain> getAllTerrains() {
	        return dao_Ter.findAll();
	    }

	    @PostMapping("/terrains")
	    public Terrain addTerrain(@RequestBody Terrain terrain) {
	        return dao_Ter.save(terrain);
	    }

	    @DeleteMapping("/terrains/{id}")
	    public void deleteTerrain(@PathVariable Integer id) {
	        dao_Ter.deleteById(id);
	    }

	    //  Adherant 

	    @GetMapping("/adherants")
	    public List<Adherant> getAllAdherants() {
	        return dao_add.findAll();
	    }

	    @PostMapping("/adherants")
	    public Adherant addAdherant(@RequestBody Adherant adherant) {
	        return dao_add.save(adherant);
	    }

	    @DeleteMapping("/adherants/{id}")
	    public void deleteAdherant(@PathVariable Integer id) {
	        dao_add.deleteById(id);
	    }

	    // Reservation

	    @GetMapping("/reservations")
	    public List<Reservation> getAllReservations() {
	        return dao_Rev.findAll();
	    }

	    @PostMapping("/reservations")
	    public Reservation addReservation(@RequestBody Reservation reservation) {
	        return dao_Rev.save(reservation);
	    }

	    @DeleteMapping("/reservations/{id}")
	    public void deleteReservation(@PathVariable Integer id) {
	        dao_Rev.deleteById(id);
	    }
	
	
	

}
