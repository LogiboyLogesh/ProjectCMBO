package com.framework;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class ConnectDB{

	
	WriteOutput writeOut = new WriteOutput();

	// DB Connection Elements
	
		private static String DBURL =  "jdbc:postgresql://172.25.90.18:5432/indcmboqa?currentSchema=cmboqaschema";
		private static String DBUserName = "cmboqausr";// 
		private static String DBPassword = "Cmqa123";// 
		private static String databasetype="MYSQL";
		
		
		
		
		
		
	public void deleteSql(String sql) throws IOException {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(DBURL, DBUserName, DBPassword);
			Statement stmt = con.createStatement();
			stmt.execute(sql);
			stmt.close();
			con.close();
			System.out.println("Deleted successfully..");
			
		} catch (Exception e) {
			System.out.println(e);
			
		}
	}

	public void insertSql(String sql) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBURL, DBUserName, DBPassword);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static Map<String, String> selectsql(String tablename,String scenarioId) {
		Map<String,String> columnNameToValuesMap=new HashMap<String, String>();
		try {
			if(databasetype.equalsIgnoreCase("SQL"))
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			else if(databasetype.equalsIgnoreCase("ORACLE"))
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			Connection con = DriverManager.getConnection(DBURL, DBUserName, DBPassword);
			Statement stmt = con.createStatement();
			String sql="Select * from " + tablename + " where scenarioId='"+ scenarioId +"'";
			ResultSet rs = stmt.executeQuery(sql);
			 ResultSetMetaData rsmd = rs.getMetaData();
		     int columnCount = rsmd.getColumnCount();
		     List<String> columnNames = new LinkedList<>();		     
				for (int i = 1; i <= columnCount; i++) {
			        String columnName = rsmd.getColumnName(i);
			        columnNames.add(columnName);
			        //Load the Map initially with keys(columnnames) and empty list
			        columnNameToValuesMap.put(columnName, new String());
			 }
				 while (rs.next()) 
				 {
				for (String columnName : columnNames) {					
					
					 columnNameToValuesMap.put(columnName, rs.getString(columnName));
					 System.out.println("DATA value : " + columnName + "=" +  rs.getString(columnName));
				}	
		}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(columnNameToValuesMap);
		return columnNameToValuesMap;
	}
	
	public static Map<String, String> fetchrecordfromdatabase(String qry) {
		Map<String,String> columnNameToValuesMap=new HashMap<String, String>();
		try {	
			Class.forName("com.mysql.jdbc.Driver");	
			Connection con = DriverManager.getConnection(DBURL, DBUserName, DBPassword);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			ResultSetMetaData rsmd = rs.getMetaData();
		     int columnCount = rsmd.getColumnCount();
		     List<String> columnNames = new LinkedList<>();		     
				for (int i = 1; i <= columnCount; i++) {
			        String columnName = rsmd.getColumnLabel(i);
			        columnNames.add(columnName);
			        //Load the Map initially with keys(columnnames) and empty list
			        columnNameToValuesMap.put(columnName, new String());
			 }
				 while (rs.next()) 
				 {
				for (String columnName : columnNames) {
					 columnNameToValuesMap.put(columnName, rs.getString(columnName));
					 System.out.println("DATA value : " + columnName + "=" +  rs.getString(columnName));
				}	
		}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(columnNameToValuesMap);
		return columnNameToValuesMap;
	}
	
	public Connection databaseConnectionOpen() throws Exception {
		
		if (SystemProperties.get("databasetype").equals("ORACLE")) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(SystemProperties.get("SERVER").toString(), SystemProperties.get("SCHEMANAME").toString(),
					SystemProperties.get("SCHEMAPASSWORD").toString());
		} else if (SystemProperties.get("databasetype").equals("SQL")) {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// conn =
			// DriverManager.getConnection("jdbc:sqlserver://10.100.4.252\SQL2016:1435;databaseName=THAIBOACCESSQA",USER,PASS);
			return DriverManager.getConnection(SystemProperties.get("SERVER").toString(), SystemProperties.get("DBUserName").toString(),
					SystemProperties.get("SCHEMAPASSWORD").toString());
		} else if (SystemProperties.get("databasetype").equals("MYSQL")) {
			Class.forName("com.mysql.jdbc.Driver");
			// conn =
			// DriverManager.getConnection("jdbc:mysql://localhost/EMP",USER,PASS);
			return DriverManager.getConnection(SystemProperties.get("DBURL").toString(), SystemProperties.get("DBUserName").toString(),
					SystemProperties.get("DBPassword").toString());
		} else if (SystemProperties.get("databasetype").equals("POSTGRES")) {
			Class.forName("org.postgresql.Driver");
			// conn =
			// DriverManager.getConnection("jdbc:postgresql://localhost:5432/example",USER,PASS);
			return DriverManager.getConnection(SystemProperties.get("SERVER").toString(), SystemProperties.get("SCHEMANAME").toString(),
					SystemProperties.get("SCHEMAPASSWORD").toString());
		} else if (SystemProperties.get("databasetype").equals("MongoDB")) {
			Class.forName("mongodb.jdbc.MongoDriver");
			// conn =
			// DriverManager.getConnection("jdbc:mongo://<servername>:<port>/<databaseName>",USER,PASS);
			return DriverManager.getConnection(SystemProperties.get("SERVER").toString(), SystemProperties.get("SCHEMANAME").toString(),
					SystemProperties.get("SCHEMAPASSWORD").toString());
		}
		return null;

	}

	public void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public LinkedList<Map<String, String>> selectsql(String sql) {
		Connection con = null;
		LinkedList<Map<String, String>> resultsettomap = null;
		try {
			con = databaseConnectionOpen();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			resultsettomap = new LinkedList<Map<String, String>>();
			while (rs.next()) {
				int s = rs.getMetaData().getColumnCount();
				LinkedHashMap<String, String> row = new LinkedHashMap<String, String>();
				for (int i = 1; i <= s; i++) {
					if (rs.getObject(i) == null) {
						row.put(rs.getMetaData().getColumnName(i), "null");
					} else {
						row.put(rs.getMetaData().getColumnName(i), rs.getObject(i).toString());
					}
				}
				resultsettomap.add(row);
			}
			System.out.println(resultsettomap);
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			if (con != null) {
				closeConnection(con);
			}
			e.printStackTrace();
		}
		System.out.println(resultsettomap);
		return resultsettomap;
	}

}