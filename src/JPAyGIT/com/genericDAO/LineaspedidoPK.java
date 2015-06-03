package JPAyGIT.com.genericDAO;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the lineaspedido database table.
 * 
 */
@Embeddable
public class LineaspedidoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_pedido", insertable=false, updatable=false)
	private int idPedido;

	@Column(name="id_articulo", insertable=false, updatable=false)
	private int idArticulo;

	public LineaspedidoPK() {
	}
	
	public LineaspedidoPK(int articulo, int pedido) {
		this.idArticulo = articulo;
		this.idPedido = pedido;
	}
	public int getIdPedido() {
		return this.idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getIdArticulo() {
		return this.idArticulo;
	}
	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LineaspedidoPK)) {
			return false;
		}
		LineaspedidoPK castOther = (LineaspedidoPK)other;
		return 
			(this.idPedido == castOther.idPedido)
			&& (this.idArticulo == castOther.idArticulo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPedido;
		hash = hash * prime + this.idArticulo;
		
		return hash;
	}
	
	public LineaspedidoPK getKey(){
		
		return this;
		
	}
}