package Servlets;

import Logica.ControladoraLogica;
import Logica.PaqueteTuristico;
import Logica.ServicioTuristico;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvAgregarPaqueteAVenta", urlPatterns = {"/SvAgregarPaqueteAVenta"})
public class SvAgregarPaqueteAVenta extends HttpServlet {

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
	
	int id = Integer.parseInt(request.getParameter("paqueteId"));
	PaqueteTuristico paqueteParaVenta = controladoraLogica.buscarPaqueteTuristico(id);
	request.getSession().removeAttribute("eleccionParaVenta");
	request.getSession().setAttribute("eleccionParaVenta", paqueteParaVenta);
	String tipoEleccion = "paquete";
	request.getSession().removeAttribute("tipoEleccion");
	request.getSession().setAttribute("tipoEleccion", tipoEleccion);
	request.getSession().removeAttribute("eleccion");
	request.getSession().setAttribute("eleccion", paqueteParaVenta.getCod_paquete());
	
	response.sendRedirect("altaVenta.jsp");
    }

    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}