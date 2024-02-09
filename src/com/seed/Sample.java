package com.seed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Sample{
public static void main(String[] args) {
	
	
	try{
		Class.forName("oracle.jdbc.OracleDriver");
		
		//create connection
			 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.10:1521:orcl", "fsda28_5", "fsda28_5");
			 Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			 ResultSet rs=st.executeQuery("select word, meaning from dictonary");
			 TreeSet<String>words = new TreeSet<>();
			 TreeSet<String>meanigs = new TreeSet<>();
//			 ArrayList<String> words = new ArrayList<>();
//			 ArrayList<String> meanigs = new ArrayList<>();
			 while(rs.next()){
				 words.add(rs.getString(1));
				 meanigs.add(rs.getString(2));
//				 System.out.println(rs.getString(1)+" "+rs.getString(2));
			 }
//			 System.out.println(words);
//			 System.out.println(meanigs);
			 String word = "Java";
//			 int numb = Collections.binarySearch(words, word);
			 
//			 if(numb>0){
//				 System.out.println("word is available");	 
//			 }
//			 else{
//				 System.out.println("not available");
//			 }
			 
			 if(words.contains(word)) System.out.println(word);
			 else System.out.println("not presetnt");
			 
			 con.close();
//			
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
}
}
