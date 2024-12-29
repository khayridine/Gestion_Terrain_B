package tn.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.essat.model.Administrateur;

@Repository

public interface IAdministrateur extends JpaRepository<Administrateur, Integer> {

}
