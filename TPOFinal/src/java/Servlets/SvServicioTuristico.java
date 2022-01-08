package Servlets;

import Logica.ControladoraLogica;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvServicioTuristico", urlPatterns = {"/SvServicioTuristico"})
public class SvServicioTuristico extends HttpServlet {

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
	    String descripcion = request.getParameter("descripcion");
	    String destino = request.getParameter("destino");
	    String fecha = request.getParameter("fecha");
	    double costo = Double.parseDouble(request.getParameter("costo"));
	    controladoraLogica.altaServicioTuristico(nombre, descripcion, destino, fecha, costo);
	    response.sendRedirect("altaServicioTuristico.jsp");
    }


    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
