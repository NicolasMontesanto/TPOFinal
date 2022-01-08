package Servlets;

import Logica.Cliente;
import Logica.ControladoraLogica;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvBajaCliente", urlPatterns = {"/SvBajaCliente"})
public class SvBajaCliente extends HttpServlet {

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
	controladoraLogica.bajaCliente(id);
	response.sendRedirect("SvObtenerClientes");
    }

    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}