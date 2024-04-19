package main;

/**
 * Clase CPU. Unidad de procesamiento de la máquina virtual.
 * @author crisuroll
 */
public class CPU {
	/**
	 * Atributos.
	 */
	private OperandStack pila;
	private Memory memoria;
	private boolean halt;
	
	public CPU() {
		this.pila = new OperandStack();
		this.memoria = new Memory();
		this.halt = false;
	}
	
	/**
	 * Metodo toString. Llama a los metodos toString de las clases OperandStack y Memory.
	 * @return
	 */
	public String toString() {
		return "Pila: " + this.pila.toString() + "\n Memoria: " + this.memoria.toString();
	}
	
	/**
	 * Metodo erase.
	 */
	public void erase() {
		
	}
	
	/**
	 * Metodo isHalt.
	 */
	public boolean isHalt() {
		return this.halt;
	}
	
	/**
	 * Metodo sumaPila.
	 * @return 
	 */
	public boolean sumaPila() {
		return true;
	}
	
	/**
	 * Metodo restaPila.
	 */
	public boolean restaPila() {
		return true;
	}
	
	/**
	 * Metodo multiplicaPila.
	 */
	public boolean multiplicaPila() {
		return true;
	}
	
	/**
	 * Metodo dividePila.
	 */
	public boolean dividePila() {
		return true;
	}
	
	/**
	 * Metodo execute. Encargado de ejecutar la instruccion que le llega como parametro modificando 
	 * convenientemente la memoria y/o la pila de operandos.
	 * @param instr siendo la instruccion bytecode que se quiere ejecutar.
	 * @return exc; true si se ha ejecutado correctamente, false en caso contrario.
	 */
	public boolean execute(ByteCode instr) {
		boolean exc = false;
		ByteCode op = instr;
		switch (op) {
			case ENUM_BYTECODE.ADD:
				if (sumaPila()) {
					exc = true;
				}
			break;
			case ENUM_BYTECODE.SUB:
				if (restaPila()) {
					exc = true;
				}
			break;
			case ENUM_BYTECODE.MUL:
				if (multiplicaPila()) {
					exc = true;
				}
			break;
			case ENUM_BYTECODE.DIV:
				if (dividePila()) {
					exc = true;
				}
			break;
			case ENUM_BYTECODE.OUT:
				
			break;
			case ENUM_BYTECODE.HALT:
				
			break;
			case ENUM_BYTECODE.PUSH:
			
			break;
			case ENUM_BYTECODE.LOAD:
				
			break;
			case ENUM_BYTECODE.STORE:
				
			break;
		}
		return exc;
	}
	
}
