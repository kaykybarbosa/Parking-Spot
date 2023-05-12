package com.api.parkingcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.System.setOut;

//Developer: Kayky Barbosa
// 2023/05/07

@SpringBootApplication
@RestController
public class ParkingControlApplication {

	public static void main(String[] args) {

		SpringApplication.run(ParkingControlApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("seduc123"));
	}
}