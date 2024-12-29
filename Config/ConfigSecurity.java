package tn.essat.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Bean
	Filter Filter() {
		return new Filter();
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
		
		
		//http.authorizeRequests().antMatchers("/back/restaurants").permitAll();
    	http.cors().and().csrf().disable()
    	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    	http.authorizeRequests().antMatchers("/auth/**","/back/addCommande/**","/back/restaurants","/back/restaurant/**","/back/menu**/**","/back/itemMenu/**","/back/addMenu").permitAll();
    	http.authorizeRequests().anyRequest().authenticated();
    	http.addFilterBefore(Filter(), UsernamePasswordAuthenticationFilter.class);
	}
}
