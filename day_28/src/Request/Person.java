package Request;

import java.util.Arrays;

public class Person {
	private String user;
	private String username;
	private String sex;
	private String[] hobby;
	private String city;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Person [user=" + user + ", username=" + username + ", sex="
				+ sex + ", hobby=" + Arrays.toString(hobby) + ", city=" + city
				+ "]";	
	}
}
