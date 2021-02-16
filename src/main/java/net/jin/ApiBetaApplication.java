package net.jin;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;


@MapperScan(basePackages = "net.jin.mapper")
@SpringBootApplication
public class ApiBetaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBetaApplication.class, args);
	}

}
