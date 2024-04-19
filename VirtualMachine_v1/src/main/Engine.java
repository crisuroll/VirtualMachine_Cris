package main;

import java.util.Scanner;

/**
 * Clase Engine. Bucle de la aplicación.
 * @author crisuroll
 */
public class Engine {
	private ByteCodeProgram program;
	private boolean end;
	
	Command cmd = new Command(ENUM_COMMAND.HELP);
	CommandParser cmdp = new CommandParser();
	Scanner sc = new Scanner(System.in);
	String op = " ";
	
	/**
	 * Metodo start().
	 */
	public void start() {
		System.out.println("Comienza el programa VIRTUAL MACHINE\r\n");
		do {
			this.cmd.execute(this);	
			this.cmd = CommandParser.parse(this.sc.nextLine());
			
		} while (this.cmd.getCommand()!= ENUM_COMMAND.QUIT); 
	}
	
}
