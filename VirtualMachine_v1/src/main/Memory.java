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

	/**
	 * Constructora de la clase Memory.
	 */
	public Memory() {
		this.MAX_MEMORY = 2;
		this.Memory = new Integer[MAX_MEMORY];
		this.size = 0;
	}

	/**
	 * Metodo toString(). Recibe un array de tipo int y lo convierte en un String.
	 * @param _arr es el array a convertir.
	 * @return str siendo la cadena convertida.
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < this.Memory.length; i++) {
			if(this.Memory[i] != null) {
				str = str + this.Memory[i] + " ";
			}
		}
		// System.out.println(str);
		return str;
	}
	
	/**
	 * Metodo write(). Escribe el valor de value en la posicion pos.
	 * @return pos representa la posicion de la memoria.
	 * @param value representa el valor de la posicion proporcionada.
	 * @return value; true si se ha añadido correctamente, false en caso contrario.
	 */
	/*
	 * -------------------------------------REVISAR ESTE MÉTODO------------------------------------------
	 */
	public boolean write(int _pos, int _value) {
		boolean added = false;
		this.Memory[_pos - 1] = _value;
		if (this.Memory[_pos - 1] == _value) {
			System.out.println("Valor escrito correctamente.");
			this.size++;
			added = true;
		} else {
			System.out.println("Ha fallado la operación.");
			added = false;
		}
		return added;
	}
	
	/**
	 * Metodo read(). Lee el valor en la posicion pos.
	 * @param _pos es la posicion de la memoria.
	 * @return value es el valor que hay en dicha posicion.
	 */
	public int read(int _pos) {
		int value = 0;
		if (this.Memory[_pos - 1] != null) {
			value = this.Memory[_pos - 1];
		}
		return value;
		//return (this.Memory[_pos - 1] != null) ? this.Memory[_pos - 1] : 0; // Ojalá poder implementar esto
	}
	
	/**
	 * Metodo resize(). Duplica el tamaño del array.
	 * @return Memory siendo el array duplicado.
	 */
	public Integer[] resize() {
		Integer[] Memory2 = new Integer[this.Memory.length*2];
		for (int i = 0; i < this.Memory.length*2; i++) {
			if (i < this.Memory.length) {
				Memory2[i] = this.Memory[i];
			} else {
				Memory2[i] = null;
			}
		}
		this.Memory = Memory2;
		return this.Memory;
	}
}
