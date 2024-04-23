package main;

import java.util.Scanner;

/**
 * Clase Engine. Bucle de la aplicación.
 * @author crisuroll
 */
public class Engine {
	private ByteCodeProgram program = new ByteCodeProgram();
	private boolean end;
	private Command cmd = new Command(ENUM_COMMAND.HELP);
	private ByteCode bc = new ByteCode();
	
	Scanner sc = new Scanner(System.in);
	String op = " ";
	
	/**
	 * Metodo start().
	 */
	public void start() {
		System.out.println("Comienza el programa VIRTUAL MACHINE\r\n");
		String text = "";
		do {
			this.cmd.execute(this);
			if (this.cmd.getCommand() != ENUM_COMMAND.HELP) {
				this.program.setInstr(ByteCodeParser.parse(text.split(" ")[1] + " " + text.split(" ")[2]));
				// ME QUEDA AVERIGUAR COMO ALMACENAR PROGRAM
				System.out.println(this.program.toString());		
			}
			text = this.sc.nextLine();
			this.cmd = CommandParser.parse(text);
		} while (this.cmd.getCommand()!= ENUM_COMMAND.QUIT); 
	}
	
}
