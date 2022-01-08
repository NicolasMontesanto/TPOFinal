<%@page import="Logica.PaqueteTuristico"%>
<%@page import="Logica.ServicioTuristico"%>
<%@page import="Logica.Usuario"%>
<%@page import="Logica.Empleado"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="Logica.ControladoraLogica"%>
<%@page import="Logica.Cliente"%>
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
	<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="assets/images/icons/favicon.ico"/>
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/vendor/bootstrap/css/bootstrap.min.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/vendor/animate/animate.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/vendor/select2/select2.min.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/vendor/perfect-scrollbar/perfect-scrollbar.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/css/util.css">
	<link rel="stylesheet" type="text/css" href="assets/css/main.css">
	<!--===============================================================================================-->
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
	    <div class="limiter">
		<div class="container-table100">
		    <div class="wrap-table100">
			<div class="table100 ver1">
			    <div class="table100-firstcol">
				<table style="margin-left: -250px; width: 550px ">
				    <thead>
					<tr class="row100 head">
					    <th class="cell100 column1">Código</th>
					    <th class="cell100 column2">Eliminar</th>
					    <th class="cell100 column3">Modificar</th>
					    <th class="cell100 column3">Ventas</th>
					</tr>
				    </thead>
				    <tbody>
					<%
					    List<PaqueteTuristico> listaPaquetesTuristicos = (List) request.getSession().getAttribute("listaPaquetesTuristicos");
					    for (PaqueteTuristico paqueteTuristico : listaPaquetesTuristicos) {
						int id = paqueteTuristico.getCod_paquete();
					%>
					<tr class="row100 body">
					    <td class="cell100 column1"><%=id%></td>
					    <td class="cell100 column2">
						<form name="formBajaPaqueteTuristico" action="SvBajaPaqueteTuristico" method="POST" style="display:inline">
						    <input type="hidden" name="id" value="<%=id%>">
						    <button type="submit" class="btn-danger" data-title="Delete" style="display:inline">Eliminar</button>	
						</form>
					    </td>
					    <td class="cell100 column3">
						<form name="formModificarPaqueteTuristico" action="SvModificarPaqueteTuristico" method="GET" style="display:inline">
						    <input type="hidden" name="id" value="<%=id%>">
						    <button type="submit" class="btn-primary" data-title="Edit" style="display:inline">Modificar</button>
						</form>
					    </td>
					    <td class="cell100 column3">
						<form name="formVentasPaqueteTuristico" action="SvVentasPaqueteTuristico" method="GET" style="display:inline">
						    <input type="hidden" name="id" value="<%=id%>">
						    <button type="submit" class="btn-secondary" data-title="Edit" style="display:inline">Ventas</button>
						</form>
					    </td>
					</tr>


					<%}%>
				    </tbody>
				</table>
			    </div>

			    <div class="wrap-table100-nextcols js-pscroll"  Style="width: 1400px">
				<div class="table100-nextcols">
				    <table>
					<thead>
					    <tr class="row100 head">
						<th class="cell100 column7" style="width: 500px">Servicios Turisticos</th>
						<th class="cell100 column10" style="width: 100px">Costo</th>
					    </tr>
					</thead>
					<tbody>
					    <%
						List<PaqueteTuristico> listaPaquetesTuristicos2 = (List) request.getSession().getAttribute("listaPaquetesTuristicos");
						for (PaqueteTuristico paqueteTuristico : listaPaquetesTuristicos2) {
						    String servicios = "";
						    for (ServicioTuristico servicioTuristico : paqueteTuristico.getLista_servicios()) {
							if (servicios.isBlank()) {
							    servicios = servicioTuristico.getNombre();
							} else {
							    servicios = servicios + ", " + servicioTuristico.getNombre();
							}
						    }
						    servicios = servicios + ".";

					    %>
					    <tr class="row100 body">
						<td class="cell100 column2" style="padding-left: 0px"><%=servicios%></td>
						<td class="cell100 column2" style="padding-left: 0px"><%=paqueteTuristico.getCosto_paquete()%></td>
					    </tr>
					    <%}%>
					</tbody>
				    </table>
				</div>
			    </div>
			</div>
		    </div>
		</div>
	    </div>
	</div>
	<!--===============================================================================================-->	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script>
	    $('.js-pscroll').each(function () {
		var ps = new PerfectScrollbar(this);

		$(window).on('resize', function () {
		    ps.update();
		});

		$(this).on('ps-x-reach-start', function () {
		    $(this).parent().find('.table100-firstcol').removeClass('shadow-table100-firstcol');
		});

		$(this).on('ps-scroll-x', function () {
		    $(this).parent().find('.table100-firstcol').addClass('shadow-table100-firstcol');
		});

	    });

	</script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>
	<!-- ***** Welcome Area End ***** -->

	<!-- ***** Footer Start ***** -->
	<footer id="contact-us" style="margin-top: -200px">
	    <div class="container">
		<div class="footer-content">

		</div>
		<div class="row">
		    <div class="col-lg-12">
			<div class="sub-footer">
			</div>
		    </div>
		</div>
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