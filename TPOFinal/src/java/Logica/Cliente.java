package Logica;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity (name="clientes")
@PrimaryKeyJoinColumn(referencedColumnName="id_persona")
public class Cliente extends Persona {
    @OneToMany
    private List<Venta> lista_ventas;

    public Cliente() {
    }

    public Cliente(int id_persona, String nombre, String apellido, String direccion, String dni, String fecha_nac, String nacionalidad, String celular, String email) {
	super(id_persona, nombre, apellido, direccion, dni, fecha_nac, nacionalidad, celular, email);
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

    public void quitarVenta(Venta venta) {
	this.lista_ventas.remove(venta);
    }

    @Override
    public String toString() {
	return "Cliente{" + this.toStringP() + '}';
    }
}
