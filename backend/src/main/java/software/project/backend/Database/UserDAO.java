package software.project.backend.Database;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import software.project.backend.Model.User;
import software.project.backend.Model.UserMapper;

public class UserDAO {


	private final String SQL_INSERT_USER = "INSERT INTO user (userName,password,firstName,lastName,Address,Phone) VALUES (?,?,?,?,?,?)";
	private final String SQL_DELETE_PERSON = "delete from people where id = ?";
	private final String SQL_UPDATE_PERSON = "update people set first_name = ?, last_name = ?, age  = ? where id = ?";
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
	
	public User getUserByUserName(String username) {
		return jdbcTemplate.queryForObject(SQL_FIND_USER, new Object[] { username }, new UserMapper());
	}
	
	public User findByUserName(String username) {
	    try {
	      User user = jdbcTemplate.queryForObject("SELECT * FROM user WHERE userName=?",
	          BeanPropertyRowMapper.newInstance(User.class), username);
	      System.out.println(user.getId());
	      System.out.println(user.getUserName());
	      System.out.println(user.getPassword());
	      System.out.println(user.getFirstName());
	      System.out.println(user.getLastName());
	      System.out.println(user.getAddress());
	      System.out.println(user.getPhone());
	      return user;
	    } catch (IncorrectResultSizeDataAccessException e) {
	      return null;
	    }
	  }
	
	
	
	
	
	

}
