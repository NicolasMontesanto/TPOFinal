package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity (name ="personas")
@Inheritance (strategy= InheritanceType.JOINED)
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_persona;
    @Basic
    private String nombre;
    private String apellido;
    private String direccion;
    private String dni;
    private String fecha_nac;
    private String nacionalidad;
    private String celular;
    private String email;
    private boolean habilitado = true;
    

    public Persona() {
    }

    public Persona(int id_persona, String nombre, String apellido, String direccion, String dni, String fecha_nac, String nacionalidad, String celular, String email) {
	this.id_persona = id_persona;
	this.nombre = nombre;
	this.apellido = apellido;
	this.direccion = direccion;
	this.dni = dni;
	this.fecha_nac = fecha_nac;
	this.nacionalidad = nacionalidad;
	this.celular = celular;
	this.email = email;
    }

    public int getId_persona() {
	return id_persona;
    }

    public void setId_persona(int id_persona) {
	this.id_persona = id_persona;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getApellido() {
	return apellido;
    }

    public void setApellido(String apellido) {
	this.apellido = apellido;
    }

    public String getDireccion() {
	return direccion;
    }

    public void setDireccion(String direccion) {
	this.direccion = direccion;
    }

    public String getDni() {
	return dni;
    }

    public void setDni(String dni) {
	this.dni = dni;
    }

    public String getFecha_nac() {
	return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
	this.fecha_nac = fecha_nac;
    }

    public String getNacionalidad() {
	return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
	this.nacionalidad = nacionalidad;
    }

    public String getCelular() {
	return celular;
    }

    public void setCelular(String celular) {
	this.celular = celular;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String toStringP() {
	return "id_persona=" + id_persona + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", dni=" + dni + ", fecha_nac=" + fecha_nac + ", nacionalidad=" + nacionalidad + ", celular=" + celular + ", email=" + email ;
    }

    public boolean isHabilitado() {
	return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
	this.habilitado = habilitado;
    }
    
    public void deshabilitarPersona(){
	this.habilitado=false;
    }
    

}
