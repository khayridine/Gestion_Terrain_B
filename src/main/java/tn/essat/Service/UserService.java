package tn.essat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.essat.dao.IUserDao;
import tn.essat.model.User;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	IUserDao dao;

	@Bean
	private PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public User loadUserByUsername(String username) {
		return dao.findByUsername(username);
	}
	
	public String cryptage(String mp)
	{
		PasswordEncoder crypt=passwordEncoder();
		return crypt.encode(mp);
	}

}
