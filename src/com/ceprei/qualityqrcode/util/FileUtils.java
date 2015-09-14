package com.ceprei.qualityqrcode.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils {
	public static void inputstreamtofile(InputStream ins,File file){
		try{
			OutputStream os = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			ins.close();
		}catch(FileNotFoundException e1){}
		catch(IOException e2){}
	}
	
	public static void saveFile(InputStream ins,String filePath){
		try{
			File folder = new File(filePath.substring(0, filePath.lastIndexOf(File.separator)));
			if(!folder.exists() || !folder.isDirectory()){
				folder.mkdirs();
			}
			File file = new File(filePath);
			OutputStream os = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer = new byte[1024];
			while ((bytesRead = ins.read(buffer, 0, 1024)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			ins.close();
		}catch(FileNotFoundException e1){}
		catch(IOException e2){}
	}
}
