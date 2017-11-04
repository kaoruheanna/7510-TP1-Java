package ar.uba.fi.tdd.rulogic.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
	
	private static InputParser instance = null;
	private Pattern queryPattern;
	private Pattern factInputPattern;
	private Pattern ruleInputPattern;
   
	private InputParser() {
		//padre(juan, pepe)
		this.queryPattern = Pattern.compile("^([a-zA-Z]+)\\([a-zA-Z]+[a-zA-Z,\\ ]*\\)$");
		//varon(juan).
		this.factInputPattern = Pattern.compile("^([a-zA-Z]+)\\([a-zA-Z]+[a-zA-Z,\\ ]*\\)\\.$");
		// hijo(X, Y) :- varon(X), padre(Y, X).
		this.ruleInputPattern = Pattern.compile("^([a-zA-Z]+)\\([a-zA-Z]+[a-zA-Z,\\ ]*\\) :- ([a-zA-Z]+\\([a-zA-Z]+[a-zA-Z,\\ ]*\\),\\ )*[a-zA-Z]+\\([a-zA-Z]+[a-zA-Z,\\ ]*\\)\\.$");
	}
	
	public static InputParser getInstance() {
		if(instance == null) {
			instance = new InputParser();
		}
		return instance;
	}

	public boolean isValidQuery(String query) {
		Matcher m = this.queryPattern.matcher(query);
		return m.matches();
	}
	
	public boolean isValidFactInput(String input) {
		Matcher m = this.factInputPattern.matcher(input);
		return m.matches();
	}
	
	public boolean isValidRuleInput(String input) {
		Matcher m = this.ruleInputPattern.matcher(input);
		return m.matches();
	}
}
