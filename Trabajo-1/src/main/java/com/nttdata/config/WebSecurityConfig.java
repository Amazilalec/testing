package com.nttdata.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//analisar toda esta wea
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	//override sobre escribe el metodo
	@Autowired
	UserDetailsService usd;
	@Override
 	protected void configure(HttpSecurity http) throws Exception {
 		http.authorizeRequests()
 		.antMatchers("/usuarios/registrarjsp","/usuarios/registrar","/productos/listaproductos","/","/usuarios/login").permitAll()//css/**, js/** /registro, esto es a las duras que se les da permiso
 		//.hasRole("USER")
 		.anyRequest().authenticated() //esta linea te manda al login si se quiere acceder a cualquier pagina 
 		.and()
 		.formLogin()
 		.loginPage("/login").permitAll()
 		.usernameParameter("username")
 		.passwordParameter("password")
 		.and()
 		.logout().permitAll();
 		;//.loginPage(ruta) es para definir una pagina personal de login y no usar la de spring security // la pagina de login por default del spring security
 	}

	@Bean
	public BCryptPasswordEncoder bpasswordEncoder() {
	return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usd).passwordEncoder(bpasswordEncoder());
	}
}
