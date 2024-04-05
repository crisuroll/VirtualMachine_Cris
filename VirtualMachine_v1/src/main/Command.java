package main;

/**
 * Clase Command. Representa los distintos comandos que puede utilizar un usuario.
 * @author crisuroll
 */
public class Command {

	/**
	 * Atributos de la clase Command.
	 */
	private ENUM_COMMAND command;
	private ByteCode instruction;
	private int replace;
	
	/**
	 * Metodo execute. Se encarga de ejecutar el comando, dando la orden correspondiente a engine.
	 * @param engine siendo el bucle de la aplicacion. 
	 * @return exc siendo true si se ejecuta, false si da error.
	 */
	public boolean execute(Engine engine) {
		boolean exc = false;
		/*
		if (){
			exc = true;
		} else {
			exc = false;
		}
		*/
		return exc;
	}
	
}
