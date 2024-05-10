package main;

import java.util.Scanner;

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
	 * Constructora.
	 */	
	public Command(ENUM_COMMAND _command) {
		this.command = _command;
	}
	
	public Command(ENUM_COMMAND _command, int _replace) {
		this.command = _command;
		this.replace = _replace;
	}
	
	public Command(ENUM_COMMAND _command, ByteCode _instruction) {
		this.command = _command;
		this.instruction = _instruction;
	}
	
	/**
	 * Metodo getCommand.
	 * @return
	 */
	public ENUM_COMMAND getCommand() {
		return this.command;
	}
	
	public ByteCode getByteCode() {
		return this.instruction; 
	}
	
	/**
	 * Metodo execute. Se encarga de ejecutar el comando, dando la orden correspondiente a engine.
	 * @param engine siendo el bucle de la aplicacion. 
	 * @return exc siendo true si se ejecuta, false si da error.
	 */
	public boolean execute(Engine _engine) {
		boolean exc = false;
		ENUM_COMMAND op = this.command;
		switch (op) {
			case HELP:
				if (_engine.help()) {
					exc = true;
				}
			break;
			case QUIT:
				if (_engine.quit()) {
					exc = true;
				}
			break;
			case NEWINST:
				if (_engine.newinst(this.instruction)) {
					exc = true;
				}
			break;
			case RUN:
				if (_engine.run()) {
					exc = true;
				}
			break;
			case RESET:
				if (_engine.reset()) {
					exc = true;
				}
			break;
			case REPLACE:
				if (_engine.replace(this.replace)) {
					exc = true;
				}
			break;
		}
		return exc;
	}
	
}
