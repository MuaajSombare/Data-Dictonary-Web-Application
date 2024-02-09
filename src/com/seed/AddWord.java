package com.seed;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddWord
 */
@WebServlet("/AddWord")
public class AddWord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String word =request.getParameter("dword");
		String meaning =request.getParameter("dmean");
		
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			
			//create connection
				 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.10:1521:orcl", "fsda28_5", "fsda28_5");
				
			//create statement object
				PreparedStatement st = con.prepareStatement("insert into dictonary values(?,?)");
				st.setString(1, word);
				st.setString(2, meaning);
				
				int i =st.executeUpdate();
				System.out.println("data inserted into registration table");
				if(i>0){
					response.getWriter().println("added successful....");
				}
		con.close();
				request.setAttribute("msg", "word added successful....");
				request.getRequestDispatcher("wordEnter.jsp").forward(request, response);
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
