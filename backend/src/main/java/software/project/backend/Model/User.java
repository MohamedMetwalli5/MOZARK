package software.project.backend.Model;

public class User implements Imodel{
	private Long userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String Address;
	private String phone;
	
	public User()
	{
		
	}
	public User(long userId,String username, String firstName, String lastName ,String password , String phone, String address) {
		this.userId = userId ;
		this.userName = username ;
		this.firstName = firstName ;
		this.lastName = lastName ;
		this.password = password ;
		this.phone = phone ;
		this.Address = address ;
	}
	
	public Long getId() {
		return this.userId;
	}

	public void setId(Long id) {
		this.userId = id;
	}


	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String user) {
		this.userName = user;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}
	
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String p) {
		this.phone = p;
	}
	
	public String getAddress() {
		return this.Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}
	

	
	

}
