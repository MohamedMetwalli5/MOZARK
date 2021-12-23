package software.project.backend.Database;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import software.project.backend.Model.Product;
import software.project.backend.Model.User;
import software.project.backend.Model.UserMapper;

public class ProductDAO {


	private final String SQL_INSERT_PRODUCT = "INSERT INTO PRODUCT (categoryName,name,description,price,quantity,discount,image) VALUES (?,?,?,?,?,?,?)";
	private final String SQL_UPDATE_PRODUCT = "UPDATE PRODUCT SET name=?, description=?, price=?, discount=? WHERE productId=?";
	 private JdbcTemplate jdbcTemplate;
	 
	 public ProductDAO() {
		 this.jdbcTemplate = new JdbcTemplate(dataSource()) ;
	 }
	 
	 @Bean
	 @Primary
	 public static DataSource dataSource() {
		 return DataSourceBuilder
				 .create()
				 .username("sql4460814")
				 .password("Ruwqt9etyE")
				 .url("jdbc:mysql://sql4.freemysqlhosting.net:3306/sql4460814")
				 .driverClassName("com.mysql.cj.jdbc.Driver")
				 .build();
	 }
	
	public boolean insertProduct(Product p) {
	     
	        int result = jdbcTemplate.update(SQL_INSERT_PRODUCT,p.getCategoryName(),p.getName(), p.getDescription(), p.getPrice() ,p.getQuantity(),p.getDiscount(),null);
	         
	        if (result > 0) {
	            System.out.println("A new row has been inserted.");
	            return true ;
		        }
	        return false ;
		}
	
	public boolean updateProduct(Product p) {
	     
        int result = jdbcTemplate.update(SQL_UPDATE_PRODUCT,p.getName(), p.getDescription(), p.getPrice() ,p.getDiscount(),p.getProductId());
        if (result > 0) {
            System.out.println("A new row has been updated.");
            return true ;
	        }
        return false ;
	}

	
	
	
	
	
	
	
	

}
