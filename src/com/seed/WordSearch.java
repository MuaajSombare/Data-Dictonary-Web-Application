package com.seed;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WordSearch
 */
@WebServlet("/WordSearch")
public class WordSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String word = request.getParameter("dsearch");
		String result = "";
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			
			//create connection
				 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.10:1521:orcl", "fsda28_5", "fsda28_5");
				 Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				 ResultSet rs=st.executeQuery("select word, meaning from dictonary");

				 
				 TreeSet<String>words = new TreeSet<>();
				 TreeSet<String>meanigs = new TreeSet<>();
				 while(rs.next()){
					 words.add(rs.getString(1));
					 meanigs.add(rs.getString(2));
//					 System.out.println(rs.getString(1)+" "+rs.getString(2));
				 }
				 
				 
				 if(words.contains(word)) {
//					 System.out.println(word);
					 String query = "SELECT meaning FROM dictonary WHERE word = ?";
					 PreparedStatement preparedStatement = con.prepareStatement(query);
			            preparedStatement.setString(1, word);
			            ResultSet rs1 = preparedStatement.executeQuery();
					 while(rs1.next()){
						 request.setAttribute("msg",rs1.getString(1));
					 }
					 	 
				 }
					 
				 else{
//					 System.out.println("not presetnt");
					 request.setAttribute("msg", "word is not find");
				 } 
					 
				 

				 request.getRequestDispatcher("SearchWord.jsp").forward(request, response);
				 
				 
				 con.close();	 
		}
		catch(Exception e){
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
