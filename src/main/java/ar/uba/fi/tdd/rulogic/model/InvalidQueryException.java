package ar.uba.fi.tdd.rulogic.model;

public class InvalidQueryException extends Exception {
	
	public InvalidQueryException(String query) {
		super("Query inválida: '"+query+"'");
	}
}
