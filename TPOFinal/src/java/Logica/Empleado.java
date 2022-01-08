package Logica;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity (name="empleados")
@PrimaryKeyJoinColumn(referencedColumnName="id_persona")
public class Empleado extends Persona {
    @Basic
    private String cargo;
    private double sueldo;
    @OneToOne
    private Usuario usuario;

    public Empleado() {
    }

    public Empleado(String cargo, double sueldo, Usuario usuario, int id_persona, String nombre, String apellido, String direccion, String dni, String fecha_nac, String nacionalidad, String celular, String email) {
	super(id_persona, nombre, apellido, direccion, dni, fecha_nac, nacionalidad, celular, email);
	this.cargo = cargo;
	this.sueldo = sueldo;
	this.usuario = usuario;
    }

    public String getCargo() {
	return cargo;
    }

    public void setCargo(String cargo) {
	this.cargo = cargo;
    }

    public double getSueldo() {
	return sueldo;
    }

    public void setSueldo(double sueldo) {
	this.sueldo = sueldo;
    }

    public Usuario getUsuario() {
	return usuario;
    }

    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }

    @Override
    public String toString() {
	return "Empleado{" + this.toStringP() + ", cargo=" + cargo + ", sueldo=" + sueldo + "}";
    }

}
