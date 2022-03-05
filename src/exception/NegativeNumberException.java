package exception;

public class NegativeNumberException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NegativeNumberException() {
		
	}
	
	
	public NegativeNumberException(Throwable cause) {
		super(cause);
		
	}
	
	@Override 
	public String getMessage(){
		return "Error al agregar ingrediente. No pueden agregar peso negativo :)";
				
	}
	
}
