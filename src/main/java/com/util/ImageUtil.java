package com.util;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Timestamp;

import jakarta.servlet.http.Part;

public class ImageUtil extends CommonUtil{
	
	private static String imageFolderPath = properties.getProperty(CommonConstants.IMAGES_UPLOAD_PATH);
	
	public static String uploadStudentProfilePic(Part pic) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String picName= "img"+timestamp.getTime()+".jpg";
		String uploadPath = imageFolderPath + CommonConstants.STUDENT_PROFILE_UPLOAD_PATH + picName; 
		try
		{
			FileOutputStream fos=new FileOutputStream(uploadPath);
			InputStream is=pic.getInputStream();
			
			byte[] data=new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return picName;
	}

	public static String uploadStaffProfilePic(Part pic) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String picName= "img"+timestamp.getTime()+".jpg";
		String uploadPath = imageFolderPath + CommonConstants.STAFF_PROFILE_UPLOAD_PATH + picName; 
		try
		{
			FileOutputStream fos=new FileOutputStream(uploadPath);
			InputStream is=pic.getInputStream();
			
			byte[] data=new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return picName;
	}
}
