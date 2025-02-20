package mx.ine.rfe.siirfe.aplicaciones.vpva_vppp;

import java.sql.SQLException;

import javax.naming.NamingException;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class VpvaVpppApplication {
	

	

	public static void main(String[] args) throws BeansException, SQLException, NamingException {

		SpringApplication.run(VpvaVpppApplication.class, args);

	}

	
}
