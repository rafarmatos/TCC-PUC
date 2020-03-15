package br.mg.puc.minas.sica.exception;

public class AuthorizationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2240367410537169887L;
	
	
	private String key;
	
	
	private String message;
	
	public AuthorizationException(String key) {
		super(key);
		setKey(key);
	}
	
	
	public AuthorizationException(String key, String message) {
		super(key);
		setKey(key);
		setMessage(message);
	}
	
	public AuthorizationException(String key, String message, Throwable throwable) {
	    super(message, throwable);
		setKey(key);
		setMessage(message);
	
	}


	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}


	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}


	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
