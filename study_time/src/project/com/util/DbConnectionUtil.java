package project.com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionUtil {
	// 1load driver one time
	private final static String DRIVER_CLASS_NAME = "oracle.jdbc.driver.OracleDriver";
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final static String USER = "system";
	private final static String PASSWORD = "Ig32mind$";

	private static boolean isDriverLoad=false; 
	static {
			try {
				Class.forName(DRIVER_CLASS_NAME);
				System.out.println("driver loaded............");
				isDriverLoad = true;
			} catch (ClassNotFoundException e) {
				System.out.println("Driver Class Must be Load");
				System.exit(0);
			}
	}//End static block

	public static Connection getConnection() throws SQLException {
		Connection con = null;
		if(isDriverLoad){
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		}
		return con;
	}//method

	public static void closeConnection(Connection con) throws SQLException {
       if(con!=null) {
    	   con.close();
       }
	}//method

}//ebd class

