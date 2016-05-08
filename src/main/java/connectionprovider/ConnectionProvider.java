package main.java.connectionprovider;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class ConnectionProvider {
	public static ConnectionProvider connectionProvider = null;
	private static Connection getConnection() throws URISyntaxException,
			SQLException {
		String dbUrl = System.getenv("JDBC_DATABASE_URL");
    	return DriverManager.getConnection(dbUrl);
	}

	public static void main(String[] args) {
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("INSERT INTO image(image) VALUES('My cool Item');");
			ResultSet rs = stmt.executeQuery("SELECT image FROM image");
			while (rs.next()) {
				System.out.println("image: " + rs.getString("image"));
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static ConnectionProvider getInstance() {
		if (connectionProvider == null) {
			connectionProvider = new ConnectionProvider();
		}
		return connectionProvider;
	}
	public void executeUpdateQuery(String query) throws SQLException,
			ClassNotFoundException {
		try {			
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		stmt.execute(query);
		con.close();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public String executeQuery(String query) throws ClassNotFoundException,
			SQLException {
		String listString = "";
		try {	
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			listString =listString+"\n"+rs.getString("id") + "\t"+rs.getString("image") + "\t";
		}
		con.close();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listString;
	}
}
