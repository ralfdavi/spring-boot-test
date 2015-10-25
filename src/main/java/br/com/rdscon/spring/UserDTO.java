package br.com.rdscon.spring;

import java.util.List;

public class UserDTO {
	
	private String id;
	private String name;
	private String email;
	private List<PhoneDTO> phone;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<PhoneDTO> getPhone() {
		return phone;
	}
	public void setPhone(List<PhoneDTO> phone) {
		this.phone = phone;
	}
	
}