package Servlets;

import Logica.Cliente;
import Logica.ControladoraLogica;
import Logica.PaqueteTuristico;
import Logica.ServicioTuristico;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvVenta", urlPatterns = {"/SvVenta"})
public class SvVenta extends HttpServlet {

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
	String fecha = new SimpleDateFormat("dd-MM-yyyy hh:mm").format(new Date());
	String medioDePago = request.getParameter("medioDePago");
	String tipoEleccion = (String) request.getSession().getAttribute("tipoEleccion");
	int idCliente = Integer.parseInt(request.getParameter("idCliente"));
	Cliente cliente = controladoraLogica.buscarCliente(idCliente);
	Usuario usuario = controladoraLogica.buscarUsuario(request.getParameter("nombreUsuario"));
	double monto = 0;
	int cod = (Integer) (request.getSession().getAttribute("eleccion"));

	if (tipoEleccion.equals("servicio")) {
	    ServicioTuristico servicioTuristico = controladoraLogica.buscarServicioTuristico(cod);
	    monto = servicioTuristico.getCosto_servicio();
	} else if (tipoEleccion.equals("paquete")) {
	    PaqueteTuristico paqueteTuristico = controladoraLogica.buscarPaqueteTuristico(cod);
	    monto = paqueteTuristico.getCosto_paquete();
	}

	if (tipoEleccion.equals("servicio")) {
	    ServicioTuristico servicioTuristico = controladoraLogica.buscarServicioTuristico(cod);
	    controladoraLogica.altaVenta(fecha, medioDePago, monto, cliente, usuario, servicioTuristico);
	} else if (tipoEleccion.equals("paquete")) {
	    PaqueteTuristico paqueteTuristico = controladoraLogica.buscarPaqueteTuristico(cod);
	    controladoraLogica.altaVenta(fecha, medioDePago, monto, cliente, usuario, paqueteTuristico);
	}

	request.getSession().removeAttribute("tipoEleccion");
	request.getSession().removeAttribute("eleccion");
	response.sendRedirect("altaVenta.jsp");
    }

    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
