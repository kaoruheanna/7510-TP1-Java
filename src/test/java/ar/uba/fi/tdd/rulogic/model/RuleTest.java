package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RuleTest {
	
	private Rule subtractRule;
	private Rule hijoRule;
	
	@Before
	public void setUp() throws Exception {
		ArrayList<String> factArgs = new ArrayList<String>(Arrays.asList("one", "one", "two"));
		Fact fact = new Fact("add",factArgs);
		ArrayList<Askable> addFacts = new ArrayList<Askable>();
		addFacts.add(fact);
		
		this.subtractRule = new Rule("subtract",addFacts);
		this.hijoRule = new Rule("hijo",addFacts);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAnswer_shouldPass_1() {
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("two", "one", "one"));
		Query query = new Query("subtract",args);
		
		Assert.assertTrue(this.subtractRule.answer(query));
	}
	
	@Test
	public void testAnswer__withDifferentName_shouldFail_1() {
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("two", "one", "one"));
		Query query = new Query("multiply",args);
		
		Assert.assertFalse(this.subtractRule.answer(query));
	}
	
	@Test
	public void testAnswer_shouldPass_2() {
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("pepe", "juan"));
		Query query = new Query("hijo",args);
		
		Assert.assertTrue(this.hijoRule.answer(query));
	}
	
	@Test
	public void testAnswer__withDifferentName_shouldFail_2() {
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("pepe", "juan"));
		Query query = new Query("tio",args);
		
		Assert.assertFalse(this.hijoRule.answer(query));
	}
	
	@Test
	public void testAnswer_withDifferentArgs_shouldFail_1() {
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("one", "one", "two"));
		Query query = new Query("subtract",args);
		
		Assert.assertFalse(this.subtractRule.answer(query));
	}

}
