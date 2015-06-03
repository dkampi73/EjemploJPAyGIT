package JPAyGIT.com.genericDAO;

import java.io.Serializable;

import javax.persistence.*;



/**
 * The persistent class for the lineaspedido database table.
 * 
 */
@Entity
@NamedQuery(name="Lineaspedido.findAll", query="SELECT l FROM Lineaspedido l")
public class Lineaspedido implements Serializable, IPersistent<LineaspedidoPK> {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LineaspedidoPK id;

	private int cantidad;

	private double precio;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="id_pedido")
	private Pedido pedido;

	//bi-directional many-to-one association to Articulo
	@ManyToOne
	@JoinColumn(name="id_articulo")
	private Articulo articulo;

	public Lineaspedido() {
	}

	public LineaspedidoPK getId() {
		return this.id;
	}

	public void setId(LineaspedidoPK id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Articulo getArticulo() {
		return this.articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	@Override
	public LineaspedidoPK getKey() {
		return this.id;
	}
	
}