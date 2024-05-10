package main;

/**
 * Clase Bytecode. Contiene las instrucciones bytecode para manejar la máquina virtual.
 * @author crisuroll
 */
public class ByteCode {

	/**
	 * Atributos.
	 */
	private ENUM_BYTECODE name;
	private int param;
	
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
	 * Metodo getBytecode. Coge el valor de tipo enum del ByteCode.
	 */
	public ENUM_BYTECODE getEnumByteCode() {
		return this.name;
	}
	
	/**
	 * Metodo getParam. Coge el parámetro del bytecode.
	 */
	public int getParam() {
		return this.param;
	}
	
	/**
	 * Metodo toString().
	 */
	public String toString() {
	    String str = "";
	    if (this.name == ENUM_BYTECODE.PUSH || this.name == ENUM_BYTECODE.STORE || this.name == ENUM_BYTECODE.LOAD) {
	        str = str + this.name + " " + this.param;
	    } else {
	        str = str + this.name;
	    }
	    return str;
	}

	/*
	public boolean push(int n) {
		this.name = ENUM_BYTECODE.PUSH;
		this.param = n;
		this.s.push(this.param);
		return true;
	}
	
	public void load(int pos) {
		this.name = ENUM_BYTECODE.LOAD;
		this.param = pos;
		this.s.push(m.read(this.param));
	}
	
	public void store(int pos) {
		this.name = ENUM_BYTECODE.STORE;
		this.param = pos;
		this.m.write(this.param, this.s.pop());
	}
	
	public int add() {
		this.name = ENUM_BYTECODE.ADD;
		int cima = s.pop();
		int subcima = s.pop();
		int add = subcima + cima;
		System.out.println("La suma de " + subcima + " y " + cima + " es " + add);
		this.s.push(add);
		return add;
	}

	public int sub() {
		this.name = ENUM_BYTECODE.SUB;
		int cima = s.pop();
		int subcima = s.pop();
		this.s.push(cima);
		int sub = subcima - cima;
		System.out.println("La resta de " + subcima + " y " + cima + " es " + sub);
		this.s.push(sub);
		return sub;
	}

	public int mul() {
		this.name = ENUM_BYTECODE.MUL;
		int cima = s.pop();
		int subcima = s.pop();
		this.s.push(cima);
		int mul = subcima * cima;
		System.out.println("La suma de " + subcima + " y " + cima + " es " + mul);
		this.s.push(mul);
		return mul;
	}

	public int div() {
		this.name = ENUM_BYTECODE.DIV;
		int cima = s.pop();
		int subcima = s.pop();
		this.s.push(cima);
		int div = subcima / cima;
		System.out.println("La suma de " + subcima + " y " + cima + " es " + div);
		this.s.push(div);
		return div;
	}

	public void out(int pos) {
		this.name = ENUM_BYTECODE.OUT;
		System.out.println(s.getCima());
	}
	
	
	public void halt() {
		this.name = ENUM_BYTECODE.HALT; // INVESTIGAR MAS SOBRE SLEEP O DETENER PROGRAMAS.
		System.exit(0);
	}
	
	*/

}
