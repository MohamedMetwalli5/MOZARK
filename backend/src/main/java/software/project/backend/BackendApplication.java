package software.project.backend;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

<<<<<<< Updated upstream
import Database.UserDAO;
=======
import software.project.backend.Database.UserDAO;
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
           Model.User uur = ui.getUserByUserName("omarrehan0020");
=======
           software.project.backend.Model.User uur = ui.getUserByUserName("omarrehan0020");
>>>>>>> Stashed changes
           System.out.println(uur.getFirstName() + uur.getLastName());
	         
	    }

}
