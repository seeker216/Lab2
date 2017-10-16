package com.zxy.Action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class authorSearchAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public String execute() throws Exception {
		System.out.println("helloo:"+name);
		visitDatabase db = new visitDatabase();
		db.visitDatabase();
		Connection connect = db.connect;
		Statement stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery("select * from author where Name='" + name + "'");
		ActionContext.getContext().put("name", name);
		if (rs.next()) {
			String authorID = rs.getString(1);
			System.out.println(authorID);
			rs.close();
			rs = stmt.executeQuery("select * from book where AuthorID='" + authorID + "'");
			if (rs.next()) {
				ArrayList<Book> books = new ArrayList<Book>();
				do {
					Book b = new Book();
					b.setISBN(rs.getInt(1));
					b.setTitle(rs.getString(2));
					b.setAuthorID(rs.getInt(3));
					b.setPublisher(rs.getString(4));
					b.setPublishDate(rs.getDate(5));
					b.setPrice(rs.getDouble(6));
					books.add(b);
				} while (rs.next());
				ActionContext.getContext().put("books", books);
			} else {
				connect.close();
				return ERROR;
			}
			connect.close();
			return "success";
		} else {
			connect.close();
			return ERROR;
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
