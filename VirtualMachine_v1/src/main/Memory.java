package main;

/**
 * Clase Memory. Simula la memoria utilizada para el metaprograma.
 * @author crisuroll
 */
public class Memory {

	/**
	 * Atributos de la clase Memory.
	 */
	final private int MAX_MEMORY;
	private Integer[] Memory;
	private int size;
	private boolean empty; // No sé dónde se utiliza xd ya lo se :3

	/**
	 * Constructora de la clase Memory.
	 */
	public Memory() {
		this.MAX_MEMORY = 2;
		this.Memory = new Integer[MAX_MEMORY];
		this.size = 0;
		this.empty = false;
	}

	/**
	 * Metodo toString(). Recibe un array de tipo int y lo convierte en un String.
	 * @param _arr es el array a convertir.
	 * @return str siendo la cadena convertida.
	 */
	public String toString() {
		String str = "";
		if (empty == false) {
			str = " <vacía> ";
		} else {
			for (int i = 0; i < this.Memory.length; i++) {
				if (this.Memory[i] != null) {
					str = str + " [" + i + "] " + this.Memory[i] + " ";			
				}
			}			
		}

		return str;
	}
	
	/**
	 * Metodo write(). Escribe el valor de value en la posicion pos.
	 * @return pos representa la posicion de la memoria.
	 * @param value representa el valor de la posicion proporcionada.
	 * @return value; true si se ha añadido correctamente, false en caso contrario.
	 */
	public boolean write(int _pos, int _value) {
		// value es la cima de la pila
		boolean added = false;
		if (_pos >= 0) {
			if (_pos < this.MAX_MEMORY) {
				this.Memory[_pos] = _value;
				System.out.println("Valor escrito correctamente.");
				this.size++;
				this.empty = true;
				added = true;
			} else {
				System.out.println("Aumentando memoria...");
				resize(_pos);
				this.Memory[_pos] = _value;
				System.out.println("Valor escrito correctamente.");
				this.size++;
				this.empty = true;
				added = true;
			}	
		} else {
			System.err.println("Error. La posición no puede ser menor que 0.");
		}
		return added;
	}
	
	/**
	 * Metodo read(). Lee el valor en la posicion pos.
	 * @param _pos es la posicion de la memoria.
	 * @return value es el valor que hay en dicha posicion.
	 */
	public Integer read(int _pos) {
		int value = -1;
		if (this.Memory[_pos] != null) {
			value = this.Memory[_pos];
		}
		return value;
	}
	
	/**
	 * Metodo resize(). Duplica el tamaño del array.
	 * @return Memory siendo el array duplicado.
	 */
	// ARREGLAR QUE SE PUEDAN HACER VARIOS RESIze :3
	
	private void resize(int _pos) {
		Integer[] Memory2 = new Integer[_pos*2];
		if (_pos >= this.size) {
			for (int i = 0; i < this.Memory.length; i++) {
				if (i < this.Memory.length) {
					Memory2[i] = this.Memory[i];
				} else {	
					Memory2[i] = null;
				}
			}
		}
		this.Memory = Memory2;
	}
}
