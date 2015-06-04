package com.tutorialspoint.struts2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport {
	private int id;
	private String state;
	private int population;

	public String execute() {
		String ret = ERROR;
		Connection conn = null;

		try {
			String URL = "jdbc:mysql://localhost/us_states";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "toor");
			String sql = "SELECT population FROM states WHERE state = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, state);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				id = rs.getInt(0);
				state = rs.getString(1);
				population = rs.getInt(3);
				ret = SUCCESS;
			}
		} catch (Exception e) {
			ret = ERROR;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		}
		return ret;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
}
