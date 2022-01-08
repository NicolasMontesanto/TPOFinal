package Servlets;

import Logica.ControladoraLogica;
import Logica.ServicioTuristico;
import Logica.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvPaqueteTuristico", urlPatterns = {"/SvPaqueteTuristico"})
public class SvPaqueteTuristico extends HttpServlet {

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
	    List<ServicioTuristico> serviciosParaPaquete =(List) request.getSession().getAttribute("serviciosParaPaquete");
	    controladoraLogica.altaPaqueteTuristico(serviciosParaPaquete);
	    request.getSession().removeAttribute("serviciosParaPaquete");
	    response.sendRedirect("altaPaqueteTuristico.jsp");
    }
    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
