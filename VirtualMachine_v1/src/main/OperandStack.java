package main;

/**
 * Clase OperandStack. Simula la pila utilizada para el metaprograma.
 * @author crisuroll
 */
public class OperandStack {
	/**
	 * Atributos de la clase OperandStack.
	 */
	final private int MAX_STACK;
	private Integer[] Stack;
	private int numElems;
	
	/**
	 * Constructora de la clase OperandStack.
	 */
	public OperandStack() {
		this.MAX_STACK = 10;
		this.Stack = new Integer[MAX_STACK];
		this.numElems = 0;
	}
	
	/**
	 * Metodo toString(). Recibe un array de tipo int y lo convierte en un String.
	 * @param _arr es el array a convertir.
	 * @return str es una cadena de caracteres con los elementos del array.
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < this.numElems; i++) {
			if(this.Stack[i] != null) {
				str = str + this.Stack[i] + " ";
			}
		}
		// System.out.println(str);
		return str;
	}
	
	/**
	 * Metodo isEmpty(). Pregunta a la pila si esta vacia y retorna un booleano.
	 * @return true si está vacia; false si contiene elementos.
	 */
	public boolean isEmpty() {
		// Intento de condición ternaria
		return this.numElems == 0 ? true : false;
	}
	
	/**
	 * Metodo push(). Simula el metodo push() de la clase Stack.
	 * @param _num es el numero recibido por parametro que se quiere añadir al array.
	 */
	public void push(int _num) {
		this.Stack[numElems] = _num;
		this.numElems++;
	}
	
	/**
	 * Metodo pop(). Simula el metodo pop() de la clase Stack.
	 * @return del siendo el elemento eliminado
	 */
	public int pop() {
		int del = this.Stack[numElems - 1];
		this.Stack[numElems - 1] = null;
		this.numElems--;
		return del;
	}
	
	/**
	 * Metodo getCima(). Simula el metodo peek() de la clase Stack.
	 * @return this.Stack[numElems - 1] siendo la cima de la pila.
	 */
	public int getCima() {
		return this.Stack[numElems - 1];
	}
}