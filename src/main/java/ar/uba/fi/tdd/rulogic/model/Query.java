package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;

public class Query {
	
	private String name;
	private ArrayList<String> arguments;
	
	public Query(String name, ArrayList<String> arguments) {
		this.name = name;
		this.arguments = arguments;
	}

	public String getName() {
		return name;
	}

	public ArrayList<String> getArguments() {
		return arguments;
	}

}
