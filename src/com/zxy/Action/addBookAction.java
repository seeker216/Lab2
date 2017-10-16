package com.zxy.Action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class addBookAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title, publisher, publishDate;
	private Integer ISBN, authorID;
	private double price;

	public String execute() throws Exception {

		visitDatabase db = new visitDatabase();
		db.visitDatabase();
		Connection connect = db.connect;
		Statement stmt = connect.createStatement();

		String sql = "insert into book(ISBN,Title,AuthorID,publisher,publishDate,price)values(" + ISBN + ",'" + title
				+ "'," + authorID + ",'" + publisher + "',{d'" + publishDate + "'}," + price + ")";
		ResultSet rs = stmt.executeQuery("select * from author where authorID='" + authorID + "'");
		if (rs.next()) {
			stmt.executeUpdate(sql);
			connect.close();
			return "success";
		} else {
			System.out.println("2");
			String sqlAuthor = "insert into author(authorID,name,age,country)values(" + authorID + ",'a',1,'b')";
			ActionContext.getContext().put("authorID", authorID);
			stmt.executeUpdate(sqlAuthor);
			stmt.executeUpdate(sql);
			connect.close();
			return "error";
		}
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setAuthorID(Integer authorID) {
		this.authorID = authorID;
	}

	public Integer getAuthorID() {
		return this.authorID;
	}

	public void setISBN(Integer ISBN) {
		this.ISBN = ISBN;
	}

	public Integer getISBN() {
		return this.ISBN;
	}

	public void setPublishDate(String date) {
		this.publishDate = date;
	}

	public String getPublishDate() {
		return this.publishDate;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return this.price;
	}
}
