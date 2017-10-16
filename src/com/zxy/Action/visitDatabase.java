package com.zxy.Action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class visitDatabase {
	public Connection connect;

	public void visitDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
//		 connect = DriverManager.getConnection(
//		 "jdbc:mysql://w.rdc.sae.sina.com.cn:3306/app_zxy1150310103?characterEncoding=utf-8",
//		 "k4n1nxw2kz",
//		 "k12k2l5km5ljlhik3kl2mxlh00i3jyzymk3mlhwi");
		connect = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bookDB?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root",
				"XUNmeng..");
		

	}

}
