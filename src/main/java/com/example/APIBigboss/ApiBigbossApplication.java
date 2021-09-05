package com.example.APIBigboss;

import com.example.APIBigboss.models.Role;
import com.example.APIBigboss.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableSwagger2
public class ApiBigbossApplication implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;
	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
	public static void main(String[] args) {
		SpringApplication.run(ApiBigbossApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		Role adminRole = new Role();
		adminRole.setRoleID(1);
		adminRole.setRoleName("ROLE_ADMIN");

		Role managerRole = new Role();
		managerRole.setRoleID(2);
		managerRole.setRoleName("ROLE_MANAGER");

		Role userRole = new Role();
		userRole.setRoleID(3);
		userRole.setRoleName("ROLE_USER");

		roleRepository.saveAll(Arrays.asList(adminRole, managerRole, userRole));
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("*");
			}
		};
	}

}
