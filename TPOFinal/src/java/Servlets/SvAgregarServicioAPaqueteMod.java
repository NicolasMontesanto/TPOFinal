package Servlets;

import Logica.ControladoraLogica;
import Logica.ServicioTuristico;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvAgregarServicioAPaqueteMod", urlPatterns = {"/SvAgregarServicioAPaqueteMod"})
public class SvAgregarServicioAPaqueteMod extends HttpServlet {

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
	int id = Integer.parseInt(request.getParameter("servicioId"));
	ServicioTuristico servicioTuristico = controladoraLogica.buscarServicioTuristico(id);
	List<ServicioTuristico> serviciosParaPaquete = (List) request.getSession().getAttribute("serviciosParaPaquete");
	serviciosParaPaquete.add(servicioTuristico);
	request.getSession().removeAttribute("serviciosParaPaquete");
	request.getSession().setAttribute("serviciosParaPaquete", serviciosParaPaquete);
	response.sendRedirect("modificarPaqueteTuristico.jsp");
	
	
    }

    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
