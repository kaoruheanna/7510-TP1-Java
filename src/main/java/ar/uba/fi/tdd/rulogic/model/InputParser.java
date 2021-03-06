package ar.uba.fi.tdd.rulogic.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
	
	private static InputParser instance = null;
	private Pattern queryPattern;
	private Pattern factInputPattern;
	private Pattern ruleInputPattern;
	private Pattern ruleTemplateArgsPattern;
   
	private InputParser() {
		//padre(juan, pepe)
		this.queryPattern = Pattern.compile("^([a-zA-Z]+)\\(([a-zA-Z]+[a-zA-Z,\\ ]*)\\)$");
		//varon(juan).
		this.factInputPattern = Pattern.compile("^([a-zA-Z]+)\\(([a-zA-Z]+[a-zA-Z,\\ ]*)\\)\\.$");
		// hijo(X, Y) :- varon(X), padre(Y, X).
		this.ruleInputPattern = Pattern.compile("^([a-zA-Z]+)\\([a-zA-Z]+[a-zA-Z,\\ ]*\\) :- (([a-zA-Z]+\\([a-zA-Z]+[a-zA-Z,\\ ]*\\),\\ )*[a-zA-Z]+\\([a-zA-Z]+[a-zA-Z,\\ ]*\\))\\.$");
		this.ruleTemplateArgsPattern = Pattern.compile("^[a-zA-Z]+\\(([a-zA-Z]+[a-zA-Z,\\ ]*)\\)$");
	}
	
	public static InputParser getInstance() {
		if(instance == null) {
			instance = new InputParser();
		}
		return instance;
	}
	
	/*
	 * Query
	 */

	public boolean isValidQuery(String query) {
		Matcher m = this.queryPattern.matcher(query);
		return m.matches();
	}
	
	public String getQueryName(String query) {
		Matcher m = this.queryPattern.matcher(query);
		if (m.matches()) {
			return m.group(1);
		}
		return null;
	}
	
	public String[] getQueryArgs(String query) {
		Matcher m = this.queryPattern.matcher(query);
		if (m.matches()) {
			String argsString = m.group(2);
			return argsString.split(",\\ ");
		}
		return null;
	}
	
	/*
	 * Fact
	 */
	
	public boolean isValidFactInput(String input) {
		Matcher m = this.factInputPattern.matcher(input);
		return m.matches();
	}
	
	public String getFactInputName(String query) {
		Matcher m = this.factInputPattern.matcher(query);
		if (m.matches()) {
			return m.group(1);
		}
		return null;
	}
	
	public String[] getFactInputArgs(String query) {
		Matcher m = this.factInputPattern.matcher(query);
		if (m.matches()) {
			String argsString = m.group(2);
			return argsString.split(",\\ ");
		}
		return null;
	}
	
	/*
	 * Rule
	 */
	
	public boolean isValidRuleInput(String input) {
		Matcher m = this.ruleInputPattern.matcher(input);
		return m.matches();
	}
	
	public String getRuleInputName(String query) {
		Matcher m = this.ruleInputPattern.matcher(query);
		if (m.matches()) {
			return m.group(1);
		}
		return null;
	}
	
	// Devuelve ["X","Y","Z"]
	public String[] getRuleInputTemplateArgs(String query) {
		int index = query.indexOf(":-");
		String substr = query.substring(0, index).trim();
		Matcher m = this.ruleTemplateArgsPattern.matcher(substr);
		if (m.matches()) {
			String argsString = m.group(1);
			return argsString.split(",\\ ");
		}
		return null;
	}
	
	public String[] getRuleInputArgs(String query) {
		Matcher m = this.ruleInputPattern.matcher(query);
		if (!m.matches()) {
			return null;
		}
		String argsString = m.group(2);
		String[] ocurrences = argsString.split("\\),\\ ");
		
		// A todos menos al ultimo tengo que concatenarle ")"
		// Y a todos hay que concatenarle "."
		String[] args = new String[ocurrences.length];
		for (int i = 0; i < ocurrences.length; i++) {
			String arg = ocurrences[i];
			if (i < (ocurrences.length - 1)) {
				arg = arg.concat(")");
			}
			arg = arg.concat(".");
			args[i] = arg;
		}
		return args;
	}
}
