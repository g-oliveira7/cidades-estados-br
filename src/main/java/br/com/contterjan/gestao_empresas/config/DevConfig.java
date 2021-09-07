package br.com.contterjan.gestao_empresas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.contterjan.gestao_empresas.services.DBService;
import br.com.contterjan.gestao_empresas.services.DBService2;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	DBService dbServ;
	
	@Autowired
	DBService2 dbServ2;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	String strategy;
	
	@Bean
	public boolean instantiateDatebaseTeste() {
		
		if (strategy.equals("none")) {
			return false;
		}
		dbServ.instantiateDatebase();
		dbServ2.instantiateDatebase2();
		return true;
	}
}
