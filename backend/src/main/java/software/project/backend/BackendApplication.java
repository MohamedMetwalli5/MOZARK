package software.project.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import software.project.backend.Database.UserDAO;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	 @Override
	    public void run(String... args) throws Exception {
	       UserDAO ui = new UserDAO(jdbcTemplate) ;
           software.project.backend.Model.User uur = ui.getUserByUserName("omarrehan0020");
           System.out.println(uur.getFirstName() + uur.getLastName());
	         
	    }

}
