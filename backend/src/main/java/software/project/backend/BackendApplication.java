package software.project.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import software.project.backend.Database.ProductDAO;
import software.project.backend.Database.UserDAO;
import software.project.backend.Model.Product;
import software.project.backend.Model.User;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	 @Override
	    public void run(String... args) throws Exception {
	       ProductDAO ui = new ProductDAO(jdbcTemplate) ;
	       Product p = new Product();
	       p.setCategoryName("fruits");
	       p.setDescription("ggggggggggggggggg");
	       p.setImage(null);
	       p.setName("prosuct 100000000");
	       p.setPrice(2.0);
	       p.setQuantity(4);
	       p.setProductId(1);

	       boolean uur = ui.insertProduct(p);
            System.out.println(uur);
	         
	    }
	 
	

}
