package Servlets;

import Logica.ControladoraLogica;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvBajaServicioTuristico", urlPatterns = {"/SvBajaServicioTuristico"})
public class SvBajaServicioTuristico extends HttpServlet {

    ControladoraLogica controladoraLogica = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
	controladoraLogica.bajaServicioTuristico(id);
	response.sendRedirect("SvObtenerServiciosTuristicos");
    }

    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
