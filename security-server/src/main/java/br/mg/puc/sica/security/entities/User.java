package br.mg.puc.sica.security.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.oauth2.provider.OAuth2Authentication;

@Entity
@Table(name = "user", schema="security")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4691892066212174511L;

	@Id
	@Column(name="id")
	private BigDecimal id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;
	
	@Column(name = "picture")
	private String picture;
	
	@Transient
	private String jsessionid;
	
	protected User() {
		
	}
	
	public static User of (Principal principal, String jsessionid) { 
		OAuth2Authentication oauth = (OAuth2Authentication) principal;
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> hashMap = (LinkedHashMap<String, Object>) oauth.getUserAuthentication().getDetails();
		User user = new User ();
		user.setId(new BigDecimal(hashMap.get("sub").toString()));
		user.setEmail(hashMap.get("email").toString());
		user.setName(hashMap.get("name").toString());
		user.setPicture(hashMap.get("picture").toString());
		user.setJsessionid(jsessionid);
		return user;
	}

	/**
	 * @return the id
	 */
	public BigDecimal getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BigDecimal id) {
		this.id = id;
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
