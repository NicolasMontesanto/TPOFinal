package Servlets;

import Logica.ServicioTuristico;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvQuitarServiciosAPaqueteMod", urlPatterns = {"/SvQuitarServiciosAPaqueteMod"})
public class SvQuitarServiciosAPaqueteMod extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	request.getSession().removeAttribute("serviciosParaPaquete");
	List<ServicioTuristico> serviciosParaPaquete = new ArrayList<>();
	request.getSession().setAttribute("serviciosParaPaquete", serviciosParaPaquete);
	response.sendRedirect("modificarPaqueteTuristico.jsp");
    }

    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
