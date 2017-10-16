package com.zxy.Action;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.opensymphony.xwork2.ActionSupport;

public class deleteBookAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public String execute() throws Exception {
		visitDatabase db = new visitDatabase();
		db.visitDatabase();
		Connection connect = db.connect;
		PreparedStatement pst = connect.prepareStatement("delete from book where ISBN='" + name + "'");
		pst.executeUpdate();
		connect.close();
		return SUCCESS;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
