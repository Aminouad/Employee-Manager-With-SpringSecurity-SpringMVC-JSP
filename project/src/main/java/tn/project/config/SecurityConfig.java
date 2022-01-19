package tn.project.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	// add a reference to our security data source 
	
		@Autowired
		private DataSource securityDataSource;
		
		
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			// use jdbc authentication
			
			auth.jdbcAuthentication().dataSource(securityDataSource);
	         
		
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			    //.anyRequest().authenticated() it's for all so we can't use it to restrict access
	     .antMatchers("/").hasRole("EMPLOYEE")
	     .antMatchers("/FormAjoutEquipe/**").hasRole("EMPLOYEE")
	     .antMatchers("/Employe/**").hasRole("EMPLOYEE")
	     .antMatchers("/Taches/**").hasRole("EMPLOYEE")
	     .antMatchers("/Projets/**").hasRole("EMPLOYEE")
	     .antMatchers("/Conge/**").hasRole("EMPLOYEE")
	     .antMatchers("/FormAjoutEmploye/**").hasRole("EMPLOYEE")
	     .antMatchers("/FormAjoutTache/**").hasRole("EMPLOYEE")
	     .antMatchers("/FormAjoutProjet/**").hasRole("EMPLOYEE")
	     .antMatchers("/FormAjoutConge/**").hasRole("EMPLOYEE")

	     .antMatchers("/gestion/**").hasRole("ADMIN")
		.and()
		.formLogin()
		.loginPage("/showMyLoginPage")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied")
		;
				
		}

		
}
