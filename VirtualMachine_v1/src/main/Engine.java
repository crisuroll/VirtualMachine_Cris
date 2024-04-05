package main;

/**
 * Clase Engine. Bucle de la aplicación.
 * @author crisuroll
 */
public class Engine {
	
	// -----------------------------------------PRUEBAS----------------------------------------------\\
	public void menu() {
		System.out.println("HELP: Muestra esta ayuda\r\n"
				+ "QUIT: Cierra la aplicación\r\n"
				+ "RUN: Ejecuta el programa\r\n"
				+ "NEWINST BYTECODE: Introduce una nueva instrucción al metaprograma\r\n"
				+ "RESET: Vacía el programa actual\r\n"
				+ "REPLACE N: Reemplaza la instrucción N por la solicitada al usuario\r\n");
	}
	
	public void start() {
		System.out.println("Comienza el programa VIRTUAL MACHINE\r\n"
				+ "Escriba HELP para mostrar la ayuda.");
		OperandStack owo = new OperandStack();
		System.out.println(owo.isEmpty());
		owo.push(2);
		owo.push(3);
		Memory uwu = new Memory();
		uwu.write(1, 2);
		uwu.write(2, 3);
		uwu.resize();
		uwu.write(3, 4);
		//System.out.println(owo.isEmpty());
		//System.out.println(owo.getCima());
		owo.toString();
		owo.pop();
		owo.toString();
		System.out.println(owo.toString());
		System.out.println(uwu.toString());
	}
	

	
}
