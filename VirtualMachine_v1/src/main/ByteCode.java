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
	 * @return name es el enum correspondiente al Bytecode.
	 */
	public ENUM_BYTECODE getEnumByteCode() {
		return this.name;
	}
	
	/**
	 * Metodo getParam. Coge el parámetro del bytecode.
	 * @return param es el parametro correspondiente al Bytecode.
	 */
	public int getParam() {
		return this.param;
	}
	
	/**
	 * Metodo toString(). Crea un String de caracteres con la instruccion Bytecode y, si lo tiene, su parametro.
	 * @return str es el String que forma la instruccion.
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
