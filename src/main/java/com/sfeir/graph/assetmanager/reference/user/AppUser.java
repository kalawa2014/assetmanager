package com.sfeir.graph.assetmanager.reference.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Table(name = "users")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

	@Column(name = "name")
	private String name;

	@Id
	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "enabled")
	private boolean enabled = true;

	@Column(name = "lastlogin")
	private Date lastLogin;

	public AppUser(String name, String email, String password) {
		this.username = email;
		this.name = name;
		this.password = password;
	}

}
