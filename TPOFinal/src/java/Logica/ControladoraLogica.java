package Logica;

import Persistencia.ControladorPersistencia;
import java.util.Iterator;
import java.util.List;

public class ControladoraLogica {

    ControladorPersistencia control_persistencia = new ControladorPersistencia();

    public ControladoraLogica() {
    }

// <editor-fold defaultstate="collapsed" desc="Cliente">
    //Método de Alta de Cliente.
    public void altaCliente(String nombre, String apellido, String direccion, String dni, String fecha_nac, String nacionalidad, String celular, String email) {
	Cliente cliente = new Cliente();
	cliente.setNombre(nombre);
	cliente.setApellido(apellido);
	cliente.setDireccion(direccion);
	cliente.setDni(dni);
	cliente.setFecha_nac(fecha_nac);
	cliente.setNacionalidad(nacionalidad);
	cliente.setCelular(celular);
	cliente.setEmail(email);
	control_persistencia.altaCliente(cliente);
    }

    public void altaCliente(Cliente cliente) {
	control_persistencia.altaCliente(cliente);
    }

    //Métodos de Baja de Cliente.
    public void bajaFisicaCliente(Cliente cliente) {
	control_persistencia.bajaCliente(cliente);
    }

    public void bajaFisicaCliente(int id) {
	control_persistencia.bajaCliente(id);
    }

    public void bajaCliente(Cliente cliente) {
	cliente.deshabilitarPersona();
	control_persistencia.modificarCliente(cliente);
    }

    public void bajaCliente(int id) {
	Cliente cliente = control_persistencia.buscarCliente(id);
	cliente.deshabilitarPersona();
	control_persistencia.modificarCliente(cliente);
    }

    //Métodos para Modificar un Cliente.
    public void modificarCliente(Cliente cliente) {
	control_persistencia.modificarCliente(cliente);
    }

    public void agregarVenta(Cliente cliente, Venta venta) {
	cliente.agregarVenta(venta);
	control_persistencia.modificarCliente(cliente);

    }

    public void quitarVenta(Cliente cliente, Venta venta) {
	cliente.quitarVenta(venta);
	control_persistencia.modificarCliente(cliente);
    }

    //Métodos para Buscar un Cliente.
    public Cliente buscarCliente(Cliente cliente) {
	return control_persistencia.buscarCliente(cliente);
    }

    public Cliente buscarCliente(int id) {
	return control_persistencia.buscarCliente(id);
    }

    //Método para Obtener los Clientes Habilitados.
    public List<Cliente> obtenerClientes() {
	List<Cliente> lista = control_persistencia.obtenerClientes();
	Iterator<Cliente> iterator = lista.iterator();
	Cliente cli = new Cliente();
	while (iterator.hasNext()) {
	    cli = iterator.next();
	    if (!cli.isHabilitado()) {
		iterator.remove();
	    }
	}
	return lista;
    }

