package Servlets;

import Logica.ControladoraLogica;
import Logica.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEmpleado", urlPatterns = {"/SvEmpleado"})
public class SvEmpleado extends HttpServlet {

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
	Usuario usuario = new Usuario();
	    usuario.setNombre_usuario(request.getParameter("nombreUsuario"));
	    usuario.setContrasenia(request.getParameter("contrasenia"));
	    controladoraLogica.altaUsuario(usuario);
	    usuario = controladoraLogica.buscarUsuario((request.getParameter("nombreUsuario")));
	    String cargo = request.getParameter("cargo");
	    double sueldo = Double.parseDouble(request.getParameter("sueldo"));
	    String nombre = request.getParameter("nombre");
	    String apellido = request.getParameter("apellido");
	    String direccion = request.getParameter("direccion");
	    String dni = request.getParameter("dni");
	    String fecha_nac = request.getParameter("fecha_nac");
	    String nacionalidad = request.getParameter("nacionalidad");
	    String celular = request.getParameter("celular");
	    String email = request.getParameter("email");
	    controladoraLogica.altaEmpleado(cargo, sueldo, usuario, nombre, apellido, direccion, dni, fecha_nac, nacionalidad, celular, email);
	    response.sendRedirect("altaEmpleado.jsp");
    }
    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
