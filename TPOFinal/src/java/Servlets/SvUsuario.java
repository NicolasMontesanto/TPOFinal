package Servlets;

import Logica.ControladoraLogica;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
public class SvUsuario extends HttpServlet {

    ControladoraLogica controladoraLogica = new ControladoraLogica();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String nombreUsuario = request.getParameter("nombreUsuario");
	String contrasenia = request.getParameter("contrasenia");
	boolean autorizado = controladoraLogica.verficarUsuario(nombreUsuario, contrasenia);
	if (autorizado){
	    HttpSession miSession = request.getSession(true);
	    miSession.setAttribute("usuario", nombreUsuario);
	    miSession.setAttribute(contrasenia, contrasenia);
	    
	    response.sendRedirect("index.jsp");
	    
	} else{
	    response.sendRedirect("login.jsp");
	}
    }

    
    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
