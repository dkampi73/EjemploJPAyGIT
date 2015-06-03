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
		
		
		// 1�Operaci�n: Listado de todos los art�culos presentes en la base de datos: listAll()
		// 2�Operaci�n: B�squeda de un art�culo en concreto en la base de datos: findByKey()
		// 3�Operaci�n: Creaci�n de un nuevo art�culo: save()
		// 4�Operaci�n: Modificaci�n art�culo: update()
		// 5�Operaci�n: Borrado de un art�culo: delete()

		// 1�Operaci�n: Listado de todos los art�culos presentes en la base de datos: listAll()		
				
		List<Articulo> articulos = new ArrayList<Articulo>();
		
		articulos = articuloDAO.listAll(Articulo.class);

		for (Articulo a : articulos){
			System.out.println(a.getNombre());
			System.out.println(a.getCategoria());
		}
		
		
		// 2�Operaci�n: B�squeda de un art�culo en concreto en la base de datos: findByKey()
		articulo = new Articulo();
		articulo.setIdArticulo(5);
		articulo.setCategoria("Series2");
		articulo.setTipoDeProducto("Ropa");
		articulo.setDescripcion("Camiseta Breaking Bad");
		articulo.setPrecio(20.5);
		articulo.setStock(10);
		articulo.setNombre("Camiseta Breaking Bad");
		
		
		//Si el objeto no est� en la BD, devuelve NULL 
		//Si el objeto est� en la BD, devuelve el objeto
		//La b�squeda se realiza por el ID de clase Integer, en este caso
		System.out.println(articuloDAO.findByKey(articulo, Integer.class));
		
		
		// 3�Operaci�n: Creaci�n de un nuevo art�culo: save()
		// Grabo el articulo con Id=5 y vuelvo a ejecutar el metodo listAll para comprobar qeu est� en la BD
		
		// La primera vez funciona la inserci�n: despu�s la comentamos para que no d� una excepci�n		
		articuloDAO.save(articulo);
		
		articulos = articuloDAO.listAll(Articulo.class);

		for (Articulo a : articulos){
			System.out.println(a.getIdArticulo());
			System.out.println(a.getNombre());
			System.out.println(a.getPrecio());
		}
				
		// 4�Operaci�n: Modificaci�n art�culo: update()
		articulo.setPrecio(80.0);
		articuloDAO.update(articulo);
		articulos = articuloDAO.listAll(Articulo.class);

		for (Articulo a : articulos){
			System.out.println(a.getIdArticulo());
			System.out.println(a.getNombre());
			System.out.println(a.getPrecio());
		}
		
		// 5�Operaci�n: Borrado de un art�culo: delete()
		articuloDAO.delete(articulo);
		articulos = articuloDAO.listAll(Articulo.class);

		for (Articulo a : articulos){
			System.out.println(a.getIdArticulo());
			System.out.println(a.getNombre());
			System.out.println(a.getPrecio());
		}

		

	}}

