package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.nt.bo.StateBO;

public class StateDAOImpl implements StateDAO {

	private DataSource ds;

	public StateDAOImpl(DataSource ds) {
		
		this.ds = ds;
	}

	public List<StateBO> getStateInfoByName(String cond) throws Exception {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<StateBO> listBO = null;
		StateBO bo = null;
		
		try {
			//get Pooled JDBC Connection
			con = ds.getConnection();
			//create PreparedStatement object
			ps = con.prepareStatement("SELECT STATE_ID,STATE_NAME,STATE_CAPITAL,STATE_POPULATION,STATE_CM FROM STATES_INFO WHERE STATE_CAPITAL IN "+ cond);
			rs = ps.executeQuery();
			//copy ResultSet object records to List Collection
			listBO = new ArrayList();
			while(rs.next()) {
				//copy each record to BO class object
				bo = new StateBO();
				bo.setState_ID(rs.getInt(1));
				bo.setState_Name(rs.getString(2));
				bo.setState_Capital(rs.getString(3));
				bo.setState_Population(rs.getLong(4));
				bo.setState_CM(rs.getString(5));
				//add BO object to List<StateBO>
				listBO.add(bo);
			}
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			//close objects
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//finally
		return listBO;
	}//method
}//class