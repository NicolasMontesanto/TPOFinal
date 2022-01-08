package Servlets;

import Logica.ControladoraLogica;
import Logica.Empleado;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvModificarEmpleado", urlPatterns = {"/SvModificarEmpleado"})
public class SvModificarEmpleado extends HttpServlet {

    ControladoraLogica controladoraLogica = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
	int id = Integer.parseInt(request.getParameter("id"));
	Empleado empleado = controladoraLogica.buscarEmpleado(id);
	request.getSession().removeAttribute("empleado");
	request.getSession().setAttribute("empleado", empleado);
	response.sendRedirect("modificarEmpleado.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	Empleado empleado =(Empleado) request.getSession().getAttribute("empleado");
	empleado.setNombre(request.getParameter("nombre"));
	empleado.setApellido(request.getParameter("apellido"));
	empleado.setCargo(request.getParameter("cargo"));
	double sueldo = Double.parseDouble(request.getParameter("sueldo"));
	empleado.setSueldo(sueldo);
	empleado.setDireccion(request.getParameter("direccion"));
	empleado.setDni(request.getParameter("dni"));
	empleado.setFecha_nac(request.getParameter("fecha_nac"));
	empleado.setNacionalidad(request.getParameter("nacionalidad"));
	empleado.setCelular(request.getParameter("celular"));
	empleado.setEmail(request.getParameter("email"));
	controladoraLogica.modificarEmpleado(empleado);
	request.getSession().removeAttribute("listaEmpleados");
	request.getSession().setAttribute("listaEmpleados", controladoraLogica.obtenerEmpleados());
	response.sendRedirect("obtenerEmpleados.jsp");

    }

    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
