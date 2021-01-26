package main_project;

public class staff {
	private int id;
	private String username,password,address,position,status;
	public staff(int id, String username, String address, String position, String status) {
		super();
		this.id = id;
		this.username = username;
		this.address = address;
		this.position = position;
		this.status = status;
	}
	
	public staff(int id, String username, String password, String address, String position, String status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.address = address;
		this.position = position;
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "staff [id=" + id + ", username=" + username + ", address=" + address + ", position=" + position
				+ ", status=" + status + "]";
	}
	
	
	
}
	
