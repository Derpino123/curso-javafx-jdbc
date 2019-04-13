package model.exception;

import java.util.HashMap;
import java.util.Map;

public class ValidationException extends RuntimeException{

	private Map<String, String> erros = new HashMap<>();
	private static final long serialVersionUID = 1L;
	
	public ValidationException(String msg) {
		super(msg);
	}
	public Map<String, String> getErrors(){
		return erros;
	}
	
	public void addError(String fieldName, String errorMessage) {
		erros.put(fieldName, errorMessage);
		}
	
	

}
