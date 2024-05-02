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
	
	// Estos los he creado yo
	private boolean exc = false;
	
	// private CPU cpu;
	
	/**
	 * Constructora.
	 */	
	/*
	public Command(ByteCode _instruction) {
		this.instruction = _instruction;
	}*/
	
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
		ENUM_COMMAND op = this.command;
		//this.cpu = new CPU(this.instruction);
		if (this.instruction != null) {
			System.out.println("Comienza la ejecución de " + this.command + " " + this.instruction + "\n");
		} else {
			System.out.println("Comienza la ejecución de " + this.command + "\n");	
		}
		switch (op) {
			case HELP:
				if (_engine.help()) {
					this.exc = true;
				}
			break;
			case QUIT:
				if (_engine.quit()) {
					this.exc = true;
				}
			break;
			case NEWINST:
				if (_engine.newinst(this.instruction)) {
					this.exc = true;
				}
			break;
			case RUN:
				if (_engine.run()) {
					this.exc = true;
				}
			break;
			case RESET:
				if (_engine.reset()) {
					this.exc = true;
				}
			break;
			case REPLACE:
				if (_engine.replace(this.replace)) {
					this.exc = true;
				}
			break;
		}
		return this.exc;
	}
	
}
