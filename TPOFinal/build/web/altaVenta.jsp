<%@page import="Logica.PaqueteTuristico"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logica.ServicioTuristico"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="TemplateMo">
	<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">

	<title>Agencia de Turismo</title>

	<!-- Additional CSS Files -->
	<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">

	<link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">

	<link rel="stylesheet" href="assets/css/templatemo-lava.css">

	<link rel="stylesheet" href="assets/css/owl-carousel.css">

    </head>

    <body>
	    <%HttpSession miSession = request.getSession();
		String usuario = (String) miSession.getAttribute("usuario");
		if (usuario == null) {
		    response.sendRedirect("login.jsp");
		}
	    %>
	<!-- ***** Preloader Start ***** -->
	<div id="preloader">
	    <div class="jumper">
		<div></div>
		<div></div>
		<div></div>
	    </div>
	</div>
	<!-- ***** Preloader End ***** -->


	<!-- ***** Header Area Start ***** -->
	<header class="header-area header-sticky">
	    <div class="container">
		<div class="row">
		    <div class="col-12">
			<nav class="main-nav">
			    <!-- ***** Logo Start ***** -->
			    <a href="index.jsp" class="logo">
				Agencia De Turismo
			    </a>
			    <!-- ***** Logo End ***** -->
			    <!-- ***** Menu Start ***** -->
			    <ul class="nav">
				<li><a href="index.jsp">Principal</a></li>
				<li class="submenu">
				    <a href="">Clientes</a>
				    <ul>
					<li><a href="altaCliente.jsp">Registrar Cliente</a></li>
					<li>
					    <form action="SvObtenerClientes"  method="GET">
						<a href="SvObtenerClientes" class="SUBMIT" >Ver Clientes</a>
					    </form>
					</li>
				    </ul>
				</li>
				<li class="submenu">
				    <a href="">Empleados</a>
				    <ul>
					<li><a href="altaEmpleado.jsp">Registrar Empleado</a></li>
					<li>
					    <form action="SvObtenerEmpleados"  method="GET">
						<a href="SvObtenerEmpleados" class="SUBMIT" >Ver Empleados</a>
					    </form>
					</li>
				    </ul>
				</li>
				<li class="submenu">
				    <a href="">Servicios Turísticos</a>
				    <ul>
					<li><a href="altaServicioTuristico.jsp">Registrar Servicio Turístico</a></li>
					<li>
					    <form action="SvObtenerServiciosTuristicos"  method="GET">
						<a href="SvObtenerServiciosTuristicos" class="SUBMIT" >Ver Servicios Turísticos</a>
					    </form>
					</li>
				    </ul>
				</li>
				<li class="submenu">
				    <a href="">Paquetes Turísticos</a>
				    <ul>
					<li>
					    <form action="SvObtenerServiciosParaPaquete"  method="GET">
						<a href="SvObtenerServiciosParaPaquete" class="SUBMIT" >Registrar Paquete Turístico</a>
					    </form>
					</li>
					<li>
					    <form action="SvObtenerPaquetesTuristicos"  method="GET">
						<a href="SvObtenerPaquetesTuristicos" class="SUBMIT" >Ver Paquetes Turísticos</a>
					    </form>
					</li>
				    </ul>
				</li>
				<li class="submenu">
				    <a href="">Ventas</a>
				    <ul>
					<li>
					    <form action="SvObtenerPaquetesYServiciosParaVenta"  method="GET">
						<a href="SvObtenerPaquetesYServiciosParaVenta" class="SUBMIT" >Registrar Venta</a>
					    </form>
					</li>
					<li>
					    <form action="SvObtenerVentas"  method="GET">
						<a href="SvObtenerVentas" class="SUBMIT" >Ver Ventas</a>
					    </form>
					</li>
				    </ul>
				</li>
			    </ul>
			    <!-- ***** Menu End ***** -->
			</nav>
		    </div>
		</div>
	    </div>
	</header>
	<!-- ***** Header Area End ***** -->


	<!-- ***** Welcome Area Start ***** -->
	<div class="welcome-area" id="welcome">

	    <!-- ***** Header Text Start ***** -->
	    <div class="header-text">
		<div class="container">
		    <%if (miSession.getAttribute("servicioParaVenta") == null) {
			    ServicioTuristico servicioParaVenta = new ServicioTuristico();
			    miSession.setAttribute("servicioParaVenta", servicioParaVenta);
			}
			if (miSession.getAttribute("paqueteParaVenta") == null) {
			    PaqueteTuristico paqueteParaVenta = new PaqueteTuristico();
			    miSession.setAttribute("paqueteParaVenta", paqueteParaVenta);
			}
		    %>
		    <div class="row"  style="margin-top: 0px">
			<div class="column left-text col-lg-4 col-md-6 col-sm-6 col-xs-6" data-scroll-reveal="enter left move 30px over 0.6s after 0.4s" Style=" ">
			    <form action="SvVenta" method="POST" style="">
				<h1>Registrar Venta</h1>
				<p><label>Elija el Servicio</label></p>
				<p><label>Elija el Paquete</label></p>
				<p><label>Servicio o Paquete elegido</label></p>
				<p><label style="display:inline">Medio de Pago</label><input type="text" name="medioDePago" style="display:inline; width: 250px"></p>
				<p><label style="display:inline">Codigo de Cliente</label><input type="text" name="idCliente" style="display:inline; width: 250px"></p>
				<p><label style="display:inline">Nombre de Usuario</label><input type="text" name="nombreUsuario" style="display:inline; width: 250px"></p>
				<button type="submit">Enviar</button>
			    </form>
			</div>
			<div class="column left-text col-lg-8 col-md-6 col-sm-6 col-xs-6" data-scroll-reveal="enter left move 30px over 0.6s after 0.4s" style="margin-top: -90px">
			    <form action="SvAgregarServicioAVenta" method="post">
				<label for="servicioId"></label>
				<select name="servicioId" id="servicioId">
				    <%
					List<ServicioTuristico> listaServiciosTuristicos = (List) request.getSession().getAttribute("listaServiciosTuristicos");
					for (ServicioTuristico servicio : listaServiciosTuristicos) {

				    %>
				    <option value="<%=servicio.getCod_servicio()%>"><%=servicio.getNombre()%></option>
				    <%}%>
				</select>
				<button type="submit">Agregar</button>
				<br><br>
			    </form>
			    <form action="SvAgregarPaqueteAVenta" method="post">
				<label for="paqueteId"></label>
				<select name="paqueteId" id="paqueteId">
				    <%
					List<PaqueteTuristico> listaPaquetesTuristicos = (List) request.getSession().getAttribute("listaPaquetesTuristicos");
					for (PaqueteTuristico paquete : listaPaquetesTuristicos) {

				    %>
				    <option value="<%=paquete.getCod_paquete()%>"><%=paquete.getCod_paquete()%></option>
				    <%}%>
				</select>
				<button type="submit">Agregar</button>
				<br><br>
				<br><br>
			    </form>
			    <%	String eleccion = "";
				if (miSession.getAttribute("eleccion") != null) {
				    eleccion = String.valueOf(miSession.getAttribute("eleccion"));
				}
			    %>
			    <form action="SvQuitarServicioOPaqueteAVenta" method="POST">
				<div><input type="text" name="eleccion" style="width: 250px; display:inline" readonly="" value="<%=eleccion%>">
				    <button type="submit" style="display:inline">Eliminar</button></div>
				<br><br>
			    </form>
			</div>
		    </div>
		</div>
	    </div>
	    <!-- ***** Header Text End ***** -->
	</div>
	<!-- ***** Welcome Area End ***** -->

	<!-- ***** Footer Start ***** -->
	<footer id="contact-us" style="margin-top: 400px">
	    <div class="footer-content">
	    </div>
	</footer>

	<!-- jQuery -->
	<script src="assets/js/jquery-2.1.0.min.js"></script>

	<!-- Bootstrap -->
	<script src="assets/js/popper.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>

	<!-- Plugins -->
	<script src="assets/js/owl-carousel.js"></script>
	<script src="assets/js/scrollreveal.min.js"></script>
	<script src="assets/js/waypoints.min.js"></script>
	<script src="assets/js/jquery.counterup.min.js"></script>
	<script src="assets/js/imgfix.min.js"></script>

	<!-- Global Init -->
	<script src="assets/js/custom.js"></script>

    </body>
</html>
