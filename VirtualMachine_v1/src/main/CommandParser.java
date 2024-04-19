package main;

/**
 * Clase CommandParser. Convierte el comando del usuario a un comando de tipo Command.
 * @author crisuroll
 */
public class CommandParser {
	
	/**
	 * Metodo parse. Se encarga de analizar el parametro line y generar a partir de el un comando.
	 * @param line es el comando dado por el usuario.
	 * @return Command es el comando de tipo enum.
	 */
	public static Command parse(String line) {
		Command cmd = null;
		String[] cadena = line.toLowerCase().split(" ");
		if (cadena.length == 1) {
			switch (cadena[0]) {
			case "help":
				cmd = new Command(ENUM_COMMAND.HELP);
			break;
			case "quit":
				cmd = new Command(ENUM_COMMAND.QUIT);
			break;
			case "run":
				cmd = new Command(ENUM_COMMAND.RUN);
			break;
			}	
		} else if (cadena.length == 2) {
			switch (cadena[0]) {
			case "reset":
				if (cadena[1] != null) {
					cmd = new Command(ENUM_COMMAND.RESET, Integer.parseInt(cadena[1]));
				} else {
					System.err.println("Error. Argumento no válido.");
				}
			break;
			case "replace":
				if (cadena[1] != null) {
					cmd = new Command(ENUM_COMMAND.REPLACE, Integer.parseInt(cadena[1]));
				} else {
					System.err.println("Error. Argumento no válido.");
				}
			break;
			}
		} else if (cadena.length == 3) {
			switch (cadena[0]) {
			case "newinst":
				if (cadena[1] != null) {
					cmd = new Command(ENUM_COMMAND.NEWINST, ByteCodeParser.parse(cadena[1]+ " " + cadena[2]));
				} else {
					System.err.println("Error. Argumento no válido.");
				}
			break;
			}
		} else {
			System.err.println("Error. Comando no válido.");
		}
		return cmd;
	}
}
