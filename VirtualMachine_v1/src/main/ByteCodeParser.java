package main;

/**
 * Clase ByteCodeParser.
 */
public class ByteCodeParser {
	/**
	 * Metodo parse. Se encarga de analizar el parametro line y generar a partir de el un comando.
	 * @param line es la instruccion bytecode dado por el usuario.
	 * @return s si la instruccion existe; null en caso contrario. 
	 */
	public static ByteCode parse(String s) {
		ByteCode bc = null;
		String[] cadena = s.toLowerCase().split(" ");
		Integer _value = Integer.parseInt(cadena[1]);
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
				if (_value != null) {
					bc = new ByteCode(ENUM_BYTECODE.PUSH, _value);
				} else {
					System.out.println("Error. Argumento no válido.");// REVISAR
				}
			break;
			case "load":
				if (_value != null) {
					bc = new ByteCode(ENUM_BYTECODE.LOAD, _value);
				} else {
					System.out.println("Error. Argumento no válido.");// REVISAR
				}
			break;
			case "store":
				if (_value != null) {
					bc = new ByteCode(ENUM_BYTECODE.STORE, _value);
				} else {
					System.out.println("Error. Argumento no válido.");// REVISAR
				}
			break;
			}
		} else {
			System.out.println("Error. Bytecode no válido.");
		}

		return bc;
	}
}
