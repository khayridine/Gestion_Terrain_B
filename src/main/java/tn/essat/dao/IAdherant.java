package tn.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.essat.model.Adherant;

@Repository
public interface IAdherant extends JpaRepository<Adherant, Integer> {

}
