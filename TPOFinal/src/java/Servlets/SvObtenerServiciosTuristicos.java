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

@WebServlet(name = "SvObtenerServiciosTuristicos", urlPatterns = {"/SvObtenerServiciosTuristicos"})
public class SvObtenerServiciosTuristicos extends HttpServlet {

    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ControladoraLogica controladoraLogica = new ControladoraLogica();
	List<ServicioTuristico> listaServiciosTuristicos = controladoraLogica.obtenerServiciosTuristicos();
	request.getSession().removeAttribute("listaServiciosTuristicos");
	request.getSession().setAttribute("listaServiciosTuristicos", listaServiciosTuristicos);
	response.sendRedirect("obtenerServiciosTuristicos.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
	return "Short description";
    }

}
