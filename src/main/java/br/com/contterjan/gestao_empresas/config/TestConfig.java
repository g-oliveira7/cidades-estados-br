package br.com.contterjan.gestao_empresas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.contterjan.gestao_empresas.services.DBService;
import br.com.contterjan.gestao_empresas.services.DBService2;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	DBService dbServ;
	
	@Autowired
	DBService2 dbServ2;
	
	@Bean
	public void instantiateDatebaseTeste() {
		dbServ.instantiateDatebase();
		dbServ2.instantiateDatebase2();
	}
}
