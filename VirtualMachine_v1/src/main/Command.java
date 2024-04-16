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
	
	public void help() {
		this.command = ENUM_COMMAND.HELP;
	}
	
	public void quit() {
		this.command = ENUM_COMMAND.QUIT;
	}
	
	public void run() {
		this.command = ENUM_COMMAND.RUN;
	}
	
	public void newinst(ByteCode bc) {
		this.command = ENUM_COMMAND.NEWINST;
	}
	
	public void reset(int n) {
		this.command = ENUM_COMMAND.RESET;
	}
	
	public void replace(int n) {
		this.command = ENUM_COMMAND.REPLACE;
	}
	
	/**
	 * Metodo execute. Se encarga de ejecutar el comando, dando la orden correspondiente a engine.
	 * @param engine siendo el bucle de la aplicacion. 
	 * @return exc siendo true si se ejecuta, false si da error.
	 */
	public boolean execute(Engine engine) {
		boolean exc = false;
		ENUM_COMMAND op = ENUM_COMMAND.HELP;
		switch (op) {
			case HELP:
				System.out.println("Comienza la ejecución de HELP\n");
				System.out.println("\n	HELP: Muestra esta ayuda\n"
						+ "	QUIT: Cierra la aplicación\n"
						+ "	RUN: Ejecuta el programa\n"
						+ "	NEWINST BYTECODE: Introduce una nueva instrucción al programa\n"
						+ "	RESET: Vacía el programa actual\n"
						+ "	REPLACE N: Reemplaza la instrucción N por la solicitada al usuario\n");
			break;
			case QUIT:
				System.out.println("Comienza la ejecución de QUIT\n");
				System.out.println("\nFin de la ejecución...");
			break;
			case NEWINST:
			break;
			case RUN:
			break;
			case RESET:
			break;
			case REPLACE:
			break;
		}
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
