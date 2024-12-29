package tn.essat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.essat.Service.UserService;
import tn.essat.dao.IUserDao;
import tn.essat.Config.GestionToken;
import tn.essat.Config.JwtRequest;
import tn.essat.Config.JwtResponse;
import tn.essat.model.User;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "/auth")
public class RestAuth {

    @Autowired
    private GestionToken token_gen;

    @Autowired
    private UserService userService;
    
    @Autowired
    IUserDao dao_user;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/login")
    public JwtResponse signIn(@RequestBody JwtRequest request) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())  );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = userService.loadUserByUsername(request.getUsername());
        String token = token_gen.generateToken(user);
        JwtResponse response= new JwtResponse(token);
        
        return response;
    }
    
    
    
    @PostMapping(value="/inscription")
    public void inscripition_User(@RequestBody User u)
    
    {
    	
    	
    	String mp1=userService.cryptage(u.getPassword());
    	u.setPassword(mp1);
    	dao_user.save(u);
    	
    	
    	
    	
    }
}