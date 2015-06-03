package JPAyGIT.com.genericDAO;


/*
 * Interfaz que extiende a la interfaz Serializable.
 * Recibe un par�metro gen�rico.
 * Define un m�todo llamado getKey() que devuelve un tipo gen�rico.
 * 
 * Cada clase de entidad de nuestro dominio debe implementar
 * esta interfaz. Por ejemplo, para Alumno quedar�a as�:
 * public class Alumno implements IPersistent<Integer> {
 */

import java.io.Serializable;

public interface IPersistent<T> extends Serializable {

	public T getKey();

}