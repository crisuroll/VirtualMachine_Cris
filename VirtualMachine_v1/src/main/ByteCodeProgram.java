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
	
	/**
	 * Constructoras.
	 */
	public ByteCodeProgram() {
		this.size = 3;
		this.program = new ByteCode[size];
		this.numElems = 0;
	}
	
	public int length() {
		return this.program.length;
	}
	
	/**
	 * Metodo setInstrPos. Añade un bytecode a una posicion dada.
	 * @param _bytecode es la instruccion bytecode.
	 * @param _pos es la posicion de la pila de comandos.
	 */
	public boolean setInstrPos (ByteCode _bytecode, int _pos) {
		boolean added = false;
		if (this.program[_pos] != null) {
			this.program[_pos] = _bytecode;
			added = true;
		}
		return added;
	}
	
	/**
	 * Metodo setInstr. Añade un bytecode al final del programa.
	 * @param _bytecode es la instruccion bytecode.
	 */
	public void setInstr (ByteCode _bytecode) {
		if (this.numElems >= this.size) {
			resize();
			this.program[numElems] = _bytecode;
			this.numElems++;
		} else {
			this.program[numElems] = _bytecode;
			this.numElems++;
		}
	}
	
	/**
	 * Metodo getByteCode. Retorna un bytecode del programa.
	 * @param _pos es la posicion de la pila de comandos.
	 */
	public ByteCode getByteCode (int _pos) {
		return this.program[_pos];
	}
	
	/**
	 * Metodo resetProgram.
	 */
	public ByteCode[] resetProgram() {
		return this.program = new ByteCode[size];
	}
	
	/**
	 * Metodo runProgram. "Ejecuta" el programa. Recibe la CPU (pila y memoria). Crea un String
	 * gigante (ver ejemplo de ejecución). Quien ejecuta el programa en verdad es Command.run()
	 */
	public String runProgram(CPU _cpu) {
		String str = "";
		for (int i = 0; i < this.numElems; i++) {
			if (/*!_cpu.isHalt() &&*/ _cpu.execute(this.program[i])) {
				str = str  + "\nEl estado de la máquina tras ejecutar el bytecode "
						+ this.program[i] + " es:\n"
						+ _cpu.toString();/*
			} else if (!_cpu.isHalt()) { // Si hay error en la ejecución
				System.err.println("Error: Ejecución incorrecta del comando.");
				this.program.toString();*/
			}
		}
		_cpu.erase();
		_cpu.runCPU(); // hacer este método, la pone en marcha si estaba parada
		return str;
	} 
	
	/**
	 * Metodo toString.
	 */
	public String toString() {
		String str = "Programa almacenado:\n";
		for (int i = 0; i < this.program.length; i++) {
			if (this.program[i] != null) {
				str = str + i + ": " + this.program[i].toString() + "\n";
			}
		}
		return str;
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
		this.size = this.size*2;
		this.program = program2;
	}
	
}
