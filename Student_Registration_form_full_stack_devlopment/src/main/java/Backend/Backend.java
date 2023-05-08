package Backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Backend")
public class Backend extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String id = req.getParameter("id");
		String sname = req.getParameter("sname");
		String pno = req.getParameter("pno");
		String email = req.getParameter("email");
		String dob = req.getParameter("dob");
		String gen = req.getParameter("g");
		String address = req.getParameter("address");
		String aadhar = req.getParameter("aadhar");
		String quali = req.getParameter("quali");
		String marks = req.getParameter("marks");
		String pwd = req.getParameter("pwd");
		
		
		out.println("<html>\r\n"
				+ "  <head>\r\n"
				+ "      <title> Prices </title>\r\n"
				+ "	  <style>\r\n"
				+ "	  table,th,td {border-width:2px;\r\n"
				+ "	      border-style:solid;\r\n"
				+ "		  padding:10px;\r\n"
				+ "		  color:red;\r\n"
				+ "		  text-align:center}\r\n"
				+ "	  body{\r\n"
				+ "          background-repeat:no-repeat;\r\n"
				+ "          background-size:100% 100%;\r\n"
				+ "          background-attachment:fixed;}\r\n"
				+ "	  </style>\r\n"
				+ "  </head>"
				+ "<body>"
				+ "<div width=\"50%\" height=\"309px\">\r\n"
				+ "     <table width=\"674px\" height=\"309px\">\r\n"
				+ "	 <thead>\r\n"
				+ "	     <tr>\r\n"
				+ "	        <th>Student Id</th>\r\n"
				+ "	        <th>Name</th>\r\n"
				+ "	        <th>Phone no</th>\r\n"
				+ "			<th>Email id</th>\r\n"
				+ "	        <th>DOB</th>\r\n"
				+ "	        <th>Gender</th>\r\n"
				+ "	        <th>Address no</th>\r\n"
				+ "			<th>Aaadhar</th>\r\n"
				+ "	        <th>Qualification</th>\r\n"
				+ "	        <th>Marks</th>\r\n"
				+ "	        <th>Password</th>\r\n"
				+ "	     </tr>\r\n"
				+ "		 \r\n"
				+ "	 </thead>\r\n"
				+ "	 <tbody>\r\n"
				+ "	    <tr>\r\n"
				+ "		    <td>"+id+"</td>\r\n"
				+ "			<td>"+sname+"</td>\r\n"
				+ "			<td>"+pno+"</td>\r\n"
				+ "			<td>"+email+"</td>\r\n"
				+ "		    <td>"+dob+"</td>\r\n"
				+ "			<td>"+gen+"</td>\r\n"
				+ "			<td>"+address+"</td>\r\n"
				+ "			<td>"+aadhar+"</td>\r\n"
				+ "		    <td>"+quali+"</td>\r\n"
				+ "			<td>"+marks+"</td>\r\n"
				+ "			<td>"+pwd+"</td>\r\n"
				+ "		</tr>"
				+ "</table>"
				+ "</body>");
		
		
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    System.out.println("Driver Found Successfully..");
		    
		    String url = "jdbc:mysql://localhost:3306/college";
		    String username = "root";
		    String password = "root";
		    
		    Connection con;
		    
		    con = DriverManager.getConnection(url,username,password);
		    
		    System.out.println("Connected with Database Successfully...");
		    
		    String query = "insert into studentdetails values(?,?,?,?,?,?,?,?,?,?,?)";
		    
		    PreparedStatement ps = con.prepareStatement(query);
		    ps.setString(1, id);
		    ps.setString(2, sname);
		    ps.setString(3, pno);
		    ps.setString(4, email);
		    ps.setString(5, dob);
		    ps.setString(6, gen);
		    ps.setString(7, address);
		    ps.setString(8, aadhar);
		    ps.setString(9, quali);
		    ps.setString(10, marks);
		    ps.setString(11, pwd);
		    ps.execute();
		    
		    System.out.println("Data has been inserted Successfully...");
		    
		}catch(ClassNotFoundException e) {
			System.out.println("Unable to find the Driver class.");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