    //Método para Obtener todos los Clientes.
    public List<Cliente> obtenerClientesTodos() {
	return control_persistencia.obtenerClientes();
    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Empleado">
    //Método de Alta de Empleado.
    public void altaEmpleado(String cargo, double sueldo, Usuario usuario, String nombre, String apellido, String direccion, String dni, String fecha_nac, String nacionalidad, String celular, String email) {
	Empleado empleado = new Empleado();
	empleado.setCargo(cargo);
	empleado.setSueldo(sueldo);
	empleado.setUsuario(usuario);
	empleado.setNombre(nombre);
	empleado.setApellido(apellido);
	empleado.setDireccion(direccion);
	empleado.setDni(dni);
	empleado.setFecha_nac(fecha_nac);
	empleado.setNacionalidad(nacionalidad);
	empleado.setCelular(celular);
	empleado.setEmail(email);
	control_persistencia.altaEmpleado(empleado);
    }

    public void altaEmpleado(Empleado empleado) {
	control_persistencia.altaEmpleado(empleado);
    }

    //Métodos de Baja de Empleado.
    public void bajaEmpleado(Empleado empleado) {
	empleado.deshabilitarPersona();
	control_persistencia.modificarEmpleado(empleado);
    }

    public void bajaEmpleado(int id) {
	Empleado empleado = control_persistencia.buscarEmpleado(id);
	empleado.deshabilitarPersona();
	control_persistencia.modificarEmpleado(empleado);
    }

    public void bajaFisicaEmpleado(Empleado empleado) {
	control_persistencia.bajaEmpleado(empleado);
    }

    public void bajaFisicaEmpleado(int id) {
	control_persistencia.bajaEmpleado(id);
    }

    //Método para Modificar un Empleado.
    public void modificarEmpleado(Empleado empleado) {
	control_persistencia.modificarEmpleado(empleado);
    }

    //Métodos para Buscar un Empleado.
    public Empleado buscarEmpleado(Empleado empleado) {
	return control_persistencia.buscarEmpleado(empleado);
    }

    public Empleado buscarEmpleado(int id) {
	return control_persistencia.buscarEmpleado(id);
    }

    //Método para Obtener los Empleados Habilitados.
    public List<Empleado> obtenerEmpleados() {
	List<Empleado> lista = control_persistencia.obtenerEmpleados();
	Iterator<Empleado> iterator = lista.iterator();
	Empleado emp = new Empleado();
	while (iterator.hasNext()) {
	    emp = iterator.next();
	    if (!emp.isHabilitado()) {
		iterator.remove();
	    }
	}
	return lista;
    }

    //Método para Obtener todos los Empleados.
    public List<Empleado> obtenerEmpleadosTodos() {
	return control_persistencia.obtenerEmpleados();
    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Usuario">
    //Método de Alta de Usuario
    public void altaUsuario(String nombre_usuario, String contrasenia) {
	Usuario usuario = new Usuario();
	usuario.setNombre_usuario(nombre_usuario);
	usuario.setContrasenia(contrasenia);
	control_persistencia.altaUsuario(usuario);
    }

    public void altaUsuario(Usuario usuario) {
	control_persistencia.altaUsuario(usuario);
    }

    //Métodos de Baja de Usuario.
    public void bajaUsuario(Usuario usuario) {
	usuario.deshabilitarUsuario();
	control_persistencia.modificarUsuario(usuario);
    }

    public void bajaUsuario(int id) {
	Usuario usuario = control_persistencia.buscarUsuario(id);
	usuario.deshabilitarUsuario();
	control_persistencia.modificarUsuario(usuario);
    }

    public void bajaFisicaUsuario(Usuario usuario) {
	control_persistencia.bajaUsuario(usuario);
    }

    public void bajaFisicaUsuario(int id) {
	control_persistencia.bajaUsuario(id);
    }

    //Métodos para Modificar un Usuario.
    public void modificarUsuario(Usuario usuario) {
	control_persistencia.modificarUsuario(usuario);
    }

    public void agregarVenta(Usuario usuario, Venta venta) {
	usuario.agregarVenta(venta);
	control_persistencia.modificarUsuario(usuario);

    }

    public void quitarVenta(Usuario usuario, Venta venta) {
	usuario.quitarVenta(venta);
	control_persistencia.modificarUsuario(usuario);
    }

    //Métodos para Buscar un Usuario.
    public Usuario buscarUsuario(Usuario usuario) {
	return control_persistencia.buscarUsuario(usuario);
    }

    public Usuario buscarUsuario(int id) {
	return control_persistencia.buscarUsuario(id);
    }

    public Usuario buscarUsuario(String nombreUsuario) {
	List<Usuario> lista = control_persistencia.obtenerUsuarios();
	for (Usuario usuario : lista) {
	    if (usuario.getNombre_usuario().equals(nombreUsuario)) {
		return usuario;
	    }
	}
	return null;
    }

    public boolean verficarUsuario(String nombreUsuario, String contrasenia) {
	List<Usuario> lista = this.obtenerUsuarios();
	for (Usuario usuario : lista) {
	    if ((usuario.getNombre_usuario().equals(nombreUsuario)) && (usuario.getContrasenia().equals(contrasenia))) {
		return true;
	    }
	}
	return false;
    }

    //Método para Obtener los Usuarios Habilitados.
    public List<Usuario> obtenerUsuarios() {
	List<Usuario> lista = control_persistencia.obtenerUsuarios();
	Iterator<Usuario> iterator = lista.iterator();
	Usuario usuario = new Usuario();
	while (iterator.hasNext()) {
	    usuario = iterator.next();
	    if (!usuario.isHabilitado()) {
		iterator.remove();
	    }
	}
	return lista;
    }

    //Método para Obtener todos los Usuarios.
    public List<Usuario> obtenerUsuariosTodos() {
	return control_persistencia.obtenerUsuarios();
    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Servicio Turístico">
    //Método de Alta de Servicio Turístico
    public void altaServicioTuristico(String nombre, String descripcion, String destino_servicio, String fecha_servicio, double costo_servicio) {
	ServicioTuristico servicio_turistico = new ServicioTuristico();
	servicio_turistico.setNombre(nombre);
	servicio_turistico.setDescripcion(descripcion);
	servicio_turistico.setDestino_servicio(destino_servicio);
	servicio_turistico.setFecha_servicio(fecha_servicio);
	servicio_turistico.setCosto_servicio(costo_servicio);
	control_persistencia.altaServicioTuristico(servicio_turistico);
    }

    public void altaServicioTuristico(ServicioTuristico servicio_turistico) {
	control_persistencia.altaServicioTuristico(servicio_turistico);
    }

    //Métodos de Baja de Servicio Turístico.
    public void bajaServicioTuristico(ServicioTuristico servicio_turistico) {
	servicio_turistico.deshabilitarServicioTuristico();
	control_persistencia.modificarServicioTuristico(servicio_turistico);
    }

    public void bajaServicioTuristico(int id) {
	ServicioTuristico servicio_turistico = control_persistencia.buscarServicioTuristico(id);
	servicio_turistico.deshabilitarServicioTuristico();
	control_persistencia.modificarServicioTuristico(servicio_turistico);
    }

    public void bajaFisicaServicioTuristico(ServicioTuristico servicio_turistico) {
	control_persistencia.bajaServicioTuristico(servicio_turistico);
    }

    public void bajaFisicaServicioTuristico(int id) {
	control_persistencia.bajaServicioTuristico(id);
    }

    //Métodos para Modificar un Servicio Turístico.
    public void modificarServicioTuristico(ServicioTuristico servicio_turistico) {
	control_persistencia.modificarServicioTuristico(servicio_turistico);
    }

    public void agregarPaquete(ServicioTuristico servicio_turistico, PaqueteTuristico paquete_turistico) {
	servicio_turistico.agregarPaquete(paquete_turistico);
	control_persistencia.modificarServicioTuristico(servicio_turistico);

    }

    public void quitarPaquete(ServicioTuristico servicio_turistico, PaqueteTuristico paquete_turistico) {
	servicio_turistico.quitarPaquete(paquete_turistico);
	control_persistencia.modificarServicioTuristico(servicio_turistico);

    }

    //Métodos para Buscar un Servicio Turístico.
    public ServicioTuristico buscarServicioTuristico(ServicioTuristico servicio_turistico) {
	return control_persistencia.buscarServicioTuristico(servicio_turistico);
    }

    public ServicioTuristico buscarServicioTuristico(int id) {
	return control_persistencia.buscarServicioTuristico(id);
    }

    //Método para Obtener los Servicios Turisticos Habilitados.
    public List<ServicioTuristico> obtenerServiciosTuristicos() {
	List<ServicioTuristico> lista = control_persistencia.obtenerServiciosTuristicos();
	Iterator<ServicioTuristico> iterator = lista.iterator();
	ServicioTuristico serv = new ServicioTuristico();
	while (iterator.hasNext()) {
	    serv = iterator.next();
	    if (!serv.isHabilitado()) {
		iterator.remove();
	    }
	}
	return lista;
    }

    //Método para Obtener todos los Servicios Turisticos.
    public List<ServicioTuristico> obtenerServiciosTuristicosTodos() {
	return control_persistencia.obtenerServiciosTuristicos();
    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Paquete Turístico">
    //Método de Alta de Paquete Turístico.
    public void altaPaqueteTuristico(List<ServicioTuristico> lista_servicios) {
	PaqueteTuristico paquete_turistico = new PaqueteTuristico();
	paquete_turistico.setLista_servicios(lista_servicios);
	paquete_turistico.setCosto_paquete(paquete_turistico.calcularCosto(lista_servicios));
	control_persistencia.altaPaqueteTuristico(paquete_turistico);
    }

    public void altaPaqueteTuristico(PaqueteTuristico paquete_turistico) {
	control_persistencia.altaPaqueteTuristico(paquete_turistico);
    }

    //Métodos de Baja de Paquete Turístico.
    public void bajaPaqueteTuristico(PaqueteTuristico paquete_turistico) {
	paquete_turistico.deshabilitarPaqueteTuristico();
	control_persistencia.modificarPaqueteTuristico(paquete_turistico);
    }

    public void bajaPaqueteTuristico(int id) {
	PaqueteTuristico paquete_turistico = control_persistencia.buscarPaqueteTuristico(id);
	paquete_turistico.deshabilitarPaqueteTuristico();
	control_persistencia.modificarPaqueteTuristico(paquete_turistico);
    }

    public void bajaFisicaPaqueteTuristico(PaqueteTuristico paquete_turistico) {
	control_persistencia.bajaPaqueteTuristico(paquete_turistico);
    }

    public void bajaFisicaPaqueteTuristico(int id) {
	control_persistencia.bajaPaqueteTuristico(id);
    }

    //Métodos para Modificar un Paquete Turístico.
    public void modificarPaqueteTuristico(PaqueteTuristico paquete_turistico) {
	control_persistencia.modificarPaqueteTuristico(paquete_turistico);
    }

    public void agregarServicio(PaqueteTuristico paquete_turistico, ServicioTuristico servicio_turistico) {
	paquete_turistico.agregarServicio(servicio_turistico);
	control_persistencia.modificarPaqueteTuristico(paquete_turistico);
    }

    public void quitarServicio(PaqueteTuristico paquete_turistico, ServicioTuristico servicio_turistico) {
	paquete_turistico.quitarServicio(servicio_turistico);
	control_persistencia.modificarPaqueteTuristico(paquete_turistico);
    }

    //Métodos para Buscar un Paquete Turístico.
    public PaqueteTuristico buscarPaqueteTuristico(PaqueteTuristico paquete_turistico) {
	return control_persistencia.buscarPaqueteTuristico(paquete_turistico);
    }

    public PaqueteTuristico buscarPaqueteTuristico(int id) {
	return control_persistencia.buscarPaqueteTuristico(id);
    }

    //Método para Obtener los Paquetes Turisticos Habilitados.
    public List<PaqueteTuristico> obtenerPaquetesTuristicos() {
	List<PaqueteTuristico> lista = control_persistencia.obtenerPaquetesTuristicos();
	Iterator<PaqueteTuristico> iterator = lista.iterator();
	PaqueteTuristico paque = new PaqueteTuristico();
	while (iterator.hasNext()) {
	    paque = iterator.next();
	    if (!paque.isHabilitado()) {
		iterator.remove();
	    }
	}
	return lista;
    }

    //Método para Obtener todos los Paquetes Turisticos.
    public List<PaqueteTuristico> obtenerPaquetesTuristicosTodos() {
	return control_persistencia.obtenerPaquetesTuristicos();
    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Venta">
    //Método de Alta de Venta.
    public void altaVenta(String fecha_venta, String medio_pago, double monto, Cliente cliente, Usuario usuario, ServicioTuristico servicio_turistico) {
	Venta venta = new Venta();
	venta.setFecha_venta(fecha_venta);
	venta.setMedio_pago(medio_pago);
	venta.setMonto(monto);
	venta.setCliente(cliente);
	venta.setUsuario(usuario);
	venta.setServicio_turistico(servicio_turistico);
	control_persistencia.altaVenta(venta);
    }

    public void altaVenta(String fecha_venta, String medio_pago, double monto, Cliente cliente, Usuario usuario, PaqueteTuristico paquete_turistico) {
	Venta venta = new Venta();
	venta.setFecha_venta(fecha_venta);
	venta.setMedio_pago(medio_pago);
	venta.setMonto(monto);
	venta.setCliente(cliente);
	venta.setUsuario(usuario);
	venta.setPaquete_turistico(paquete_turistico);
	control_persistencia.altaVenta(venta);
    }

    public void altaVenta(Venta venta) {
	control_persistencia.altaVenta(venta);
    }

    public void aniadirServicioTuristico(Venta venta, ServicioTuristico servicio_turistico) {
	venta.setServicio_turistico(servicio_turistico);
	control_persistencia.modificarVenta(venta);
    }

    public void aniadirPaqueteTuristico(Venta venta, PaqueteTuristico paquete_turistico) {
	venta.setPaquete_turistico(paquete_turistico);
	control_persistencia.modificarVenta(venta);
    }

    //Métodos de Baja de Venta.
    public void bajaVenta(Venta venta) {
	venta.deshabilitarVenta();
	control_persistencia.modificarVenta(venta);
    }

    public void bajaVenta(int id) {
	Venta venta = control_persistencia.buscarVenta(id);
	venta.deshabilitarVenta();
	control_persistencia.modificarVenta(venta);
    }

    public void bajaFisicaVenta(Venta venta) {
	control_persistencia.bajaVenta(venta);
    }

    public void bajaFisicaVenta(int id) {
	control_persistencia.bajaVenta(id);
    }

    //Método para Modificar una Venta.
    public void modificarVenta(Venta venta) {
	control_persistencia.modificarVenta(venta);
    }

    //Métodos para Buscar una Venta.
    public Venta buscarVenta(Venta venta) {
	return control_persistencia.buscarVenta(venta);
    }

    public Venta buscarVenta(int id) {
	return control_persistencia.buscarVenta(id);
    }

    //Método para Obtener las Ventas Habilitadas
    public List<Venta> obtenerVentas() {
	List<Venta> lista = control_persistencia.obtenerVentas();
	Iterator<Venta> iterator = lista.iterator();
	Venta venta = new Venta();
	while (iterator.hasNext()) {
	    venta = iterator.next();
	    if (!venta.isHabilitado()) {
		iterator.remove();
	    }
	}
	return lista;
    }

    //Método para Obtener todas las Ventas.
    public List<Venta> obtenerVentasTodas() {
	return control_persistencia.obtenerVentas();
    }

// </editor-fold>
}
