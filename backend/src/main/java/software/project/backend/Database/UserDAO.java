package software.project.backend.Database;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import software.project.backend.Model.User;

public class UserDAO {


	private final String SQL_INSERT_USER = "INSERT INTO user (userName,password,firstName,lastName,Address,Phone) VALUES (?,?,?,?,?,?)";
	private final String SQL_SELECT_BY_USERNAME = "SELECT * FROM user WHERE userName=?";
	private final String SQL_SELECT_BY_USER_PASS = "SELECT * FROM user WHERE userName=? AND password=?";
	private final String SQL_GET_ALL = "select * from people";
	private final String SQL_INSERT_PERSON = "insert into people(id, first_name, last_name, age) values(?,?,?,?)";
	private final String SQL_FIND_USER = "select * from user where userName = ?";
	 private JdbcTemplate jdbcTemplate;
	 
	 public UserDAO(JdbcTemplate jdbcTemplate) {
		 this.jdbcTemplate = jdbcTemplate ;
	 }
	
	public boolean insertUser(User user) {
	     
	        int result = jdbcTemplate.update(SQL_INSERT_USER,user.getUserName(),user.getPassword(),user.getFirstName(),user.getLastName(),user.getAddress(),user.getPhone());
	         
	        if (result > 0) {
	            System.out.println("A new row has been inserted.");
	            return true ;
		        }
	        return false ;
		}
	
	public boolean findByUserName(User u) {
	    try {
	      User user = jdbcTemplate.queryForObject(SQL_SELECT_BY_USERNAME,
	          BeanPropertyRowMapper.newInstance(User.class), u.getUserName());
	      System.out.println(user.getUserId());
	      System.out.println(user.getUserName());
	      System.out.println(user.getPassword());
	      System.out.println(user.getFirstName());
	      System.out.println(user.getLastName());
	      System.out.println(user.getAddress());
	      System.out.println(user.getPhone());
	      return true;
	    } catch (IncorrectResultSizeDataAccessException e) {
	      return false;
	    }
	  }
	
	public int checkSignIn(User u) {
	    try {
	      User user = jdbcTemplate.queryForObject(SQL_SELECT_BY_USER_PASS,
	          BeanPropertyRowMapper.newInstance(User.class), u.getUserName() , u.getPassword());
	      System.out.println(user.getUserId());
	      System.out.println(user.getUserName());
	      System.out.println(user.getPassword());
	      System.out.println(user.getFirstName());
	      System.out.println(user.getLastName());
	      System.out.println(user.getAddress());
	      System.out.println(user.getPhone());
	      return user.getUserId();
	    } catch (IncorrectResultSizeDataAccessException e) {
	      return 0;
	    }
	  }
	
	
	
	
	
	
	
	

}
