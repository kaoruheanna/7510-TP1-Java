package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;

public class Rule implements Askable {
	
	private String name;
	private ArrayList<String> arguments;
	private ArrayList<QueryTemplate> queryTemplates;
	private ArrayList<Askable> askables;
	
	public Rule(String name, ArrayList<String> arguments, ArrayList<QueryTemplate> queryTemplates, ArrayList<Askable> askables) {
		this.name = name;
		this.arguments = arguments;
		this.askables = askables;
		this.queryTemplates = queryTemplates;
	}
	
	private boolean checkAskable(Query replacedQuery) {
		for (Askable askable : this.askables) {
			// si alguno de los askables cumple, ya es valido
			if (askable.answer(replacedQuery)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkQuery(Query query) {
		ArgumentsMap map = new ArgumentsMap(this.arguments, query.getArguments());
				
		for (QueryTemplate queryTemplate : this.queryTemplates) {
			Query replacedQuery = queryTemplate.getQuery(map);
			// si alguno falla, la query es falsa
			if (!this.checkAskable(replacedQuery)) {
				return false;
			}
		}
		return true;
	}

	public boolean answer(Query query) {
		return (query.getName().equals(this.name)) && this.checkQuery(query);
	}

}
