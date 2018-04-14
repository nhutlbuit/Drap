package servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendPdf extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	
      
      
          
     ServletOutputStream stream = null;
     BufferedInputStream buf = null;
     try{
     
     stream = response.getOutputStream( );
     File pdf = new File("C:/Users/training/Downloads/JSPServlet/WebContent/Servlet.pdf");
     
     //set response headers
     response.setContentType("application/pdf");
      
     response.addHeader(
        "Content-Disposition","attachment; filename=Servlet.pdf" );

     response.setContentLength( (int) pdf.length( ) );
      
     FileInputStream input = new FileInputStream(pdf);
     buf = new BufferedInputStream(input);
     int readBytes = 0;

     //read from the file; write to the ServletOutputStream
     while((readBytes = buf.read( )) != -1)
        stream.write(readBytes);

     } catch (IOException ioe){
     
        throw new ServletException(ioe.getMessage( ));
         
     } finally {
         
     //close the input/output streams
         if (stream != null)
             stream.close( );
          if (buf != null)
          buf.close( );
     }
    
    } //end doGet


  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    doGet(request, response);
  }
}