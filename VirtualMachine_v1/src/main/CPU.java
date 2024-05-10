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
		return "Memoria: " + this.memoria.toString() + "\nPila: " + this.pila.toString();
	}
	
	/**
	 * Metodo sumaPila.
	 * @return 
	 */
	public boolean sumaPila() {
		int add = this.pila.pop() + this.pila.pop();
		this.pila.push(add);
		return true;
	}
	
	/**
	 * Metodo restaPila.
	 */
	public boolean restaPila() {
		int sub = this.pila.pop() - this.pila.pop();
		this.pila.push(sub);
		return true;
	}
	
	/**
	 * Metodo multiplicaPila.
	 */
	public boolean multiplicaPila() {
		int mul = this.pila.pop() * this.pila.pop();
		this.pila.push(mul);
		return true;
	}
	
	/**
	 * Metodo dividePila.
	 */
	public boolean dividePila() {
		int div = this.pila.pop() / this.pila.pop();
		this.pila.push(div);
		return true;
	}
	
	/**
	 * Metodo runCPU.
	 */
	public boolean runCPU() {
		return this.halt = false;
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
		boolean exc = false;
		switch (instr.getEnumByteCode()) {
			case PUSH:
				if (this.pila.push(instr.getParam())) {
					exc = true;
				}
			break;
			case LOAD:
				if(this.pila.push(this.memoria.read(instr.getParam()))) {
					exc = true;
				}
			break;
			case STORE:
				if(this.memoria.write(instr.getParam(), this.pila.pop())) {
					exc = true;
				}
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
