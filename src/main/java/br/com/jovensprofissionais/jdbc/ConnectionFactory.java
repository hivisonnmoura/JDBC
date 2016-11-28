package br.com.jovensprofissionais.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConnection(){
		//String connectionUrl = "jdbc:mysql://localhost";
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/studyjava?autoReconnect=true&useSSL=false","root", "1q2w3e4r");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
