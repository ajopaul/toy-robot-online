package com.ajopaul.ToyRobotOnline;


import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.boot.builder.SpringApplicationBuilder;
		import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ToyRobotOnlineApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ToyRobotOnlineApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ToyRobotOnlineApplication.class, args);
	}

}
