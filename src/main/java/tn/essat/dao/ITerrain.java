package tn.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.essat.model.Terrain;

@Repository

public interface ITerrain extends JpaRepository<Terrain, Integer> {

}
