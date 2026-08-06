package com.clinic.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class HikariConnectionPool {
	private static final HikariDataSource dataSource;
	
	static {
		HikariConfig config=new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/health_clinic_db");
		config.setUsername("root");
		config.setPassword("prateek@2005");
		config.setMaximumPoolSize(10);
		config.setMinimumIdle(2);
		config.setIdleTimeout(30000);
		config.setConnectionTimeout(30000);
		dataSource=new HikariDataSource(config);
	}
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	public static void shutdown() {
		dataSource.close();
	}
}
