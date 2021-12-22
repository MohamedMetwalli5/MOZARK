package Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class User {
	
	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	
	public boolean addNewUser() {
		
	 String sql = "INSERT INTO user (userId,userName,password,firstName,lastName,Address,Phone,photo) VALUES (?,?,?,?,?,?,?,?)";
     
        int result = jdbcTemplate.update(sql, 1211,"omarrehan","123456789","omar","rehan" ,"fowa","01020619238",null);
         
        if (result > 0) {
            System.out.println("A new row has been inserted.");
	        }
		return true ;
	}

}
