package main;

/**
 * Clase ByteCodeProgram. Representa el programa actual.
 * @author crisuroll
 */
public class ByteCodeProgram {

	/**
	 * Atributos de la clase ByteCodeProgram.
	 */
	private ByteCode[] program;
	private int numElems;
	private int size;
	private final int MAX_PROGRAM;
	
	/**
	 * Constructoras.
	 */
	public ByteCodeProgram() {
		this.MAX_PROGRAM = 2;
		this.program = new ByteCode[MAX_PROGRAM];
		this.numElems = 0;
		this.size = 0;
	}
	
	/**
	 * Metodo addByteCode. Añade un bytecode al programa.
	 * @param _bytecode es la instruccion bytecode.
	 */
	public void addByteCode (ByteCode _bytecode) {
		
	}
	
	/**
	 * Metodo setInstrPos. Añade un bytecode a una posicion dada.
	 * @param _bytecode es la instruccion bytecode.
	 * @param _pos es la posicion de la pila de comandos.
	 */
	public boolean setInstrPos (ByteCode _bytecode, int _pos) {
		boolean added = false;
		return added;
		// replace
	}
	
	/**
	 * Metodo setInstr. Añade un bytecode al final del programa.
	 * @param _bytecode es la instruccion bytecode.
	 */
	public void setInstr (ByteCode _bytecode) {
		if (this.size > this.MAX_PROGRAM) {
			resize();
			addByteCode(_bytecode);
		}
	}
	
	/**
	 * Metodo getByteCode. Retorna un bytecode del programa.
	 * @param _pos es la posicion de la pila de comandos.
	 */
	public ByteCode getByteCode (int _pos) {
		
		return null; 
	}
	
	/**
	 * Metodo runProgram.
	 */
	public void runProgram() {
		
	} 
	
	/**
	 * Metodo toString.
	 */
	public String toString() {
		return null;
	}
	
	/**
	 * Metodo resize(). Duplica el tamaño del array.
	 */
	private void resize() {
		ByteCode[] program2 = new ByteCode[this.size*2];
		for (int i = 0; i < this.program.length*2; i++) {
			if (i < this.program.length) {
				program2[i] = this.program[i];
			} else {	
				program2[i] = null;
			}
		}
		this.program = program2;
	}
	
}
