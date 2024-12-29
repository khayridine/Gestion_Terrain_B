package tn.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.essat.model.Reservation;



@Repository

public interface IReservation extends JpaRepository<Reservation, Integer> {

}
