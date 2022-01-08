package Servlets;

import Logica.ControladoraLogica;
import Logica.Venta;
import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvObtenerVentas", urlPatterns = {"/SvObtenerVentas"})
public class SvObtenerVentas extends HttpServlet {

    ControladoraLogica controladoraLogica = new ControladoraLogica();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
	List<Venta> listaVentas = controladoraLogica.obtenerVentas();
	request.getSession().removeAttribute("listaVentas");
	request.getSession().setAttribute("listaVentas", listaVentas);
	response.sendRedirect("obtenerVentas.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
