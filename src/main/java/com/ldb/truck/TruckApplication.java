package com.ldb.truck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.DriverManager;
import java.sql.Connection;
@SpringBootApplication
public class TruckApplication {
	public static void main(String[] args) {
//		Connection connection = null;
////		spring.ebank.url=jdbc:mysql://localhost:3306/your_database_name
////		spring.ebank.username=sihomdb
////		spring.ebank.password=ojsGnsIL48bV2wEF
//		String url = "jdbc:mariadb://10.0.4.62:3306/sihomdb";
//		String user = "sihomdb";
//		String pwd = "ojsGnsIL48bV2wEF";
//		try{
//			connection = DriverManager.getConnection(url,user,pwd);
//		}catch (Exception e){e.printStackTrace();}
//
//		System.out.println("done connection");

		SpringApplication.run(TruckApplication.class, args);
	}

}
