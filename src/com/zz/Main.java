package com.zz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;

public class Main {
	
	
	public static String printStruct(Invoice i)
	{
		String result;
		result = "Invoice number :";
		result += i.d.docnum + "\n";
		result += i.c.name + "\n";
		result += i.c.cf + "\n";
		result += i.c.piva + "\n";
		result += i.d.imp + "\n";
		result += i.d.vat + "\n";
		result += i.d.tot + "\n";

		return result;
	}
	
	public static void start(Connection c) {
		System.out.println("Select operation :");
		System.out.println("1. Show Clients");
		System.out.println("2. Add Client");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		if (choice == 1) 
			showAllClients(c);
		else
			addNewClient(c);
	}
	
	private static void addNewClient(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("INSERT ");
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			
			while (rs.next()) {
				for (int i = 2; i <= 4; i++) {
			        if (i > 2) 
			        	System.out.println(",  ");
			        String columnValue = rs.getString(i);
			        System.out.print(rsmd.getColumnName(i) + " : " + columnValue);
				}
				System.out.println("");
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getMessage());
			System.out.println("VendorError: " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {}
				stmt = null;
			}
		}
	}

	private static void showAllClients(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM clients;");
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			
			while (rs.next()) {
				for (int i = 2; i <= 4; i++) {
			        if (i > 2) 
			        	System.out.println(",  ");
			        String columnValue = rs.getString(i);
			        System.out.print(rsmd.getColumnName(i) + " : " + columnValue);
				}
				System.out.println("");
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getMessage());
			System.out.println("VendorError: " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {}
				stmt = null;
			}
		}
	}

	public static void main(String[] args) {
		/*		
		ApplicationContext context = new ClassPathXmlApplicationContext("FattConfig.xml");
		Invoice obj = (Invoice) context.getBean("invoiceBean");
		obj.getInvoice();	
		*/
		
		System.out.println("Connection Testing...");

		Connection conn1 = null;
		
		try {
			conn1 = DriverManager.getConnection("jdbc:mysql://localhost/fatturazione?" + "user=root&password=root1234");
			System.out.println("Connection Established!\n");
		} catch (SQLException e){
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getMessage());
			System.out.println("VendorError: " + e.getMessage());
		}
		
		start(conn1);
		
		
			System.out.println("\nConnection Closed!");
		}
	}
