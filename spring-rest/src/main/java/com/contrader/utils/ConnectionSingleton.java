package com.contrader.utils;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.sql.Connection;


public class ConnectionSingleton {


  private static Connection connection = null;


  private ConnectionSingleton() {
  }


  public static Connection getInstance() {
      if (connection == null) {
          try {
              String vendor="mysql";
              String driver="com.mysql.jdbc.Driver";
              String host="localhost";
              String port="3306";
              String dbName="roser_spring";
              String username="root";
              String password ="root";
              @SuppressWarnings("rawtypes")
			Class c = Class.forName(driver);
              System.out.println("Ho caricato: " + c.getName());
              String myUrl = "jdbc:" + vendor + "://" + host + ":" + port + "/" + dbName;
              DriverManagerDataSource dataSource = new DriverManagerDataSource(myUrl, username, password);
              dataSource.setDriverClassName(driver);
              connection = dataSource.getConnection();
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
      return connection;
  }

}
