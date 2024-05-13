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
	
	/**
	 * Constructora.
	 */
	public CPU() {
		this.pila = new OperandStack();
		this.memoria = new Memory();
		this.halt = false;
	}
	
	/**
	 * Metodo toString. Llama a los metodos toString de las clases OperandStack y Memory.
	 * @return la memoria y la pila de la CPU.
	 */
	public String toString() {
		return "  Memoria: " + this.memoria.toString() + "\n  Pila: " + this.pila.toString();
	}
	
	/**
	 * Metodo sumaPila. Suma la cima y la subcima de la pila, las elimina y agrega su resultado a ella.
	 * @return true si se ha ejecutado; false en caso contrario.
	 */
	public boolean sumaPila() {
		int num1 = this.pila.pop();
		int num2 = this.pila.pop();
		if (num1 == -1 || num2 == -1) {
			return false;
		}
		int add = num2 + num1;
		this.pila.push(add);
		return true;
	}
	
	/**
	 * Metodo restaPila. Resta la cima y la subcima de la pila, las elimina y agrega su resultado a ella.
	 * @return true si se ha ejecutado; false en caso contrario.
	 */
	public boolean restaPila() {
		int num1 = this.pila.pop();
		int num2 = this.pila.pop();
		if (num1 == -1 || num2 == -1) {
			return false;
		}
		int sub = num2 - num1;
		this.pila.push(sub);
		return true;
	}
	
	/**
	 * Metodo multiplicaPila. Multiplica la cima y la subcima de la pila, las elimina y agrega su resultado a ella.
	 * @return true si se ha ejecutado; false en caso contrario.
	 */
	public boolean multiplicaPila() {
		int num1 = this.pila.pop();
		int num2 = this.pila.pop();
		if (num1 == -1 || num2 == -1) {
			return false;
		}
		int mul = num2 * num1;
		this.pila.push(mul);
		return true;
	}
	
	/**
	 * Metodo dividePila. Divide la cima y la subcima de la pila, las elimina y agrega su resultado a ella.
	 * @return true si se ha ejecutado; false en caso contrario.
	 */
	public boolean dividePila() {
		int num1 = this.pila.pop();
		int num2 = this.pila.pop();
		if (num1 == -1 || num2 == -1 || num1 == 0 || num2 == 0) {
			return false;
		}
		int div = num2 / num1;
		this.pila.push(div);
		return true;
	}
	
	/**
	 * Metodo runCPU. Corre la CPU.
	 * @return halt poniendolo a false.
	 */
	public boolean runCPU() {
		return this.halt = false;
	}
	
	/**
	 * Metodo erase. Elimina la CPU inicializandola desde cero.
	 */
	public void erase() {
		this.pila = new OperandStack();
		this.memoria = new Memory();
	}
	
	/**
	 * Metodo isHalt. Comprueba si la CPU esta en pausa.
	 * @return halt siendo true si esta en pausa; false en caso contrario.
	 */
	public boolean isHalt() {
		return this.halt;
	}
	
	/**
	 * Metodo out. Muestra la cima de la pila.
	 * @return true si se ha ejecutado; false en caso contrario.
	 */
	public boolean out() {
		System.out.println("La cima de la pila es: " + this.pila.getCima());
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
				if (out()) {
					exc = true;
				}
				
			break;
			case HALT:
				if (!isHalt()) {
					this.halt = true;
					exc = true;
				}
			break;
		}
		return exc;
	}
	
}
