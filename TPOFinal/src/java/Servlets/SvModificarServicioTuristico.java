package Servlets;

import Logica.ControladoraLogica;
import Logica.Empleado;
import Logica.ServicioTuristico;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvModificarServicioTuristico", urlPatterns = {"/SvModificarServicioTuristico"})
public class SvModificarServicioTuristico extends HttpServlet {

    ControladoraLogica controladoraLogica = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
	ServicioTuristico servicioTuristico = controladoraLogica.buscarServicioTuristico(id);
	request.getSession().removeAttribute("servicioTuristico");
	request.getSession().setAttribute("servicioTuristico", servicioTuristico);
	response.sendRedirect("modificarServicioTuristico.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ServicioTuristico servicioTuristico = (ServicioTuristico) request.getSession().getAttribute("servicioTuristico");
	servicioTuristico.setNombre(request.getParameter("nombre"));
	servicioTuristico.setDescripcion(request.getParameter("descripcion"));
	servicioTuristico.setDestino_servicio(request.getParameter("destino"));
	servicioTuristico.setFecha_servicio(request.getParameter("fecha"));
	double costo = Double.parseDouble(request.getParameter("costo"));
	servicioTuristico.setCosto_servicio(costo);

	controladoraLogica.modificarServicioTuristico(servicioTuristico);
	request.getSession().removeAttribute("listaServiciosTuristicos");
	request.getSession().setAttribute("listaServiciosTuristicos", controladoraLogica.obtenerServiciosTuristicos());
	response.sendRedirect("obtenerServiciosTuristicos.jsp");

    }

    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
