package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class User implements Serializable {
	
	private int id;
	private String personalName;
	private String username;
	private String password;
	private String jobTitle;
	private String description;
	private String email;
	private String phone;
	private Address address;
	private List<Skill> profSkill;
	private List<Skill> personalSkill;


	public User() {}

	public User(String personalName, String username, String password) {
		this.personalName = personalName;
		this.username = username;
		this.password = password;
		jobTitle="Не е зададен";
		description="Не е зададено";
		email="Не е зададен";
		phone="Не е зададен";
		address = new Address();
		profSkill = new ArrayList<Skill>();
		personalSkill = new ArrayList<Skill>();
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getPersonalName() {
		return personalName;
	}

	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Skill> getProfSkill() {
		return profSkill;
	}

	public void setProfSkill(List<Skill> profSkill) {
		this.profSkill = profSkill;
	}

	public List<Skill> getPersonalSkill() {
		return personalSkill;
	}

	public void setPersonalSkill(List<Skill> personalSkill) {
		this.personalSkill = personalSkill;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
}
