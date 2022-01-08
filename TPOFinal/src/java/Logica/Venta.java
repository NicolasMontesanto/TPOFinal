package Logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "ventas")
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cod_venta;
    private String fecha_venta;
    private String medio_pago;
    private double monto;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private PaqueteTuristico paquete_turistico;
    @ManyToOne
    private ServicioTuristico servicio_turistico;
    private boolean habilitado = true;

    public Venta() {
    }

    public Venta(int cod_venta, String fecha_venta, String medio_pago, double monto, Cliente cliente) {
	this.cod_venta = cod_venta;
	this.fecha_venta = fecha_venta;
	this.medio_pago = medio_pago;
	this.monto = monto;
	this.cliente = cliente;
    }

    public int getCod_venta() {
	return cod_venta;
    }

    public void setCod_venta(int cod_venta) {
	this.cod_venta = cod_venta;
    }

    public String getFecha_venta() {
	return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
	this.fecha_venta = fecha_venta;
    }

    public String getMedio_pago() {
	return medio_pago;
    }

    public void setMedio_pago(String medio_pago) {
	this.medio_pago = medio_pago;
    }

    public double getMonto() {
	return monto;
    }

    public void setMonto(double monto) {
	this.monto = monto;
    }

    public Cliente getCliente() {
	return cliente;
    }

    public void setCliente(Cliente cliente) {
	this.cliente = cliente;
    }

    public Usuario getUsuario() {
	return usuario;
    }

    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }

    public boolean isHabilitado() {
	return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
	this.habilitado = habilitado;
    }

    public void deshabilitarVenta() {
	this.habilitado = false;
    }

    public PaqueteTuristico getPaquete_turistico() {
	return paquete_turistico;
    }

    public void setPaquete_turistico(PaqueteTuristico paquete_turistico) {
	this.paquete_turistico = paquete_turistico;
    }

    public ServicioTuristico getServicio_turistico() {
	return servicio_turistico;
    }

    public void setServicio_turistico(ServicioTuristico servicio_turistico) {
	this.servicio_turistico = servicio_turistico;
    }

    @Override
    public String toString() {
	return "Venta{" + "cod_venta=" + cod_venta + ", fecha_venta=" + fecha_venta + ", medio_pago=" + medio_pago + ", habilitado=" + habilitado + '}';
    }

}
