package Servlets;

import Logica.ControladoraLogica;
import Logica.Empleado;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvObtenerEmpleados", urlPatterns = {"/SvObtenerEmpleados"})
public class SvObtenerEmpleados extends HttpServlet {

    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ControladoraLogica controladoraLogica = new ControladoraLogica();
	List<Empleado> listaEmpleados = controladoraLogica.obtenerEmpleados();
	request.getSession().removeAttribute("listaEmpleados");
	request.getSession().setAttribute("listaEmpleados", listaEmpleados);
	response.sendRedirect("obtenerEmpleados.jsp");
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
