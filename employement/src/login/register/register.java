package login.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public register() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String FRN = request.getParameter("FName");
		String LSM = request.getParameter("LName");
		String CTC = request.getParameter("num");
		String UN = request.getParameter("USName");
		String PW = request.getParameter("passwo");
		String GN = request.getParameter("gender");
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
	           Connection con = null;
	           String conUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=Registration;integratedSecurity=true";
	           con = DriverManager.getConnection(conUrl);
	           

PreparedStatement ps=con.prepareStatement( "insert into dbo.register values(?,?,?,?,?,?)");
	           
ps.setString(1, FRN);
ps.setString(2, LSM);
ps.setString(3, UN);
ps.setString(6, CTC);
ps.setString(4, PW);
ps.setString(5, GN);

int i=ps.executeUpdate();  
if(i>0) {
	
	out.println("Sucessfully Registered " );
}

else {
	
	out.println("UNSucessful !!!! " );
}


		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
			
	}

}
