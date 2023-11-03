package com.service.admin;

import com.model.Admin;

public interface IAdminService {
	/**
	 * Validate Administrator Logins
	 * @param email
	 * @param password
	 * 
	 * @return boolean
	 */
	public boolean validateLogin(String email, String pass);

	/**
	 * Get Administrator details by email
	 * @param email
	 * 
	 * @return Administrator Object
	 */
	public Admin getAdminDetails(String email);

}



