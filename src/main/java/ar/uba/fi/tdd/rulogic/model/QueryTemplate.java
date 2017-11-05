package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;

public class QueryTemplate {
	
	private String name;
	ArrayList<String> templateArgs;
	
	public QueryTemplate(String name, ArrayList<String> templateArgs) {
		this.name = name;
		this.templateArgs = templateArgs;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Query getQuery(ArgumentsMap argumentsMap) {
		ArrayList<String> args = this.getArguments(argumentsMap);
		return new Query(this.name, args);
	}
	
	private ArrayList<String> getArguments(ArgumentsMap argumentsMap) {
		ArrayList<String> args = new ArrayList<String>();
		for (String key : this.templateArgs) {
			String value = argumentsMap.getForKey(key);
			args.add(value);
		}
		return args;
	}

}
