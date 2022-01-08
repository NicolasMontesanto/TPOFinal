package Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity (name = "usuarios")

public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_usuario;
    @Column(name = "NOMBRE_USUARIO", unique = true)
    private String nombre_usuario;
    private String contrasenia;
    private boolean habilitado = true;
    @OneToMany
    private List<Venta> lista_ventas;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre_usuario, String contrasenia) {
	this.id_usuario = id_usuario;
	this.nombre_usuario = nombre_usuario;
	this.contrasenia = contrasenia;
    }

    public int getId_usuario() {
	return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
	this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
	return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
	this.nombre_usuario = nombre_usuario;
    }

    public String getContrasenia() {
	return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
	this.contrasenia = contrasenia;
    }

    public boolean isHabilitado() {
	return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
	this.habilitado = habilitado;
    }

    public void deshabilitarUsuario() {
	this.habilitado = false;
    }

    public List<Venta> getLista_ventas() {
	return lista_ventas;
    }

    public void setLista_ventas(List<Venta> lista_ventas) {
	this.lista_ventas = lista_ventas;
    }

    public void agregarVenta(Venta venta) {
	this.lista_ventas.add(venta);
    }
    
    public void quitarVenta(Venta venta){
	this.lista_ventas.remove(venta);
    }

    @Override
    public String toString() {
	return "Usuario{" + "id_usuario=" + id_usuario + ", nombre_usuario=" + nombre_usuario + ", contrasenia=" + contrasenia + '}';
    }

}
