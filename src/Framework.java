public class Framework {
	Database database;
	
	public void registerDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void connectDatabase(String databaseUrl, String databaseName, String username, String password) {
		database = new Database(databaseUrl, databaseName, username, password);
		database.createDatabase();
		database.selectDatabase();
		database.createTable("part_types",
				"name VARCHAR(255)");
		database.createTable("parts",
				"id INTEGER not NULL,"
				+ "type INTEGER not NULL,"
				+ "name VARCHAR(255),"
				+ "status INTEGER not NULL,"
				+ "physical_total INTEGER not NULL,"
				+ "net_total INTEGER not NULL");
		database.createTable("assemblies",
				"id INTEGER not NULL,"
				+ "type INTEGER not NULL,"
				+ "name VARCHAR(255),"
				+ "status INTEGER not NULL,"
				+ "physical_total INTEGER not NULL,"
				+ "net_total INTEGER not NULL");
	}
	
	public static void main(String[] args) {
		Framework framework = new Framework();
		framework.registerDriver();
		framework.connectDatabase(args[0], args[1], args[2], args[3]);
	}
}