package com.slp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tool {

//	*************************连接数据库*****************************
	public static Connection getConnect() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521/ORCL";
		String user = "SHLIPE";
		String pass = "root";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,user,pass);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

//  ****************获取当前时间(用于拼接在图片名后，以防止图片名字重复)*************
	public static String getDate() {
		return new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date());
	}
}
