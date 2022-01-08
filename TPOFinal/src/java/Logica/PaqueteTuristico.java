package Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity (name="paquetes_turisticos")
public class PaqueteTuristico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cod_paquete;
    private double costo_paquete;
    @ManyToMany
    private List<ServicioTuristico> lista_servicios;
    private boolean habilitado = true;

    public PaqueteTuristico() {
    }

    public PaqueteTuristico(int codigo_paquete, List<ServicioTuristico> lista_servicios, double costo) {
	this.cod_paquete = codigo_paquete;
	this.lista_servicios = lista_servicios;
	this.costo_paquete = costo;
    }

    public int getCod_paquete() {
	return cod_paquete;
    }

    public void setCod_paquete(int codigo_paquete) {
	this.cod_paquete = codigo_paquete;
    }

    public List<ServicioTuristico> getLista_servicios() {
	return lista_servicios;
    }

    public void setLista_servicios(List<ServicioTuristico> lista_servicios) {
	this.lista_servicios = lista_servicios;
	this.costo_paquete = this.calcularCosto(lista_servicios);
    }

    public void agregarServicio(ServicioTuristico servicio){
	this.lista_servicios.add(servicio);
	this.costo_paquete=this.calcularCosto(lista_servicios);
    }
    
    public void quitarServicio(ServicioTuristico servicio){
	this.lista_servicios.remove(servicio);
	this.costo_paquete=this.calcularCosto(lista_servicios);
    }
    
    public double getCosto_paquete() {
	return costo_paquete;
    }

    public void setCosto_paquete(double costo_paquete) {
	this.costo_paquete = costo_paquete;
    }

    public boolean isHabilitado() {
	return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
	this.habilitado = habilitado;
    }

    public void deshabilitarPaqueteTuristico() {
	this.habilitado = false;
    }

    public double calcularCosto(List<ServicioTuristico> lista) {
	double costo = 0;
	for (ServicioTuristico servicio : lista) {
	    costo = costo + servicio.getCosto_servicio();
	}
	costo = costo * 0.9;
	return costo;
    }
}
