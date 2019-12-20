package co.simplon;

import co.simplon.dao.TaskRepository;
import co.simplon.entities.AppRole;
import co.simplon.entities.AppUser;
import co.simplon.entities.Task;


import co.simplon.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.stream.Stream;

@SpringBootApplication
public class JwtsecuriteApplication implements CommandLineRunner {
     @Autowired
	private TaskRepository taskRepository;
     @Autowired
    private AccountService accountService;

	public static void main(String[] args) {

		SpringApplication.run(JwtsecuriteApplication.class, args);
	}
/*
    @Bean
	public BCryptPasswordEncoder getBCPE(){

		return new BCryptPasswordEncoder();
	}
*/
	@Override
	public void run(String... args) throws Exception {
		accountService.saveUser(new AppUser(null,"admin","1234",null));
		accountService.saveUser(new AppUser(null,"user","1234",null));
		accountService.saveRole(new AppRole(null,"ADMIN"));
		accountService.saveRole(new AppRole(null,"USER"));
		accountService.addRoleToUse("admin","ADMIN");


		Stream.of("maison-du-monde", "ikea", "boulanger").forEach(t->{
			taskRepository.save(new Task(null, t));
		});
		taskRepository.findAll().forEach(t->{
			System.out.println(t.getTaskName());
		});

	}
}
