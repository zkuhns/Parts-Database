import java.sql.*;

public class Database {
	private String databaseUrl;
	private String databaseName;
	private String username;
	private String password;
	private Connection connection;
	
	public Database(String databaseUrl, String databaseName, String username, String password) {
		this.databaseUrl = databaseUrl;
		this.databaseName = databaseName;
		this.username = username;
		this.password = password;
	}
	
	public void selectDatabase() {
		try {
			connection = DriverManager.getConnection(databaseUrl + databaseName, username, password);
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	
	public void createDatabase() {
		try {
			connection = DriverManager.getConnection(databaseUrl, username, password);
			Statement statement = connection.createStatement();
			String sql = "CREATE DATABASE " + databaseName;
			statement.executeUpdate(sql);
			connection.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	
	public void dropDatabase() {
		try {
			connection = DriverManager.getConnection(databaseUrl, username, password);
			Statement statement = connection.createStatement();
			String sql = "DROP DATABASE " + databaseName;
			statement.executeUpdate(sql);
			connection.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	
	public void createTable(String tableName, String tableColumns) {
		try {
			connection = DriverManager.getConnection(databaseUrl + databaseName, username, password);
			Statement statement = connection.createStatement();
			String sql = "CREATE TABLE " + tableName + "(" + tableColumns + ")";
			statement.executeUpdate(sql);
			connection.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	
	public void dropTable(String tableName) {
		try {
			connection = DriverManager.getConnection(databaseUrl + databaseName, username, password);
			Statement statement = connection.createStatement();
			String sql = "DROP TABLE " + tableName;
			statement.executeUpdate(sql);
			connection.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	
	public ResultSet selectRecords(String tableName, String recordColumns) {
		try {
			connection = DriverManager.getConnection(databaseUrl + databaseName, username, password);
			Statement statement = connection.createStatement();
			String sql = "SELECT " + recordColumns + " FROM " + tableName;
			ResultSet result = statement.executeQuery(sql);
			connection.close();
			return result;
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}
	
	public void insertRecord(String tableName, String recordColumns) {
		try {
			connection = DriverManager.getConnection(databaseUrl + databaseName, username, password);
			Statement statement = connection.createStatement();
			String sql = "INSERT INTO " + tableName + " VALUES (" + recordColumns + ")";
			statement.executeUpdate(sql);
			connection.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	
	public void deleteRecords(String tableName, String conditional) {
		try {
			connection = DriverManager.getConnection(databaseUrl + databaseName, username, password);
			Statement statement = connection.createStatement();
			String sql = "DELETE FROM " + tableName + " WHERE " + conditional;
			statement.executeUpdate(sql);
			connection.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	
	public void updateRecord(String tableName, String newValue, String conditional) {
		try {
			connection = DriverManager.getConnection(databaseUrl + databaseName, username, password);
			Statement statement = connection.createStatement();
			String sql = "UPDATE " + tableName + " SET " + newValue + " WHERE " + conditional;
			statement.executeUpdate(sql);
			connection.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
}
