package Persistencia;

import Logica.Cliente;
import Logica.Empleado;
import Logica.PaqueteTuristico;
import Logica.ServicioTuristico;
import Logica.Usuario;
import Logica.Venta;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorPersistencia {

    PersonaJpaController personaJPA = new PersonaJpaController();
    ClienteJpaController clienteJPA = new ClienteJpaController();
    EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();
    ServicioTuristicoJpaController servicio_turisticoJPA = new ServicioTuristicoJpaController();
    PaqueteTuristicoJpaController paquete_turisticoJPA = new PaqueteTuristicoJpaController();
    VentaJpaController ventaJPA = new VentaJpaController();

    // <editor-fold defaultstate="collapsed" desc=" clienteJPA ">
    //Método de Alta de Cliente.
    public void altaCliente(Cliente cli) {
	try {
	    clienteJPA.create(cli);
	} catch (Exception ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    //Métodos de Baja de Cliente.
    public void bajaCliente(Cliente cli) {
	try {
	    clienteJPA.destroy(cli.getId_persona());
	} catch (NonexistentEntityException ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public void bajaCliente(int id) {
	try {
	    clienteJPA.destroy(id);
	} catch (NonexistentEntityException ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    //Método para Modificar un Cliente.
    public void modificarCliente(Cliente cli) {
	try {
	    clienteJPA.edit(cli);
	} catch (Exception ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    //Métodos para Buscar un Cliente.
    public Cliente buscarCliente(int id) {
	return clienteJPA.findCliente(id);
    }

    public Cliente buscarCliente(Cliente cli) {
	return clienteJPA.findCliente(cli.getId_persona());
    }

    //Método para Obtener todos los Clientes
    public List<Cliente> obtenerClientes() {
	return clienteJPA.findClienteEntities();
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" empleadoJPA ">

    //Método de Alta de Empleado.
    public void altaEmpleado(Empleado empleado) {
	try {
	    empleadoJPA.create(empleado);
	} catch (Exception ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    //Métodos de Baja de Empleado.
    public void bajaEmpleado(Empleado empleado) {
	try {
	    empleadoJPA.destroy(empleado.getId_persona());
	} catch (NonexistentEntityException ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public void bajaEmpleado(int id) {
	try {
	    empleadoJPA.destroy(id);
	} catch (NonexistentEntityException ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    //Método para Modificar un Empleado.
    public void modificarEmpleado(Empleado empleado) {
	try {
	    empleadoJPA.edit(empleado);
	} catch (Exception ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    //Métodos para Buscar un Empleado.
    public Empleado buscarEmpleado(int id) {
	return empleadoJPA.findEmpleado(id);
    }

    public Empleado buscarEmpleado(Empleado empleado) {
	return empleadoJPA.findEmpleado(empleado.getId_persona());
    }

    //Método para Obtener todos los Empleados
    public List<Empleado> obtenerEmpleados() {
	return empleadoJPA.findEmpleadoEntities();
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" usuarioJPA ">
    //Método de Alta de Usuario.
    public void altaUsuario(Usuario usuario) {
	try {
	    usuarioJPA.create(usuario);
	} catch (Exception ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    //Métodos de Baja de Usuario.
    public void bajaUsuario(Usuario usuario) {
	try {
	    usuarioJPA.destroy(usuario.getId_usuario());
	} catch (NonexistentEntityException ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public void bajaUsuario(int id) {
	try {
	    usuarioJPA.destroy(id);
	} catch (NonexistentEntityException ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    //Método para Modificar un Usuario.
    public void modificarUsuario(Usuario usuario) {
	try {
	    usuarioJPA.edit(usuario);
	} catch (Exception ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    //Métodos para Buscar un Usuario.
    public Usuario buscarUsuario(int id) {
	return usuarioJPA.findUsuario(id);
    }

    public Usuario buscarUsuario(Usuario usuario) {
	return usuarioJPA.findUsuario(usuario.getId_usuario());
    }

    //Método para Obtener todos los Usuarios
    public List<Usuario> obtenerUsuarios() {
	return usuarioJPA.findUsuarioEntities();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" servicio_turisticoJPA ">
    //Método de Alta de Servicio Turistico.
    public void altaServicioTuristico(ServicioTuristico servicio_turistico) {
	try {
	    servicio_turisticoJPA.create(servicio_turistico);
	} catch (Exception ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    //Métodos de Baja de Servicio Turistico.
    public void bajaServicioTuristico(ServicioTuristico servicio_turistico) {
	try {
	    servicio_turisticoJPA.destroy(servicio_turistico.getCod_servicio());
	} catch (NonexistentEntityException ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public void bajaServicioTuristico(int id) {
	try {
	    servicio_turisticoJPA.destroy(id);
	} catch (NonexistentEntityException ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    //Método para Modificar un ServicioTuristico.
    public void modificarServicioTuristico(ServicioTuristico servicio_turistico) {
	try {
	    servicio_turisticoJPA.edit(servicio_turistico);
	} catch (Exception ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    //Métodos para Buscar un ServicioTuristico.
    public ServicioTuristico buscarServicioTuristico(int id) {
	return servicio_turisticoJPA.findServicioTuristico(id);
    }

    public ServicioTuristico buscarServicioTuristico(ServicioTuristico servicio_turistico) {
	return servicio_turisticoJPA.findServicioTuristico(servicio_turistico.getCod_servicio());
    }

    //Método para Obtener todos los Servicios Turisticos
    public List<ServicioTuristico> obtenerServiciosTuristicos() {
	return servicio_turisticoJPA.findServicioTuristicoEntities();
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" paquete_turisticoJPA ">
    //Método de Alta de Paquete Turístico.
    public void altaPaqueteTuristico(PaqueteTuristico paquete_turistico) {
	try {
	    paquete_turisticoJPA.create(paquete_turistico);
	} catch (Exception ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    //Métodos de Baja de Paquete Turístico.
    public void bajaPaqueteTuristico(PaqueteTuristico paquete_turistico) {
	try {
	    paquete_turisticoJPA.destroy(paquete_turistico.getCod_paquete());
	} catch (NonexistentEntityException ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public void bajaPaqueteTuristico(int id) {
	try {
	    paquete_turisticoJPA.destroy(id);
	} catch (NonexistentEntityException ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    //Método para Modificar un Paquete Turístico.
    public void modificarPaqueteTuristico(PaqueteTuristico paquete_turistico) {
	try {
	   paquete_turisticoJPA.edit(paquete_turistico);
	} catch (Exception ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    //Métodos para Buscar un Paquete Turístico.
    public PaqueteTuristico buscarPaqueteTuristico(int id) {
	return paquete_turisticoJPA.findPaqueteTuristico(id);
    }

    public PaqueteTuristico buscarPaqueteTuristico(PaqueteTuristico paquete_turistico) {
	return paquete_turisticoJPA.findPaqueteTuristico(paquete_turistico.getCod_paquete());
    }

    //Método para Obtener todos los Paquetes Turísticos.
    public List<PaqueteTuristico> obtenerPaquetesTuristicos() {
	return paquete_turisticoJPA.findPaqueteTuristicoEntities();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" ventaJPA ">
    //Método de Alta de Venta.
    public void altaVenta(Venta venta) {
	try {
	    ventaJPA.create(venta);
	} catch (Exception ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    //Métodos de Baja de Venta.
    public void bajaVenta(Venta venta) {
	try {
	    ventaJPA.destroy(venta.getCod_venta());
	} catch (NonexistentEntityException ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public void bajaVenta(int id) {
	try {
	    ventaJPA.destroy(id);
	} catch (NonexistentEntityException ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    //Método para Modificar una Venta.
    public void modificarVenta(Venta venta) {
	try {
	    ventaJPA.edit(venta);
	} catch (Exception ex) {
	    Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    //Métodos para Buscar una Venta.
    public Venta buscarVenta(int id) {
	return ventaJPA.findVenta(id);
    }

    public Venta buscarVenta(Venta venta) {
	return ventaJPA.findVenta(venta.getCod_venta());
    }

    //Método para Obtener todos las Ventas.
    public List<Venta> obtenerVentas() {
	return ventaJPA.findVentaEntities();
    }
    // </editor-fold>

    
}
