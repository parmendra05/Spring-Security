package com.pack.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
@Id
private int id;
private String userName;
private String password;

public Users() {
	// TODO Auto-generated constructor stub
}

public Users(int id, String userName, String password) {
	this.id = id;
	this.userName = userName;
	this.password = password;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}


}
