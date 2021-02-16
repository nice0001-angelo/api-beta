package net.jin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan(basePackages = "net.jin.mapper")
@SpringBootApplication
public class ApiBetaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBetaApplication.class, args);
	}

}
