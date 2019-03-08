package api.restfull.treinando.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

public class Message {

	protected static String messageForJSONStr(String k, String v) {
		return "{\""+k+"\": \""+v+"\"}";
	}
	
	public static ResponseEntity<?> messageErrorDefault(Errors errors) {
		return ResponseEntity.badRequest()
	 			 .body(Message.messageForJSONStr("error", errors.getFieldError()
			     .getDefaultMessage()));
	}
	
	public static ResponseEntity<?> messageError(HttpStatus status, String message) {
		return ResponseEntity.status(status)
				 			 .body(Message.messageForJSONStr("error", message));
	}
	
}
