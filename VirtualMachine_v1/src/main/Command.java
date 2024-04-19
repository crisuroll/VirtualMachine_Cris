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
	private boolean exc = false;
	
	/**
	 * Constructora.
	 */	
	public Command() {
		
	}
	
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
	
	public ENUM_COMMAND getCommand() {
		return this.command;
	}
	
	public boolean help() {
		this.command = ENUM_COMMAND.HELP;
		System.out.println("Comienza la ejecución de HELP\n");
		System.out.println("\n	HELP: Muestra esta ayuda\n"
				+ "	QUIT: Cierra la aplicación\n"
				+ "	RUN: Ejecuta el programa\n"
				+ "	NEWINST BYTECODE: Introduce una nueva instrucción al programa\n"
				+ "	RESET: Vacía el programa actual\n"
				+ "	REPLACE N: Reemplaza la instrucción N por la solicitada al usuario\n");
		return true;
	}
	
	public boolean quit() {
		this.command = ENUM_COMMAND.QUIT;
		System.out.println("Comienza la ejecución de QUIT\n"
				+ "Programa almacenado:\n"
				+ "Fin de la ejecución...");
		return true;
	}
	
	public boolean run() {
		this.command = ENUM_COMMAND.RUN;
		return true;
	}
	
	public boolean newinst(ByteCode bc) {
		this.command = ENUM_COMMAND.NEWINST;
		System.out.println("Comienza la ejecución de NEWINST " );
		return true;
	}
	
	public boolean reset(int n) {
		this.command = ENUM_COMMAND.RESET;
		return true;
	}
	
	public boolean replace(int n) {
		this.command = ENUM_COMMAND.REPLACE;
		return true;
	}
	
	/**
	 * Metodo execute. Se encarga de ejecutar el comando, dando la orden correspondiente a engine.
	 * @param engine siendo el bucle de la aplicacion. 
	 * @return exc siendo true si se ejecuta, false si da error.
	 */
	public boolean execute(Engine engine) {
		ENUM_COMMAND op = this.command;
		switch (op) {
			case HELP:
				if (help()) {
					this.exc = true;
				}
			break;
			case QUIT:
				if (quit()) {
					this.exc = true;
				}
			break;
			case NEWINST:
				if (newinst(this.instruction)) {
					this.exc = true;
				}
			break;
			case RUN:
				if (run()) {
					this.exc = true;
				}
			break;
			case RESET:
				if (reset(this.replace)) {
					this.exc = true;
				}
			break;
			case REPLACE:
				if (replace(this.replace)) {
					this.exc = true;
				}
			break;
		}
		return this.exc;
	}
	
}
