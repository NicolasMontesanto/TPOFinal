package Servlets;

import Logica.ControladoraLogica;
import Logica.ServicioTuristico;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvAgregarServicioAVenta", urlPatterns = {"/SvAgregarServicioAVenta"})
public class SvAgregarServicioAVenta extends HttpServlet {

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
	ServicioTuristico servicioParaVenta = controladoraLogica.buscarServicioTuristico(id);
	request.getSession().removeAttribute("eleccionParaVenta");
	request.getSession().setAttribute("eleccionParaVenta", servicioParaVenta);
	String tipoEleccion = "servicio";
	request.getSession().removeAttribute("tipoEleccion");
	request.getSession().setAttribute("tipoEleccion", tipoEleccion);
	request.getSession().removeAttribute("eleccion");
	request.getSession().setAttribute("eleccion", servicioParaVenta.getCod_servicio());
	response.sendRedirect("altaVenta.jsp");
    }

    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
