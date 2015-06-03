package JPAyGIT.com.genericDAO;


/*
 * Interfaz que extiende a la interfaz Serializable.
 * Recibe un parámetro genérico.
 * Define un método llamado getKey() que devuelve un tipo genérico.
 * 
 * Cada clase de entidad de nuestro dominio debe implementar
 * esta interfaz. Por ejemplo, para Alumno quedaría así:
 * public class Alumno implements IPersistent<Integer> {
 */

import java.io.Serializable;

public interface IPersistent<T> extends Serializable {

	public T getKey();

}