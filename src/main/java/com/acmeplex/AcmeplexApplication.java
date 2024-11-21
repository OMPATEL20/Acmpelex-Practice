package com.acmeplex;

import javax.swing.SwingUtilities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.acmeplex.view.LoginForm;

@SpringBootApplication
public class AcmeplexApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcmeplexApplication.class, args);
		// javax.swing.SwingUtilities.invokeLater(() -> new LoginForm());
		
	}

}
