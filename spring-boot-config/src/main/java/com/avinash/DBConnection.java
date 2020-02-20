package com.avinash;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("db")
public class DBConnection {

	private String connection;
	private int port;
	private String password;
    private String username;
	public String getConnection() {
		return connection;
	}
	public int getPort() {
		return port;
	}
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}
	public void setConnection(String connection) {
		this.connection = connection;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
