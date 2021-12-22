package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User person = new User();
		person.setId(rs.getLong("userId"));
		person.setFirstName(rs.getString("firstName"));
		person.setLastName(rs.getString("lastName"));
		person.setUserName(rs.getString("userName"));
		person.setPassword(rs.getString("password"));
		person.setPhone(rs.getString("phone"));
		person.setAddress(rs.getString("Address"));
		return person;
	}
	
	

}
