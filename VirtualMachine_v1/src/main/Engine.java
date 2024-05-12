package main;

import java.util.Scanner;

/**
 * Clase Engine. Bucle de la aplicación.
 * @author crisuroll
 */
public class Engine {
	private ByteCodeProgram program = new ByteCodeProgram();
	private boolean end = false;
	private Command cmd = new Command(ENUM_COMMAND.HELP);
	private CPU cpu = new CPU();
	Scanner sc = new Scanner(System.in);
	
	private String entrada = " ";
	
	/**
	 * Metodo help.
	 * @return
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
	 * Metodo quit.
	 * @return
	 */
	public boolean quit() {
		System.out.println(this.program.toString() + "\n\nFin de la ejecución...");
		this.end = true;
		return true;
	}
	
	/**
	 * Metodo run.
	 * @return
	 */
	public boolean run() {
		System.out.println(this.program.runProgram(this.cpu) + this.program.toString());
		return true;
	}
	
	/**
	 * Metodo newinst.
	 * @param bc
	 * @return
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
	 * Metodo reset.
	 * @param n
	 * @return
	 */
	public boolean reset() {
		this.program.resetProgram();
		return true;
	}
	
	/**
	 * Metodo replace.
	 * @param n
	 * @return
	 */
	public boolean replace(int n) {
		if (n < this.program.length()) {
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
	 * Metodo start().
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
