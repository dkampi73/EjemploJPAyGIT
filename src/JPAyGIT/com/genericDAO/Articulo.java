package JPAyGIT.com.genericDAO;


import java.io.Serializable;

import javax.persistence.*;

import org.apache.struts.action.ActionForm;


import java.util.List;


@Entity
@Table(name="articulos")
@NamedQuery(name="Articulo.findAll", query="SELECT a FROM Articulo a")
public class Articulo extends ActionForm implements Serializable, IPersistent<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_articulo")
	private int idArticulo;

	private String categoria;

	private String descripcion;

	private String imagen;

	private String nombre;
	
	private String novedad;

	private double precio;

	private int stock;

	@Column(name="tipo_de_producto")
	private String tipoDeProducto;

	//bi-directional many-to-one association to Lineaspedido
	@OneToMany(mappedBy="articulo")
	private List<Lineaspedido> lineaspedidos;

	public Articulo() {
	}

	public int getIdArticulo() {
		return this.idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getTipoDeProducto() {
		return this.tipoDeProducto;
	}

	public void setTipoDeProducto(String tipoDeProducto) {
		this.tipoDeProducto = tipoDeProducto;
	}

	public List<Lineaspedido> getLineaspedidos() {
		return this.lineaspedidos;
	}

	public void setLineaspedidos(List<Lineaspedido> lineaspedidos) {
		this.lineaspedidos = lineaspedidos;
	}

	public Lineaspedido addLineaspedido(Lineaspedido lineaspedido) {
		getLineaspedidos().add(lineaspedido);
		lineaspedido.setArticulo(this);

		return lineaspedido;
	}

	public Lineaspedido removeLineaspedido(Lineaspedido lineaspedido) {
		getLineaspedidos().remove(lineaspedido);
		lineaspedido.setArticulo(null);

		return lineaspedido;
	}

	public void setNovedad(String novedad) {
		
		this.novedad=novedad;
	}
	public String getNovedad( ) {
		
		return novedad;
	}

	@Override
	public Integer getKey() {		
		return this.idArticulo;
	}

}