package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;

public class RuleBuilder {

	private String name;
	private ArrayList<String> arguments;
	private ArrayList<QueryTemplate> queryTemplates = new ArrayList<QueryTemplate>();
	private ArrayList<Askable> askables = new ArrayList<Askable>();
	
	public RuleBuilder() {
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setArguments(ArrayList<String> arguments) {
		this.arguments = arguments;
	}
	
	public void addQueryTemplate(QueryTemplate template) {
		this.queryTemplates.add(template);
	}
	
	public void addAskable(Askable askable) {
		this.askables.add(askable);
	}
	
	public Rule buildRule() {
		Rule rule = new Rule(this.name, this.arguments, this.queryTemplates, this.askables);
		return rule;
	}
	
}
