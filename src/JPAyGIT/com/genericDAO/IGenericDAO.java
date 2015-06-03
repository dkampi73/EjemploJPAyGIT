package JPAyGIT.com.genericDAO;


import java.util.List;

/*
 * Es interfaz define los métodos CRUD, recibiendo par ello como 
 * argumento el tipo de la clase POJO.
 * 
 * La interfaz toma dos parámetros genéricos. El primero es el tipo 
 * de la clave primaria del POJO JPA. El segundo es el POJO en sí mismo.
 * 
 * Esta sintaxis fuerza a que el POJO destino tenga que implementar
 * la interfaz IPersistent usando el tipo K. 
 */

public interface IGenericDAO<K,T extends IPersistent<K>> {
	List<T> listAll(final Class<T> clase);
	T save(T object);
	T findByKey(T object, Class<K> key);
	T update(T object);
	boolean delete(T object);
}