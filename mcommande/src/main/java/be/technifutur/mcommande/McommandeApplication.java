package be.technifutur.mcommande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class McommandeApplication {

	public static void main(String[] args) {
		SpringApplication.run(McommandeApplication.class, args);
	}

}
