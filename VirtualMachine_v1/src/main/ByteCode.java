package main;

/**
 * Clase Bytecode. Contiene las instrucciones bytecode para manejar la máquina virtual.
 * @author crisuroll
 */
public class ByteCode {

	OperandStack s = new OperandStack();
	Memory m = new Memory();
	
	/**
	 * Atributos.
	 */
	private ENUM_BYTECODE name;
	private int param; // necesario para PUSH, STORE y LOAD. Revisar su verdadera funcionalidad.
	
	/**
	 * Constructora.
	 */
	public ByteCode(ENUM_BYTECODE _name) {
		this.name = _name;
	}
	
	public ByteCode(ENUM_BYTECODE _name, int _param) {
		this.name = _name;
		this.param = _param;
	}
	
	/**
	 * Metodo push(). Instruccion bytecode que apila en el stack el entero n.
	 * @param n es el entero a apilar.
	 */
	public void push(int n) {
		this.name = ENUM_BYTECODE.PUSH;
		this.param = n;
		s.push(this.param);
	}
	
	/**
	 * Metodo load(). Instruccion bytecode que lee de la memoria el valor de pos y lo apila en el stack.
	 * @param pos
	 */
	public void load(int pos) {
		this.name = ENUM_BYTECODE.LOAD;
		this.param = pos;
		s.push(m.read(this.param));
	}
	
	/**
	 * Merodo store(). Instruccion bytecode que escribe en la pos de memoria el valor de la cima del stack.
	 * @param pos
	 */
	public void store(int pos) {
		this.name = ENUM_BYTECODE.STORE;
		this.param = pos;
		m.write(this.param, s.pop());
	}
	
	/**
	 * Metodo add(). Instruccion bytecode que suma la cima y la subcima de la pila. Estas se sustituyen
	 * por el resultado.
	 * @return add es la suma obtenida.
	 */
	public int add() {
		this.name = ENUM_BYTECODE.ADD;
		int cima = s.pop();
		int subcima = s.getCima();
		s.push(cima);
		int add = subcima + cima;
		System.out.println("La suma de " + subcima + " y " + cima + " es " + add);
		s.pop();
		s.pop();
		s.push(add);
		return add;
	}
	
	/**
	 * Metodo sub(). Instruccion bytecode que resta la cima y la subcima de la pila. Estas se sustituyen
	 * por el resultado.
	 * @return sub es la resta obtenida.
	 */
	public int sub() {
		this.name = ENUM_BYTECODE.SUB;
		int cima = s.pop();
		int subcima = s.getCima();
		s.push(cima);
		int sub = subcima - cima;
		System.out.println("La resta de " + subcima + " y " + cima + " es " + sub);
		s.pop();
		s.pop();
		s.push(sub);
		return sub;
	}
	
	/**
	 * Metodo mul(). Instruccion bytecode que multiplica la cima y la subcima de la pila. Estas se 
	 * sustituyen por el resultado.
	 * @return mul es la suma obtenida.
	 */
	public int mul() {
		this.name = ENUM_BYTECODE.MUL;
		int cima = s.pop();
		int subcima = s.getCima();
		s.push(cima);
		int mul = subcima * cima;
		System.out.println("La suma de " + subcima + " y " + cima + " es " + mul);
		s.pop();
		s.pop();
		s.push(mul);
		return mul;
	}
	
	/**
	 * Metodo div(). Instruccion bytecode que divide la cima y la subcima de la pila. Estas se sustituyen
	 * por el resultado.
	 * @return div es la suma obtenida.
	 */
	public int div() {
		this.name = ENUM_BYTECODE.DIV;
		int cima = s.pop();
		int subcima = s.getCima();
		s.push(cima);
		int div = subcima / cima;
		System.out.println("La suma de " + subcima + " y " + cima + " es " + div);
		s.pop();
		s.pop();
		s.push(div);
		return div;
	}
	
	/**
	 * Metodo out(). Escribe el entero de la cima de la pila.
	 * @param pos
	 */
	public void out(int pos) {
		this.name = ENUM_BYTECODE.OUT;
		System.out.println(s.getCima());
	}
	
	/**
	 * Metodo halt(). Detiene la VM.
	 */
	public void halt() {
		this.name = ENUM_BYTECODE.HALT; // INVESTIGAR MAS SOBRE SLEEP O DETENER PROGRAMAS.
		System.exit(0);
	}

}
