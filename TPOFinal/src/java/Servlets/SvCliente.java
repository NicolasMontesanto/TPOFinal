package Servlets;

import Logica.ControladoraLogica;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvCliente", urlPatterns = {"/SvCliente"})
public class SvCliente extends HttpServlet {

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
	String nombre = request.getParameter("nombre");
	String apellido = request.getParameter("apellido");
	String direccion = request.getParameter("direccion");
	String dni = request.getParameter("dni");
	String fecha_nac = request.getParameter("fecha_nac");
	String nacionalidad = request.getParameter("nacionalidad");
	String celular = request.getParameter("celular");
	String email = request.getParameter("email");
	
	controladoraLogica.altaCliente(nombre, apellido, direccion, dni, fecha_nac, nacionalidad, celular, email);
	response.sendRedirect("altaCliente.jsp");

    }

    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
