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
	private ByteCode bc = new ByteCode(null);
	
	Scanner sc = new Scanner(System.in);
	String op = " ";
	
	/**
	 * Metodo start().
	 */
	public void start() {
		System.out.println("Comienza el programa VIRTUAL MACHINE\r\n");
		String text = "HELP";
		do {
			this.cmd = CommandParser.parse(text);
			this.cmd.execute(this);
			if (this.cmd.getCommand() == ENUM_COMMAND.NEWINST) {
				String[] cadena = text.split(" ");
				if (cadena.length == 2) {
					this.bc = ByteCodeParser.parse(text.split(" ")[1]);
				} else {
					this.bc = ByteCodeParser.parse(text.split(" ")[1] + " " + text.split(" ")[2]);
				}
				this.program.setInstr(bc);
				System.out.println(this.program.toString());		
			}
			text = this.sc.nextLine();
		} while (this.cmd.getCommand()!= ENUM_COMMAND.QUIT); 
	}
	
}
