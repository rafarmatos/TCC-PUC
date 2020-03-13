package br.mg.puc.sica.security.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.oauth2.core.user.OAuth2User;


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
	private String jsessionid;
	
	protected User() {
		
	}
	
	public static User of (OAuth2User principal, String jsessionid) { 
		User user = new User ();
		user.setEmail((principal.getAttribute("email").toString()));
		user.setName(principal.getAttribute("name").toString());
		user.setPicture(principal.getAttribute("picture").toString());
		user.setJsessionid(jsessionid);
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
	 * @return the jsessionid
	 */
	public String getJsessionid() {
		return jsessionid;
	}

	/**
	 * @param jsessionid the jsessionid to set
	 */
	public void setJsessionid(String jsessionid) {
		this.jsessionid = jsessionid;
	}
	
	
}
