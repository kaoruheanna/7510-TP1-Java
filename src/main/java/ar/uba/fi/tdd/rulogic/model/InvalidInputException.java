package ar.uba.fi.tdd.rulogic.model;

public class InvalidInputException extends Exception {

	public InvalidInputException(String input) {
		super("Input inválido: '"+input+"'");
	}
}
