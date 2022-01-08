package Servlets;

import Logica.Cliente;
import Logica.ControladoraLogica;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvModificarCliente", urlPatterns = {"/SvModificarCliente"})
public class SvModificarCliente extends HttpServlet {

    ControladoraLogica controladoraLogica = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
	Cliente cliente = controladoraLogica.buscarCliente(id);
	request.getSession().removeAttribute("cliente");
	request.getSession().setAttribute("cliente", cliente);
	response.sendRedirect("modificarCliente.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	Cliente cliente =(Cliente) request.getSession().getAttribute("cliente");
	cliente.setNombre(request.getParameter("nombre"));
	cliente.setApellido(request.getParameter("apellido"));
	cliente.setDireccion(request.getParameter("direccion"));
	cliente.setDni(request.getParameter("dni"));
	String fecha_nac = request.getParameter("fecha_nac");
	cliente.setFecha_nac(fecha_nac);
	cliente.setNacionalidad(request.getParameter("nacionalidad"));
	cliente.setCelular(request.getParameter("celular"));
	cliente.setEmail(request.getParameter("email"));
	cliente.setId_persona(Integer.parseInt(request.getParameter("id")));
	controladoraLogica.modificarCliente(cliente);
	request.getSession().removeAttribute("listaClientes");
	request.getSession().setAttribute("listaClientes", controladoraLogica.obtenerClientes());
	response.sendRedirect("obtenerClientes.jsp");

    }

    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
