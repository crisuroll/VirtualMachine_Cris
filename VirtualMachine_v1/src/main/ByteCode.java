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

}
