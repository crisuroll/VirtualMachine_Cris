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
	private ByteCode bc;
	//private ByteCodeProgram program;
	
	public CPU() {
		this.pila = new OperandStack();
		this.memoria = new Memory();
		this.halt = false;
	}
	
	public CPU(ByteCode _bc) {
		this.pila = new OperandStack();
		this.memoria = new Memory();
		this.halt = false;
		this.bc = _bc;
	}
	
	/**
	 * Metodo toString. Llama a los metodos toString de las clases OperandStack y Memory.
	 * @return
	 */
	public String toString() {
		return "Memoria: " + this.memoria.toString() + "\nPila: " + this.pila.toString();
	}
	
	/**
	 * Metodo sumaPila.
	 * @return 
	 */
	public boolean sumaPila() {
		this.bc.add();
		return true;
	}
	
	/**
	 * Metodo restaPila.
	 */
	public boolean restaPila() {
		this.bc.sub();
		return true;
	}
	
	/**
	 * Metodo multiplicaPila.
	 */
	public boolean multiplicaPila() {
		this.bc.mul();
		return true;
	}
	
	/**
	 * Metodo dividePila.
	 */
	public boolean dividePila() {
		this.bc.div();
		return true;
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
	 * Metodo execute. Encargado de ejecutar la instruccion que le llega como parametro modificando 
	 * convenientemente la memoria y/o la pila de operandos.
	 * @param instr siendo la instruccion bytecode que se quiere ejecutar.
	 * @return exc; true si se ha ejecutado correctamente, false en caso contrario.
	 */
	public boolean execute(ByteCode instr) {
		//this.program.setInstr(instr);
		boolean exc = false;
		this.bc = instr;
		switch (this.bc.getEnumByteCode()) {
			case PUSH:
				this.bc.push(instr.getParam());
			break;
			case LOAD:
				this.bc.load(instr.getParam());
			break;
			case STORE:
				this.bc.load(instr.getParam());
			break;
			case ADD:
				if (sumaPila()) {
					exc = true;
				}
			break;
			case SUB:
				if (restaPila()) {
					exc = true;
				}
			break;
			case MUL:
				if (multiplicaPila()) {
					exc = true;
				}
			break;
			case DIV:
				if (dividePila()) {
					exc = true;
				}
			break;
			case OUT:
				
			break;
			case HALT:
				
			break;
		}
		return exc;
	}
	
}
