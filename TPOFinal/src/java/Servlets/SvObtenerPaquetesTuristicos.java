package Servlets;

import Logica.ControladoraLogica;
import Logica.PaqueteTuristico;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvObtenerPaquetesTuristicos", urlPatterns = {"/SvObtenerPaquetesTuristicos"})
public class SvObtenerPaquetesTuristicos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ControladoraLogica controladoraLogica = new ControladoraLogica();
	List<PaqueteTuristico> listaPaquetesTuristicos = controladoraLogica.obtenerPaquetesTuristicos();
	request.getSession().removeAttribute("listaPaquetesTuristicos");
	request.getSession().setAttribute("listaPaquetesTuristicos", listaPaquetesTuristicos);
	response.sendRedirect("obtenerPaquetesTuristicos.jsp");
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
