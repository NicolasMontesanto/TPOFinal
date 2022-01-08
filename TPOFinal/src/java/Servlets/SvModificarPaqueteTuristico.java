
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


@WebServlet(name = "SvModificarPaqueteTuristico", urlPatterns = {"/SvModificarPaqueteTuristico"})
public class SvModificarPaqueteTuristico extends HttpServlet {

 ControladoraLogica controladoraLogica = new ControladoraLogica();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
	int id = Integer.parseInt(request.getParameter("id"));
	PaqueteTuristico paqueteTuristico = controladoraLogica.buscarPaqueteTuristico(id);
	request.getSession().removeAttribute("paqueteTuristico");
	request.getSession().setAttribute("paqueteTuristico", paqueteTuristico);
	request.getSession().removeAttribute("serviciosParaPaquete");
	request.getSession().setAttribute("serviciosParaPaquete", paqueteTuristico.getLista_servicios());
	response.sendRedirect("modificarPaqueteTuristico.jsp");
	
	}


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	PaqueteTuristico paqueteTuristico = (PaqueteTuristico) request.getSession().getAttribute("paqueteTuristico");
	List<ServicioTuristico> serviciosParaPaquete =(List) request.getSession().getAttribute("serviciosParaPaquete");
	paqueteTuristico.setLista_servicios(serviciosParaPaquete);
	controladoraLogica.modificarPaqueteTuristico(paqueteTuristico);
	request.getSession().removeAttribute("listaPaquetesTuristicos");
	request.getSession().setAttribute("listaPaquetesTuristicos", controladoraLogica.obtenerPaquetesTuristicos());
	response.sendRedirect("obtenerPaquetesTuristicos.jsp");
	
    }


    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
