package com.service.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.model.Admin;
import com.util.DBConnectUtil;

public class AdminServiceImpl implements IAdminService{
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IAdminService.class.getName());
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static boolean isSuccess;
	
	private static AdminServiceImpl instance;
	
	// private constructor
	private AdminServiceImpl() {}
 
	//get instance method for getting the instance of the class
    public static AdminServiceImpl getInstance() {
        if (instance==null)
        	instance = new AdminServiceImpl();
        return instance;
    }
	
	
	public boolean validateLogin(String email, String pass) {
		try {
			con = DBConnectUtil.getConnection();
			stmt = con.createStatement();
			String sql = "select * from Admin where email='"+email+"' and password='"+pass+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
    	}
		
		return isSuccess;
	}

	public Admin getAdminDetails(String iEmail) {
		try {
			con = DBConnectUtil.getConnection();
			stmt = con.createStatement();
			String sql = "select * from Admin where email='"+iEmail+"';";
			rs = stmt.executeQuery(sql);
			rs.next();
			
			int adminId = rs.getInt(1);
			String firstName = rs.getString(2);
			String lastName = rs.getString(3);
			String email = rs.getString(4);
			String password = rs.getString(5);
			String phoneNumber = rs.getString(6);
			String createdAt = rs.getString(7);
			String updatedAt = rs.getString(8);
			
			Admin admin = new Admin(adminId, firstName, lastName, email, password, phoneNumber, createdAt, updatedAt);
			
			return admin;
			
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
    	}
		return null;
	}

}