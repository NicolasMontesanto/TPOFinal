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

@WebServlet(name = "SvObtenerPaquetesYServiciosParaVenta", urlPatterns = {"/SvObtenerPaquetesYServiciosParaVenta"})
public class SvObtenerPaquetesYServiciosParaVenta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ControladoraLogica controladoraLogica = new ControladoraLogica();
	List<ServicioTuristico> listaServiciosTuristicos = controladoraLogica.obtenerServiciosTuristicos();
	List<PaqueteTuristico> listaPaquetesTuristicos = controladoraLogica.obtenerPaquetesTuristicos();
	request.getSession().removeAttribute("listaServiciosTuristicos");
	request.getSession().setAttribute("listaServiciosTuristicos", listaServiciosTuristicos);
	request.getSession().removeAttribute("listaPaquetesTuristicos");
	request.getSession().setAttribute("listaPaquetesTuristicos", listaPaquetesTuristicos);
	request.getSession().removeAttribute("eleccion");
	response.sendRedirect("altaVenta.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
