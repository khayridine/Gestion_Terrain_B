package tn.essat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String date_res;
	private int heure_debut;
	private int heure_fin;
	@ManyToOne
	private Adherant user;
	@ManyToOne
	private Terrain ter;
	
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reservation(Integer id, String date_res, int heure_debut, int heure_fin, Adherant user, Terrain ter) {
		super();
		this.id = id;
		this.date_res = date_res;
		this.heure_debut = heure_debut;
		this.heure_fin = heure_fin;
		this.user = user;
		this.ter = ter;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDate_res() {
		return date_res;
	}
	public void setDate_res(String date_res) {
		this.date_res = date_res;
	}
	public int getHeure_debut() {
		return heure_debut;
	}
	public void setHeure_debut(int heure_debut) {
		this.heure_debut = heure_debut;
	}
	public int getHeure_fin() {
		return heure_fin;
	}
	public void setHeure_fin(int heure_fin) {
		this.heure_fin = heure_fin;
	}
	public Adherant getUser() {
		return user;
	}
	public void setUser(Adherant user) {
		this.user = user;
	}
	public Terrain getTer() {
		return ter;
	}
	public void setTer(Terrain ter) {
		this.ter = ter;
	}
	

}
