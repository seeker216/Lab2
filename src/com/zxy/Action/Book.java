package com.zxy.Action;

import java.sql.Date;

public class Book {
	private int ISBN;
	private String title;
	private int authorID;
	private String publisher;
	private Date publishDate;
	private double price;

	public int getISBN() {
		return this.ISBN;
	}

	public void setISBN(int ISBN) {
		this.ISBN = ISBN;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAuthorID() {
		return this.authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
