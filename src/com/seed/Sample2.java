package com.seed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Sample2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try{
			Class.forName("oracle.jdbc.OracleDriver");
			
			//create connection
				 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.10:1521:orcl", "fsda28_5", "fsda28_5");
				 Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//				 ResultSet rs=st.executeQuery("select word, meaning from dictonary");
//				 String[] words = new String[100];
//				 String[] meanings = new String[100];
//
//				 while(rs.next()){
////					 words[0]=rs.getString(1);
//					 System.out.println(rs.getString(1)+" "+rs.getString(2));
//				 }
//				 System.out.println(words);
//				 System.out.println(meanigs);
				 String word = "HTML";		
				 
				
				 
				 String query = "SELECT meaning FROM dictonary WHERE word = ?";
				 PreparedStatement preparedStatement = con.prepareStatement(query);
		            preparedStatement.setString(1, word);
		            ResultSet rs1 = preparedStatement.executeQuery();
				 while(rs1.next()){
					 System.out.println("meaning of your word is " + rs1.getString(1));
				 }
				 con.close();
				
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
