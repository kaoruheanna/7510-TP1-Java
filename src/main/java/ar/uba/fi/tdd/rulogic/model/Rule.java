package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Rule implements Askable {
	
	private String name;
	private ArrayList<Askable> askables;
	
	public Rule(String name, ArrayList<Askable> askables) {
		this.name = name;
		this.askables = askables;
	}
	
	private boolean checkArguments(Query query) {
		for (Askable askable : this.askables) {
			// si alguno de los askables cumple, ya es valido
			if (askable.answer(query)) {
				return true;
			}
		}
		return false;
	}

	public boolean answer(Query query) {
		return (query.getName() == this.name) && this.checkArguments(query);
	}

}
