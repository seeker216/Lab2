package com.zxy.Action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.opensymphony.xwork2.ActionSupport;

public class addAuthorAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer age, authorID;
	private String country, name;

	public String execute() throws Exception {
		visitDatabase db = new visitDatabase();
		db.visitDatabase();
		Connection connect = db.connect;
		String sqlName = "update author set name='" + name + "' where authorID=" + authorID;
		String sqlAge = "update author set age='" + age + "' where authorID=" + authorID;
		String sqlCountry = "update author set country='" + country + "' where authorID=" + authorID;
		PreparedStatement pst = connect.prepareStatement(sqlName);
		pst.executeUpdate();
		pst = connect.prepareStatement(sqlAge);
		pst.executeUpdate();
		pst = connect.prepareStatement(sqlCountry);
		pst.executeUpdate();
		return SUCCESS;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAuthorID(Integer authorID) {
		this.authorID = authorID;
	}

	public Integer getAuthorID() {
		return this.authorID;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return this.country;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
