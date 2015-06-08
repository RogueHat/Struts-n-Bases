package com.tutorialspoint.struts2;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport {

	private int population;
	private List<State> my_states;

	public String execute() {
		String ret = ERROR;

		try {
			String location = "SqlMapConfig.xml";
			Reader rd = Resources.getResourceAsReader(location);
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			my_states = (List<State>) smc.queryForList("State.get", population);

			ret = SUCCESS;
			if (my_states.isEmpty()) {
				ret = "none";
			}
		} catch (Exception e) {
			ret = ERROR;
		}
		return ret;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public List<State> getMy_states() {
		return my_states;
	}

	public void setMy_states(List<State> my_states) {
		this.my_states = my_states;
	}
}
