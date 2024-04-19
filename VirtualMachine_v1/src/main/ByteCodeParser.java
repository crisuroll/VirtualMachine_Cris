package main;

/**
 * Clase ByteCodeParser.
 */
public class ByteCodeParser {
	/**
	 * Metodo parse. Se encarga de analizar el parametro s y generar a partir de el un comando.
	 * @param line es la instruccion bytecode dado por el usuario.
	 * @return s si la instruccion existe; null en caso contrario. 
	 */
	public static ByteCode parse(String s) {
		ByteCode bc = null;
		String[] cadena = s.toLowerCase().split(" ");
		if (cadena.length == 1) {
			switch (cadena[0]) {
			case "add":
				bc = new ByteCode(ENUM_BYTECODE.ADD);
			break;
			case "sub":
				bc = new ByteCode(ENUM_BYTECODE.SUB);
			break;
			case "mul":
				bc = new ByteCode(ENUM_BYTECODE.MUL);
			break;
			case "div":
				bc = new ByteCode(ENUM_BYTECODE.DIV);
			break;
			case "out":
				bc = new ByteCode(ENUM_BYTECODE.OUT);
			break;
			case "halt":
				bc = new ByteCode(ENUM_BYTECODE.HALT);
			break;
			}	
		} else if (cadena.length == 2) {
			switch (cadena[0]) {
			case "push":
				if (cadena[1] != null) {
					bc = new ByteCode(ENUM_BYTECODE.PUSH, Integer.parseInt(cadena[1]));
				} else {
					System.err.println("Error. Argumento no válido.");
				}
			break;
			case "load":
				if (cadena[1] != null) {
					bc = new ByteCode(ENUM_BYTECODE.LOAD, Integer.parseInt(cadena[1]));
				} else {
					System.err.println("Error. Argumento no válido.");
				}
			break;
			case "store":
				if (cadena[1] != null) {
					bc = new ByteCode(ENUM_BYTECODE.STORE, Integer.parseInt(cadena[1]));
				} else {
					System.err.println("Error. Argumento no válido.");
				}
			break;
			}
		} else {
			System.err.println("Error. Bytecode no válido.");
		}
		return bc;
	}
}
