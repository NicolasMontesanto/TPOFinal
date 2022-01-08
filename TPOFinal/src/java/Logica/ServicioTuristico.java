package Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity (name="servicios_turisticos")
public class ServicioTuristico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cod_servicio;
    private String nombre;
    private String descripcion;
    private String destino_servicio;
    private String fecha_servicio;
    private double costo_servicio;
    private boolean habilitado = true;
    @ManyToMany
    private List<PaqueteTuristico> lista_paquetes;

    public ServicioTuristico() {
    }

    public ServicioTuristico(int codigo_servicio, String nombre, String descripcion, String destino_servicio, String fecha_servicio, double costo_servicio) {
	this.cod_servicio = codigo_servicio;
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.destino_servicio = destino_servicio;
	this.fecha_servicio = fecha_servicio;
	this.costo_servicio = costo_servicio;
    }

    public int getCod_servicio() {
	return cod_servicio;
    }

    public void setCod_servicio(int cod_servicio) {
	this.cod_servicio = cod_servicio;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getDescripcion() {
	return descripcion;
    }

    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }

    public String getDestino_servicio() {
	return destino_servicio;
    }

    public void setDestino_servicio(String destino_servicio) {
	this.destino_servicio = destino_servicio;
    }

    public String getFecha_servicio() {
	return fecha_servicio;
    }

    public void setFecha_servicio(String fecha_servicio) {
	this.fecha_servicio = fecha_servicio;
    }

    public double getCosto_servicio() {
	return costo_servicio;
    }

    public void setCosto_servicio(double costo_servicio) {
	this.costo_servicio = costo_servicio;
    }

    public boolean isHabilitado() {
	return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
	this.habilitado = habilitado;
    }

    public List<PaqueteTuristico> getLista_paquetes() {
	return lista_paquetes;
    }

    public void setLista_paquetes(List<PaqueteTuristico> lista_paquetes) {
	this.lista_paquetes = lista_paquetes;
    }

    public void agregarPaquete(PaqueteTuristico paquete) {
	this.lista_paquetes.add(paquete);
    }

    public void quitarPaquete(PaqueteTuristico paquete) {
	this.lista_paquetes.remove(paquete);
    }

    public void deshabilitarServicioTuristico() {
	this.habilitado = false;
    }

    @Override
    public String toString() {
	return "ServicioTuristico{" + "codigo_servicio=" + cod_servicio + ", nombre=" + nombre + ", descripcion=" + descripcion + ", destino_servicio=" + destino_servicio + ", fecha_servicio=" + fecha_servicio + ", costo_servicio=" + costo_servicio + ", habilitado=" + habilitado + '}';
    }

}
