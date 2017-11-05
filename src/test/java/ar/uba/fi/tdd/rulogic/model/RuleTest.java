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
	private Rule hijaRule;
	
	@Before
	public void setUp() throws Exception {
		this.initSubstractRule();
		this.initHijoRule(); 
		this.initHijaRule();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	private void initSubstractRule() {
		RuleBuilder builder = new RuleBuilder();
		builder.setName("subtract");
		builder.setArguments(new ArrayList<String>(Arrays.asList("X", "Y", "Z")));
		
		ArrayList<String> templateArgs = new ArrayList<String>(Arrays.asList("Y", "Z", "X"));
		QueryTemplate template = new QueryTemplate("add",templateArgs);
		builder.addQueryTemplate(template);
		
		// Askables
		ArrayList<String> factArgs = new ArrayList<String>(Arrays.asList("one", "one", "two"));
		Fact fact = new Fact("add",factArgs);
		builder.addAskable(fact);
		
		factArgs = new ArrayList<String>(Arrays.asList("zero", "zero", "zero"));
		fact = new Fact("add",factArgs);
		builder.addAskable(fact);
		
		factArgs = new ArrayList<String>(Arrays.asList("one", "zero", "one"));
		fact = new Fact("add",factArgs);
		builder.addAskable(fact);
		
		factArgs = new ArrayList<String>(Arrays.asList("one", "two", "zero"));
		fact = new Fact("add",factArgs);
		builder.addAskable(fact);
		
		this.subtractRule = builder.buildRule();
	}
	
	private void initHijoRule() {
		RuleBuilder builder = new RuleBuilder();
		builder.setName("hijo");
		builder.setArguments(new ArrayList<String>(Arrays.asList("X", "Y")));
		
		ArrayList<String> varonTemplatesArgs = new ArrayList<String>(Arrays.asList("X"));
		QueryTemplate varonTemplate = new QueryTemplate("varon",varonTemplatesArgs);
		builder.addQueryTemplate(varonTemplate);
		
		ArrayList<String> padreTemplatesArgs = new ArrayList<String>(Arrays.asList("Y", "X"));
		QueryTemplate padreTemplate = new QueryTemplate("padre",padreTemplatesArgs);
		builder.addQueryTemplate(padreTemplate);
		
		// Askables
		ArrayList<String> factArgs = new ArrayList<String>(Arrays.asList("juan"));
		Fact fact = new Fact("varon",factArgs);
		builder.addAskable(fact);
		
		factArgs = new ArrayList<String>(Arrays.asList("pepe"));
		fact = new Fact("varon",factArgs);
		builder.addAskable(fact);
		
		factArgs = new ArrayList<String>(Arrays.asList("hector"));
		fact = new Fact("varon",factArgs);
		builder.addAskable(fact);
		
		factArgs = new ArrayList<String>(Arrays.asList("roberto"));
		fact = new Fact("varon",factArgs);
		builder.addAskable(fact);
		
		factArgs = new ArrayList<String>(Arrays.asList("alejandro"));
		fact = new Fact("varon",factArgs);
		builder.addAskable(fact);
		
		factArgs = new ArrayList<String>(Arrays.asList("cecilia"));
		fact = new Fact("mujer",factArgs);
		builder.addAskable(fact);
		
		factArgs = new ArrayList<String>(Arrays.asList("juan", "pepe"));
		fact = new Fact("padre",factArgs);
		builder.addAskable(fact);
		
		factArgs = new ArrayList<String>(Arrays.asList("hector", "maria"));
		fact = new Fact("padre",factArgs);
		builder.addAskable(fact);
		
		factArgs = new ArrayList<String>(Arrays.asList("roberto", "cecilia"));
		fact = new Fact("padre",factArgs);
		builder.addAskable(fact);
		
		factArgs = new ArrayList<String>(Arrays.asList("roberto", "alejandro"));
		fact = new Fact("padre",factArgs);
		builder.addAskable(fact);
		
		this.hijoRule = builder.buildRule();
	}
	
	private void initHijaRule() {
		RuleBuilder builder = new RuleBuilder();
		builder.setName("hija");
		builder.setArguments(new ArrayList<String>(Arrays.asList("X", "Y")));
		
		ArrayList<String> mujerTemplatesArgs = new ArrayList<String>(Arrays.asList("X"));
		QueryTemplate mujerTemplate = new QueryTemplate("mujer",mujerTemplatesArgs);
		builder.addQueryTemplate(mujerTemplate);
		
		ArrayList<String> padreTemplatesArgs = new ArrayList<String>(Arrays.asList("Y", "X"));
		QueryTemplate padreTemplate = new QueryTemplate("padre",padreTemplatesArgs);
		builder.addQueryTemplate(padreTemplate);
		
		// Askables
		ArrayList<String> factArgs = new ArrayList<String>(Arrays.asList("hector"));
		Fact fact = new Fact("varon",factArgs);
		builder.addAskable(fact);
		
		factArgs = new ArrayList<String>(Arrays.asList("roberto"));
		fact = new Fact("varon",factArgs);
		builder.addAskable(fact);
		
		factArgs = new ArrayList<String>(Arrays.asList("alejandro"));
		fact = new Fact("varon",factArgs);
		builder.addAskable(fact);
		
		factArgs = new ArrayList<String>(Arrays.asList("cecilia"));
		fact = new Fact("mujer",factArgs);
		builder.addAskable(fact);
		
		factArgs = new ArrayList<String>(Arrays.asList("maria"));
		fact = new Fact("mujer",factArgs);
		builder.addAskable(fact);
		
		factArgs = new ArrayList<String>(Arrays.asList("hector", "maria"));
		fact = new Fact("padre",factArgs);
		builder.addAskable(fact);
		
		factArgs = new ArrayList<String>(Arrays.asList("roberto", "cecilia"));
		fact = new Fact("padre",factArgs);
		builder.addAskable(fact);
		
		factArgs = new ArrayList<String>(Arrays.asList("roberto", "alejandro"));
		fact = new Fact("padre",factArgs);
		builder.addAskable(fact);
		
		this.hijaRule = builder.buildRule();
	}
	
	/**
	 * Substract
	 */

	@Test
	public void testAnswer_shouldPass_1() {
		// substract(two, one, one) -> add(one, one, two)
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("two", "one", "one"));
		Query query = new Query("subtract",args);
		
		Assert.assertTrue(this.subtractRule.answer(query));
	}
	
	@Test
	public void testAnswer_shouldPass_2() {
		// substract(zero, zero, zero) -> add(zero, zero, zero)
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("zero", "zero", "zero"));
		Query query = new Query("subtract",args);
		
		Assert.assertTrue(this.subtractRule.answer(query));
	}
	
	@Test
	public void testAnswer_shouldPass_3() {
		// substract(one, one, zero) -> add(zero, one, one)
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("one", "one", "zero"));
		Query query = new Query("subtract",args);
		
		Assert.assertTrue(this.subtractRule.answer(query));
	}
	
	@Test
	public void testAnswer_shouldPass_4() {
		// substract(one, one, zero) -> add(one, two, zero)
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("zero", "one", "two"));
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
	public void testAnswer_withDifferentArgs_shouldFail_1() {
		// substract(one, two, one) -> add(two, one, one)
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("one", "two", "one"));
		Query query = new Query("subtract",args);
		
		Assert.assertFalse(this.subtractRule.answer(query));
	}
	
	@Test
	public void testAnswer_withDifferentArgs_shouldFail_2() {
		// substract(thirty, twenty, ten) -> add(twenty, ten, thirty)
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("thirty", "twenty", "ten"));
		Query query = new Query("subtract",args);
		
		Assert.assertFalse(this.subtractRule.answer(query));
	}
	
	/**
	 * Hijo
	 */
	
	@Test
	public void testAnswer_shouldPass_5() {
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("pepe", "juan"));
		Query query = new Query("hijo",args);
		
		Assert.assertTrue(this.hijoRule.answer(query));
	}
	
	@Test
	public void testAnswer_shouldPass_6() {
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("alejandro", "roberto"));
		Query query = new Query("hijo",args);
		
		Assert.assertTrue(this.hijoRule.answer(query));
	}
	
	@Test
	public void testAnswer__withDifferentName_shouldFail_2() {
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("cecilia", "roberto"));
		Query query = new Query("hija",args);
		
		Assert.assertFalse(this.hijoRule.answer(query));
	}
	
	@Test
	public void testAnswer__withDifferentName_shouldFail_3() {
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("alejandro", "roberto"));
		Query query = new Query("hija",args);
		
		Assert.assertFalse(this.hijoRule.answer(query));
	}
	
	@Test
	public void testAnswer_withDifferentArgs_shouldFail_4() {
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("alejandro", "roberto"));
		Query query = new Query("hija",args);
		
		Assert.assertFalse(this.hijoRule.answer(query));
	}
	
	/**
	 * Hija
	 */
	
	@Test
	public void testAnswer_shouldPass_7() {
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("maria", "hector"));
		Query query = new Query("hija",args);
		
		Assert.assertTrue(this.hijaRule.answer(query));
	}
	
	@Test
	public void testAnswer_shouldPass_8() {
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("cecilia", "roberto"));
		Query query = new Query("hija",args);
		
		Assert.assertTrue(this.hijaRule.answer(query));
	}
	
	@Test
	public void testAnswer_withDifferentArgs_shouldFail_5() {
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("cecilia", "hector"));
		Query query = new Query("hija",args);
		
		Assert.assertFalse(this.hijaRule.answer(query));
	}
	
	@Test
	public void testAnswer_withDifferentArgs_shouldFail_6() {
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("alejandro", "roberto"));
		Query query = new Query("hija",args);
		
		Assert.assertFalse(this.hijaRule.answer(query));
	}
	

}
