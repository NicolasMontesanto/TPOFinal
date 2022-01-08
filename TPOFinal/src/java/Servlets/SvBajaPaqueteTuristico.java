package Servlets;

import Logica.ControladoraLogica;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvBajaPaqueteTuristico", urlPatterns = {"/SvBajaPaqueteTuristico"})
public class SvBajaPaqueteTuristico extends HttpServlet {

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
	int id = Integer.parseInt(request.getParameter("id"));
	controladoraLogica.bajaPaqueteTuristico(id);
	response.sendRedirect("SvObtenerPaquetesTuristicos");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
