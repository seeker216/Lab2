package com.zxy.Action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class bookInfoAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ISBN;
	private Book theBook;
	private Author theAuthor;

	public String execute() throws Exception {
		visitDatabase db = new visitDatabase();
		db.visitDatabase();
		Connection connect = db.connect;
		Statement stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery("select * from book where ISBN='" + ISBN + "'");
		System.out.println("hello:" + ISBN);
		if (rs.next()) {
			String authorID = rs.getString(3);
			System.out.println(authorID);
			theBook = new Book();
			theBook.setISBN(rs.getInt(1));
			theBook.setTitle(rs.getString(2));
			theBook.setAuthorID(rs.getInt(3));
			theBook.setPublisher(rs.getString(4));
			theBook.setPublishDate(rs.getDate(5));
			theBook.setPrice(rs.getDouble(6));
			ActionContext.getContext().put("book", theBook);
			rs.close();
			rs = stmt.executeQuery("select * from author where AuthorID='" + authorID + "'");
			if (rs.next()) {
				theAuthor = new Author();
				theAuthor.setAuthorID(rs.getInt(1));
				theAuthor.setName(rs.getString(2));
				theAuthor.setAge(rs.getInt(3));
				theAuthor.setCountry(rs.getString(4));
				ActionContext.getContext().put("author", theAuthor);
				connect.close();
				return "success";
			} else {
				System.out.println("no author");
				connect.close();
				return "error";
			}
		} else {
			System.out.println("no book");
			connect.close();
			return "error";
		}
	}

	public void setName(String name) {
		this.ISBN = name;
	}

	public String getName() {
		return this.ISBN;
	}
}
