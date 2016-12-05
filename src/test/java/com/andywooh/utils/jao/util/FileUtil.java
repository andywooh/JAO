package com.andywooh.utils.jao.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class FileUtil {
	private static File file;

	public static String getFileAsString(String qualifiedFileName) {
		file = new File(qualifiedFileName);
		InputStream is = null;
		StringBuilder sb = new StringBuilder();
		try {
			is = new FileInputStream(file);
			byte[] b = new byte[1024];
			String strTmp = null;
			while ((is.read(b)) != -1) {
				strTmp = new String(b);
				sb.append(strTmp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
}
