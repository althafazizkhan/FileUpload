package file.insert;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/InsertFile")
public class InsertFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
		
    		try {
    		ServletFileUpload sf= new ServletFileUpload(new DiskFileItemFactory());
    		List<FileItem> FI = sf.parseRequest(request);
    		for(FileItem File : FI) {
    			
    			File.write(new File("C:/Users/altha/Desktop/" + File.getName()));
    		}
    		
    		out.println("Successfully Uploaded");
    		
    		}
    		
    		catch(Exception e) {
    			e.getStackTrace();
    		}
	}

}
