package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;

public class Fact implements Askable {
	
	private String name;
	private ArrayList<String> arguments;
	
	public Fact(String name, ArrayList<String> arguments) {
		this.name = name;
		this.arguments = arguments;
	}
	
	private boolean checkArguments(Query query) {
		return this.arguments.equals(query.getArguments()); 
	}

	public boolean answer(Query query) {
		return (query.getName().equals(this.name)) && this.checkArguments(query); 
	}

}
