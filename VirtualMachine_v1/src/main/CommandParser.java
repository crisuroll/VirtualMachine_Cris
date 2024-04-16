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
		Integer _value = Integer.parseInt(cadena[1]);
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
			case "newinst":
				if (_value != null) {
					cmd = new Command(ENUM_COMMAND.NEWINST, _value);
				} else {
					System.out.println("Error. Argumento no válido.");// REVISAR
				}
			break;
			case "reset":
				if (_value != null) {
					cmd = new Command(ENUM_COMMAND.RESET, _value);
				} else {
					System.out.println("Error. Argumento no válido.");// REVISAR
				}
			break;
			case "replace":
				if (_value != null) {
					cmd = new Command(ENUM_COMMAND.REPLACE, _value);
				} else {
					System.out.println("Error. Argumento no válido.");// REVISAR
				}
			break;
			}
		} else {
			System.out.println("Error. Comando no válido.");
		}

		return cmd;
	}
}
