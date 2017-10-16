package com.zxy.Action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class booklistAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception, SQLException {

		visitDatabase db = new visitDatabase();
		db.visitDatabase();
		Connection connect = db.connect;
		Statement stmt = connect.createStatement();
		String sql = "select * from book";
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<Book> booklist = new ArrayList<Book>();
		while (rs.next()) {
			Book b = new Book();
			b.setISBN(rs.getInt(1));
			b.setTitle(rs.getString(2));
			b.setAuthorID(rs.getInt(3));
			b.setPublisher(rs.getString(4));
			b.setPublishDate(rs.getDate(5));
			b.setPrice(rs.getDouble(6));
			booklist.add(b);
		}
		ActionContext.getContext().put("booklist", booklist);
		return "success";
	}

}
