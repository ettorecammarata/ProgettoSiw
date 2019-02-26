package servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout extends HttpServlet {
 private static final long serialVersionUID = 1L;


 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 //System.out.println("Cidddddddddddado");

	 String logout = request.getParameter("logout");
	// System.out.println("Ciado");

  response.getWriter().append("Served at: ").append(request.getContextPath());
 // if (logout.equals("true")) {
		//req.getSession().setAttribute("username", null);
//System.out.println("Ciao");
  request.getSession().invalidate();
  response.sendRedirect("index.html");}
 //}

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doGet(request, response);
 }

}