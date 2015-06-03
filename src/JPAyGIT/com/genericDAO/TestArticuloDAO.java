package JPAyGIT.com.genericDAO;


import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;



public class TestArticuloDAO {

	//private final static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	private final static Logger log = Logger.getLogger(TestArticuloDAO.class);

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		PropertyConfigurator.configure("log4j.properties");

		Articulo articulo = null;
		
		/*
		 * 1er PASO: Definir un articuloDAO creando una instancia de la clase GenericDAO 
		 * 
		 */ 
		
		IGenericDAO<Integer, Articulo> articuloDAO = new GenericDAO<Integer,Articulo>();					

		
		/*
		 * OPERACIONES CON articuloS
		 */
		
		
		// 1ªOperación: Listado de todos los artículos presentes en la base de datos: listAll()
		// 2ªOperación: Búsqueda de un artículo en concreto en la base de datos: findByKey()
		// 3ªOperación: Creación de un nuevo artículo: save()
		// 4ªOperación: Modificación artículo: update()
		// 5ªOperación: Borrado de un artículo: delete()

		// 1ªOperación: Listado de todos los artículos presentes en la base de datos: listAll()		
				
		List<Articulo> articulos = new ArrayList<Articulo>();
		
		articulos = articuloDAO.listAll(Articulo.class);

		for (Articulo a : articulos){
			System.out.println(a.getNombre());
			System.out.println(a.getCategoria());
		}
		
		
		// 2ªOperación: Búsqueda de un artículo en concreto en la base de datos: findByKey()
		articulo = new Articulo();
		articulo.setIdArticulo(5);
		articulo.setCategoria("Series2");
		articulo.setTipoDeProducto("Ropa");
		articulo.setDescripcion("Camiseta Breaking Bad");
		articulo.setPrecio(20.5);
		articulo.setStock(10);
		articulo.setNombre("Camiseta Breaking Bad");
		
		
		//Si el objeto no está en la BD, devuelve NULL 
		//Si el objeto está en la BD, devuelve el objeto
		//La búsqueda se realiza por el ID de clase Integer, en este caso
		System.out.println(articuloDAO.findByKey(articulo, Integer.class));
		
		
		// 3ªOperación: Creación de un nuevo artículo: save()
		// Grabo el articulo con Id=5 y vuelvo a ejecutar el metodo listAll para comprobar qeu está en la BD
		
		// La primera vez funciona la inserción: después la comentamos para que no dé una excepción		
		articuloDAO.save(articulo);
		
		articulos = articuloDAO.listAll(Articulo.class);

		for (Articulo a : articulos){
			System.out.println(a.getIdArticulo());
			System.out.println(a.getNombre());
			System.out.println(a.getPrecio());
		}
				
		// 4ªOperación: Modificación artículo: update()
		articulo.setPrecio(80.0);
		articuloDAO.update(articulo);
		articulos = articuloDAO.listAll(Articulo.class);

		for (Articulo a : articulos){
			System.out.println(a.getIdArticulo());
			System.out.println(a.getNombre());
			System.out.println(a.getPrecio());
		}
		
		// 5ªOperación: Borrado de un artículo: delete()
		articuloDAO.delete(articulo);
		articulos = articuloDAO.listAll(Articulo.class);

		for (Articulo a : articulos){
			System.out.println(a.getIdArticulo());
			System.out.println(a.getNombre());
			System.out.println(a.getPrecio());
		}

		

	}}

