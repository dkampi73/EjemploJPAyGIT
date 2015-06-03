package JPAyGIT.com.genericDAO;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pedidos database table.
 * 
 */
@Entity
@Table(name="pedidos")
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable, IPersistent<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pedido")
	private int idPedido;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="id_cliente")
	private int idCliente;

	@Column(name="total_a_pagar")
	private double totalAPagar;

	//bi-directional many-to-one association to Lineaspedido
	@OneToMany(mappedBy="pedido")
	private List<Lineaspedido> lineaspedidos;

	public Pedido() {
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public double getTotalAPagar() {
		return this.totalAPagar;
	}

	public void setTotalAPagar(double totalAPagar) {
		this.totalAPagar = totalAPagar;
	}

	public List<Lineaspedido> getLineaspedidos() {
		return this.lineaspedidos;
	}

	public void setLineaspedidos(List<Lineaspedido> lineaspedidos) {
		this.lineaspedidos = lineaspedidos;
	}

	public Lineaspedido addLineaspedido(Lineaspedido lineaspedido) {
		getLineaspedidos().add(lineaspedido);
		lineaspedido.setPedido(this);

		return lineaspedido;
	}

	public Lineaspedido removeLineaspedido(Lineaspedido lineaspedido) {
		getLineaspedidos().remove(lineaspedido);
		lineaspedido.setPedido(null);

		return lineaspedido;
	}

	@Override
	public Integer getKey() {
		return this.idPedido;
	}

}