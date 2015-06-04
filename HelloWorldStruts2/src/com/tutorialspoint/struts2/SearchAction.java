package com.tutorialspoint.struts2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport {

	private int population;
	private ArrayList<String> my_states;

	public String execute() {
		String ret = ERROR;
		Connection conn = null;

		try {
			String URL = "jdbc:mysql://localhost:3306/us_states";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "toor");
			String sql = "SELECT state,population FROM states WHERE population >= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, population);
			ResultSet rs = ps.executeQuery();
			my_states = new ArrayList<String>();

			if (!rs.next())
				ret = ERROR;
			do {
				String str = rs.getString(1) + " " +rs.getInt(2);
				my_states.add(str);
				ret = SUCCESS;
			} while (rs.next());

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

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public ArrayList<String> getMy_states() {
		return my_states;
	}

	public void setMy_states(ArrayList<String> my_states) {
		this.my_states = my_states;
	}
	
	
}
