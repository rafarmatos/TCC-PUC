package br.mg.puc.sica.security.server.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "user", schema="security")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4691892066212174511L;

	@Id
	@Column(name = "email")
	private String email;

	@Column(name = "name")
	private String name;
	
	@Column(name = "picture")
	private String picture;
	
	@Transient
	private String authorization;
	
	protected User() {
		
	}
	
	public static User of (String email, String name, String urlPicture, String jsessionid) { 
		User user = new User ();
		user.setEmail(email);
		user.setName(name);
		user.setPicture(urlPicture);
		user.setAuthorization(jsessionid);
		return user;
	}

	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * @param picture the picture to set
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	/**
	 * @return the authorization
	 */
	public String getAuthorization() {
		return authorization;
	}

	/**
	 * @param authorization the authorization to set
	 */
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}
	
}
