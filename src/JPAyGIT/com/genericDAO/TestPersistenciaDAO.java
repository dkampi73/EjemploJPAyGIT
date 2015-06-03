package JPAyGIT.com.genericDAO;


import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;



public class TestPersistenciaDAO {

	//private final static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	private final static Logger log = Logger.getLogger(TestPersistenciaDAO.class);

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		PropertyConfigurator.configure("log4j.properties");

		Articulo articulo = null;
		Pedido pedido = null;
		Lineaspedido lpedido = null;

		/*
		 * Definicion de los DAO genéricos: toda su implementacion la heredan de
		 * gendao.GenericDAO
		 */ 

		
		IGenericDAO<Integer, Articulo> articuloDAO = new GenericDAO<Integer,Articulo>();					

		IGenericDAO<Integer, Pedido> pedidoDAO = new GenericDAO<Integer,Pedido>();

		IGenericDAO<LineaspedidoPK, Lineaspedido> lpedidoDAO = new GenericDAO<LineaspedidoPK, Lineaspedido>();

		/*
		 * OPERACIONES CON articuloS
		 */

		// DAO customizado para especificar un servicio no genérico
	//	IarticuloDAO articuloCustomDAO = (IarticuloDAO) context.getBean("articuloCustomDAO");

		/*
		 * Buscamos articulos que aun no hayan entregado la foto
		 */

//		if (log.isDebugEnabled())
//			log.debug("Mostrando articulos que aun no han entregado la foto...");
//
//		ArrayList<articulo> articulosSinFoto = new ArrayList<articulo>(
//				articuloCustomDAO
//						.findByOtherCriteria("SELECT a FROM articulo a WHERE a.foto IS NULL"));
//
//		for (articulo a : articulosSinFoto)
//			System.out.println(a);

		/*
		 * Creamos un articulo, lo grabamos y lo mostramos por pantalla
		 */
		articulo = new Articulo();
		articulo.setIdArticulo(4);
		articulo.setCategoria("Series");
		articulo.setTipoDeProducto("Ropa");
		articulo.setDescripcion("Camiseta Breaking Bad");
		articulo.setPrecio(20.5);
		articulo.setStock(10);
		articulo.setNombre("Camiseta Breaking Bad");
				
		List<Articulo> articulos = new ArrayList<Articulo>();
		
		articulos = articuloDAO.listAll(Articulo.class);

		// Solo grabamos si primero no lo encontramos en la bd
		if (articuloDAO.findByKey(articulo, Integer.class) == null) {
			if (articuloDAO.save(articulo) != null) {
				if (log.isDebugEnabled())
					log.debug("Articulo grabado: " + articulo);
			} else {
				if (log.isDebugEnabled())
					log.debug("No se puede grabar al articulo: " + articulo);
			}
		} else {
			if (log.isDebugEnabled())
				log.debug("No se puede grabar al articulo: " + articulo);
		}

		/*
		 * Queremos buscar un articulo en la base de datos. Desreferenciamos la
		 * variable que apunta al articulo que grabamos anteriormente y la
		 * aprovechamos para referenciar al articulo que nos retorna el método
		 * findByKey()
		 */
		articulo = null;
		Articulo articulo2 = new Articulo();
		articulo2.setIdArticulo(4);
		articulo = articuloDAO.findByKey(articulo2, Integer.class);

		/*
		 * Comprobamos que efectivamente se ha podido recuperar el Articulo que
		 * buscábamos
		 */
		if (articulo != null) {
			if (log.isDebugEnabled())
				log.debug("articulo encontrado: " + articulo);
		} else {
			if (log.isDebugEnabled())
				log.debug("No se ha encontrado al articulo especificado");
		}

		// Dejamos a la variable apuntado al articulo creado
		// para poder lpedidorlo posteriormente
		articulo = articuloDAO.findByKey(articulo2, Integer.class);

		/*
		 * OPERACIONES CON CURSOS
		 */

		/*
		 * Creamos un pedido, lo grabamos y lo mostramos por pantalla
		 */
		pedido = new Pedido();
		pedido.setIdPedido(4);
		pedido.setIdCliente(3);
		
		// Solo grabamos si primero no lo encontramos en la bd
		if (pedidoDAO.findByKey(pedido, Integer.class ) == null) {
			if (pedidoDAO.save(pedido) != null) {
				if (log.isDebugEnabled())
					log.debug("Pedido grabado: " + pedido);
			} else {
				if (log.isDebugEnabled())
					log.debug("No se puede grabar al pedido: " + pedido);
			}
		} else {
			if (log.isDebugEnabled())
				log.debug("No se puede grabar al pedido: " + pedido);
		}
		
		List<Pedido> pedidos = new ArrayList<Pedido>();		
		
		pedidos = pedidoDAO.listAll(Pedido.class);
		/*
		 * OPERACIONES CON LINEASPEDIDO
		 */

		/*
		 * Mostramos todas las matrículas
		 */

		if (log.isDebugEnabled())
			log.debug("Mostrando todas las lpedidos...");

		ArrayList<Lineaspedido> lpedidos = new ArrayList<Lineaspedido>(
				lpedidoDAO.listAll(Lineaspedido.class));

		for (Lineaspedido m : lpedidos)
			System.out.println(m);

		/*
		 * Creamos una lpedido, la grabamos y la mostramos por pantalla
		 */
		lpedido = new Lineaspedido();
		lpedido.setArticulo(articulo);
		lpedido.setPedido(pedido);
		lpedido.setId(new LineaspedidoPK(articulo.getIdArticulo(), pedido.getIdPedido()));
		lpedido.setPrecio(300d);
		
		// Si la lpedido existe en la base de datos...la eliminamos
		if (lpedidoDAO.findByKey(lpedido, LineaspedidoPK.class) != null) {
			lpedidoDAO.delete(lpedido);
		}

		if (lpedidoDAO.save(lpedido) != null) {
			if (log.isDebugEnabled())
				log.debug("Lineaspedido grabada: " + lpedido);
		} else {
			if (log.isDebugEnabled())
				log.debug("No se puede grabar la lpedido: " + lpedido);
		}

		if (log.isDebugEnabled())
			log.debug("Programa finalizado");
		
	
	
	for (Articulo a : articulos){
		System.out.println(a.getNombre());
	}
	for (Pedido p : pedidos){
		System.out.println(p.getTotalAPagar());
	}

	}
}
