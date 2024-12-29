package tn.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.essat.model.User;

public interface IUserDao extends JpaRepository<User, Integer> {
	public User findByUsername(String username);
}
