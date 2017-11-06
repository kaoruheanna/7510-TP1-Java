package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;
import java.util.Arrays;

public class KnowledgeBase {
	
	private ArrayList<Askable> askables = new ArrayList<Askable>();

	private void learnFact(String input) {
		InputParser parser = InputParser.getInstance();
		String name = parser.getFactInputName(input);
		String[] argumentsArray = parser.getFactInputArgs(input);	
		ArrayList<String> arguments = new ArrayList<String>(Arrays.asList(argumentsArray));
		this.askables.add(new Fact(name, arguments));
	}
	
	private void learnRule(String input) {
		InputParser parser = InputParser.getInstance();
		
		RuleBuilder builder = new RuleBuilder();
				
		// name
		String name = parser.getRuleInputName(input);
		builder.setName(name);
		
		// Template Args
		String[] templateArgumensArray = parser.getRuleInputTemplateArgs(input);
		ArrayList<String> templateArguments = new ArrayList<String>(Arrays.asList(templateArgumensArray));
		builder.setArguments(templateArguments);
		
		// Query Template
		for (String rightAskable : parser.getRuleInputArgs(input)) {
			String rightName = parser.getFactInputName(rightAskable);
			String[] rightArgsArray = parser.getFactInputArgs(rightAskable);	
			ArrayList<String> rightArgs = new ArrayList<String>(Arrays.asList(rightArgsArray));
			QueryTemplate varonTemplate = new QueryTemplate(rightName,rightArgs);
			builder.addQueryTemplate(varonTemplate);
		}
				
		// Askables
		for (Askable askable : this.askables) {
			builder.addAskable(askable);
		}
		
		this.askables.add(builder.buildRule());
	}
	
	public void learn(String input) {
		input = input.trim();
		input = input.replaceAll("(\\r|\\n)", "");
		InputParser parser = InputParser.getInstance();
		if (parser.isValidFactInput(input)) {
			this.learnFact(input);
			return;
		}
		if (parser.isValidRuleInput(input)) {
			this.learnRule(input);
			return;
		}
	}
	
	private Query getQueryFromString(String queryString) {
		InputParser parser = InputParser.getInstance();
		if (!parser.isValidQuery(queryString)) {
			return null;
		}
		
		String name = parser.getQueryName(queryString);
		ArrayList<String> args = new ArrayList<String>(Arrays.asList(parser.getQueryArgs(queryString)));
		return new Query(name,args);
		
	}
	
	public boolean answer(String queryString) {
		Query query = this.getQueryFromString(queryString);
		for (Askable askable : this.askables) {
			if (askable.answer(query)) {
				return true;
			}
		}
		return false;
	}
	
	

}
