package main;

import java.util.Scanner;

/**
 * Clase Engine. Bucle de la aplicación.
 * @author crisuroll
 */
public class Engine {
	/**
	 * Atributos.
	 */
	private ByteCodeProgram program;
	private boolean end;
	private Command cmd;
	private CPU cpu;
	Scanner sc;
	private String entrada;
	
	/**
	 * Constructora.
	 */
	public Engine() {
		this.program = new ByteCodeProgram();
		this.end = false;
		this.cmd = new Command(ENUM_COMMAND.HELP);
		this.cpu = new CPU();
		this.sc = new Scanner(System.in);
		this.entrada = " ";
	}
	
	/**
	 * Metodo help. Muestra informacion sobre los distintos comandos disponibles.
	 * @return true si se ha ejecutado; false en caso contrario.
	 */
	public boolean help() {
		System.out.println("	HELP: Muestra esta ayuda\n"
				+ "	QUIT: Cierra la aplicación\n"
				+ "	RUN: Ejecuta el programa\n"
				+ "	NEWINST BYTECODE: Introduce una nueva instrucción al programa\n"
				+ "	RESET: Vacía el programa actual\n"
				+ "	REPLACE N: Reemplaza la instrucción N por la solicitada al usuario\n");
		return true;
	}
	
	/**
	 * Metodo quit. Cierra la aplicacion.
	 * @return true si se ha ejecutado; false en caso contrario.
	 */
	public boolean quit() {
		System.out.println(this.program.toString() + "\n\nFin de la ejecución...");
		this.end = true;
		return true;
	}
	
	/**
	 * Metodo run. Ejecuta el programa.
	 * @return true si se ha ejecutado; false en caso contrario.
	 */
	public boolean run() {
		System.out.println(this.program.runProgram(this.cpu) + this.program.toString());
		return true;
	}
	
	/**
	 * Metodo newinst. Introduce una nueva instrucción al programa.
	 * @param bc
	 * @return true si se ha ejecutado; false en caso contrario.
	 */
	public boolean newinst(ByteCode _bc) {
		if (_bc != null) {
			this.program.setInstr(_bc);
			System.out.println(this.program.toString());
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo reset. Vacía el programa actual.
	 * @param n
	 * @return true si se ha ejecutado; false en caso contrario.
	 */
	public boolean reset() {
		this.program.resetProgram();
		return true;
	}
	
	/**
	 * Metodo replace. Reemplaza la instrucción N por la solicitada al usuario.
	 * @param n
	 * @return true si se ha ejecutado; false en caso contrario.
	 */
	public boolean replace(int n) {
		if (n < this.program.length() && n >= 0) {
			System.out.print("Nueva instruccion: ");
			ByteCode bc = ByteCodeParser.parse(this.sc.nextLine());
			if (bc != null) {
				this.program.setInstrPos(bc, n);
				System.out.println(this.program.toString());			
				return true;		
			}
		}
		return false;
	}
	
	/**
	 * Metodo start(). Se encarga de toda la ejecucion de la maquina virtual.
	 */
	public void start() {
		System.out.println("Comienza el programa VIRTUAL MACHINE\r\n");
		help();
		do {
			this.entrada = this.sc.nextLine();
			this.cmd = CommandParser.parse(this.entrada);
			if (this.cmd != null) {
				if (this.cmd.getByteCode() != null) {
					System.out.println("Comienza la ejecución de " + this.cmd.getCommand() + " " + this.cmd.getByteCode());
				} else {
					System.out.println("Comienza la ejecución de " + this.cmd.getCommand());
				}
				if (!this.cmd.execute(this)) {
					System.err.println("Error: Ejecución incorrecta del comando.\r\n");
				}
			} else {
				System.err.println("Error: Comando incorrecto.\r\n");
			}
		} while (!this.end); 
	}
	
}
