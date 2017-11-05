package ar.uba.fi.tdd.rulogic.model;

import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InputParserTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * query
	 */
	@Test
	public void testValidQuery_shouldPass_1() {
		InputParser parser = InputParser.getInstance();
		String queryString = "varon(javier)";
		Assert.assertTrue(parser.isValidQuery(queryString));
		Assert.assertEquals(parser.getQueryName(queryString), "varon");
		Assert.assertArrayEquals(parser.getQueryArgs(queryString), new String[]{"javier"});
	}
	
	@Test
	public void testValidQuery_shouldFail_1() {
		InputParser parser = InputParser.getInstance();
		Assert.assertFalse(parser.isValidQuery("varon"));
	}
	
	@Test
	public void testValidQuery_shouldPass__2() {
		InputParser parser = InputParser.getInstance();
		String queryString = "varon(lucia)";
		Assert.assertTrue(parser.isValidQuery(queryString));
		Assert.assertEquals(parser.getQueryName(queryString), "varon");
		Assert.assertArrayEquals(parser.getQueryArgs(queryString), new String[]{"lucia"});
	}
	
	@Test
	public void testValidQuery_shouldPass_3() {
		InputParser parser = InputParser.getInstance();
		String queryString = "mujer(lucia)";
		Assert.assertTrue(parser.isValidQuery(queryString));
		Assert.assertEquals(parser.getQueryName(queryString), "mujer");
		Assert.assertArrayEquals(parser.getQueryArgs(queryString), new String[]{"lucia"});
	}
	
	@Test
	public void testValidQuery_shouldPass_4() {
		InputParser parser = InputParser.getInstance();
		String queryString = "hijo(pepe, juan)";
		Assert.assertTrue(parser.isValidQuery(queryString));
		Assert.assertEquals(parser.getQueryName(queryString), "hijo");
		Assert.assertArrayEquals(parser.getQueryArgs(queryString), new String[]{"pepe","juan"});
	}
	
	@Test
	public void testValidQuery_shouldPass_5() {
		InputParser parser = InputParser.getInstance();
		String queryString = "padre(juan, pepe)";
		Assert.assertTrue(parser.isValidQuery(queryString));
		Assert.assertEquals(parser.getQueryName(queryString), "padre");
		Assert.assertArrayEquals(parser.getQueryArgs(queryString), new String[]{"juan","pepe"});
	}
	
	@Test
	public void testValidQuery_shouldPass_6() {
		InputParser parser = InputParser.getInstance();
		String queryString = "add(two, one, zero)";
		Assert.assertTrue(parser.isValidQuery(queryString));
		Assert.assertEquals(parser.getQueryName(queryString), "add");
		Assert.assertArrayEquals(parser.getQueryArgs(queryString), new String[]{"two","one", "zero"});
	}
	
	@Test
	public void testValidQuery_shouldFail_2() {
		InputParser parser = InputParser.getInstance();
		Assert.assertFalse(parser.isValidQuery("varon("));
	}
	
	@Test
	public void testValidQuery_shouldFail_3() {
		InputParser parser = InputParser.getInstance();
		Assert.assertFalse(parser.isValidQuery("varon(juan"));
	}
	
	@Test
	public void testValidQuery_shouldFail_4() {
		InputParser parser = InputParser.getInstance();
		Assert.assertFalse(parser.isValidQuery("varon(juan,lucas"));
	}
	
	/**
	 *  fact input
	 */
	@Test
	public void testValidFactInput_shouldPass_1() {
		InputParser parser = InputParser.getInstance();
		String factString = "varon(juan).";
		Assert.assertTrue(parser.isValidFactInput(factString));
		Assert.assertEquals(parser.getFactInputName(factString), "varon");
		Assert.assertArrayEquals(parser.getFactInputArgs(factString), new String[]{"juan"});
	}
	
	@Test
	public void testValidFactInput_shouldFail_1() {
		InputParser parser = InputParser.getInstance();
		Assert.assertFalse(parser.isValidFactInput("varon"));
	}
	
	@Test
	public void testValidFactInput_shouldFail_2() {
		InputParser parser = InputParser.getInstance();
		Assert.assertFalse(parser.isValidFactInput("varon("));
	}
	
	@Test
	public void testValidFactInput_shouldFail_3() {
		InputParser parser = InputParser.getInstance();
		Assert.assertFalse(parser.isValidFactInput("varon(juan"));
	}
	
	@Test
	public void testValidFactInput_shouldFail_4() {
		InputParser parser = InputParser.getInstance();
		Assert.assertFalse(parser.isValidFactInput("varon(juan)"));
	}
	
	@Test
	public void testValidFactInput_shouldFail_5() {
		InputParser parser = InputParser.getInstance();
		Assert.assertFalse(parser.isValidFactInput("varon()."));
	}
	
	@Test
	public void testValidFactInput_shouldPass_2() {
		InputParser parser = InputParser.getInstance();
		String factString = "padre(juan, pepe).";
		Assert.assertTrue(parser.isValidFactInput(factString));
		Assert.assertEquals(parser.getFactInputName(factString), "padre");
		Assert.assertArrayEquals(parser.getFactInputArgs(factString), new String[]{"juan", "pepe"});
	}
	
	@Test
	public void testValidFactInput_shouldPass_3() {
		InputParser parser = InputParser.getInstance();
		String factString = "varon(alejandro).";
		Assert.assertTrue(parser.isValidFactInput(factString));
		Assert.assertEquals(parser.getFactInputName(factString), "varon");
		Assert.assertArrayEquals(parser.getFactInputArgs(factString), new String[]{"alejandro"});
	}
	
	@Test
	public void testValidFactInput_shouldPass_4() {
		InputParser parser = InputParser.getInstance();
		String factString = "padre(juan, pepa).";
		Assert.assertTrue(parser.isValidFactInput(factString));
		Assert.assertEquals(parser.getFactInputName(factString), "padre");
		Assert.assertArrayEquals(parser.getFactInputArgs(factString), new String[]{"juan", "pepa"});
	}
	
	@Test
	public void testValidFactInput_shouldPass_5() {
		InputParser parser = InputParser.getInstance();
		String factString = "padre(hector, maria).";
		Assert.assertTrue(parser.isValidFactInput(factString));
		Assert.assertEquals(parser.getFactInputName(factString), "padre");
		Assert.assertArrayEquals(parser.getFactInputArgs(factString), new String[]{"hector", "maria"});
	}
	
	@Test
	public void testValidFactInput_shouldPass_6() {
		InputParser parser = InputParser.getInstance();
		String factString = "add(zero, one, one).";
		Assert.assertTrue(parser.isValidFactInput(factString));
		Assert.assertEquals(parser.getFactInputName(factString), "add");
		Assert.assertArrayEquals(parser.getFactInputArgs(factString), new String[]{"zero", "one", "one"});
	}
	
	@Test
	public void testValidFactInput_shouldPass_7() {
		InputParser parser = InputParser.getInstance();
		String factString = "add(zero, zero, zero).";
		Assert.assertTrue(parser.isValidFactInput(factString));
		Assert.assertEquals(parser.getFactInputName(factString), "add");
		Assert.assertArrayEquals(parser.getFactInputArgs(factString), new String[]{"zero", "zero", "zero"});
	}
	
	@Test
	public void testValidFactInput_shouldPass_8() {
		InputParser parser = InputParser.getInstance();
		String factString = "add(zero, two, two).";
		Assert.assertTrue(parser.isValidFactInput(factString));
		Assert.assertEquals(parser.getFactInputName(factString), "add");
		Assert.assertArrayEquals(parser.getFactInputArgs(factString), new String[]{"zero", "two", "two"});
	}
	
	@Test
	public void testValidFactInput_shouldPass_9() {
		InputParser parser = InputParser.getInstance();
		String factString = "mujer(maria).";
		Assert.assertTrue(parser.isValidFactInput(factString));
		Assert.assertEquals(parser.getFactInputName(factString), "mujer");
		Assert.assertArrayEquals(parser.getFactInputArgs(factString), new String[]{"maria"});
	}
	
	@Test
	public void testValidFactInput_shouldPass_10() {
		InputParser parser = InputParser.getInstance();
		String factString = "mujer(cecilia).";
		Assert.assertTrue(parser.isValidFactInput(factString));
		Assert.assertEquals(parser.getFactInputName(factString), "mujer");
		Assert.assertArrayEquals(parser.getFactInputArgs(factString), new String[]{"cecilia"});
	}
	
	@Test
	public void testValidFactInput_withRule_shouldFail_1() {
		InputParser parser = InputParser.getInstance();
		Assert.assertFalse(parser.isValidFactInput("hijo(X, Y) :- varon(X), padre(Y, X)."));
	}
	
	@Test
	public void testValidFactInput_withRule_shouldFail_2() {
		InputParser parser = InputParser.getInstance();
		Assert.assertFalse(parser.isValidFactInput("hija(X, Y) :- mujer(X), padre(Y, X)."));
	}
	
	@Test
	public void testValidFactInput_withRule_shouldFail_3() {
		InputParser parser = InputParser.getInstance();
		Assert.assertFalse(parser.isValidFactInput("subtract(X, Y, Z) :- add(Y, Z, X)."));
	}
	
	/**
	 * Rule Input
	 */
	@Test
	public void testValidRuleInput_shouldPass_1() {
		InputParser parser = InputParser.getInstance();
		Assert.assertTrue(parser.isValidRuleInput("hijo(X, Y) :- varon(X), padre(Y, X)."));
	}
	
	@Test
	public void testValidRuleInput_shouldFail_1() {
		InputParser parser = InputParser.getInstance();
		Assert.assertFalse(parser.isValidRuleInput("hijo"));
	}
	
	@Test
	public void testValidRuleInput_withFact_shouldFail_1() {
		InputParser parser = InputParser.getInstance();
		Assert.assertFalse(parser.isValidRuleInput("varon(juan)."));
	}
	
	@Test
	public void testValidRuleInput_shouldPass_2() {
		InputParser parser = InputParser.getInstance();
		Assert.assertTrue(parser.isValidRuleInput("hija(X, Y) :- mujer(X), padre(Y, X)."));
	}
	
	@Test
	public void testValidRuleInput_shouldPass_3() {
		InputParser parser = InputParser.getInstance();
		Assert.assertTrue(parser.isValidRuleInput("subtract(X, Y, Z) :- add(Y, Z, X)."));
	}
	
	@Test
	public void testValidRuleInput_shouldFail_2() {
		InputParser parser = InputParser.getInstance();
		Assert.assertFalse(parser.isValidRuleInput("hijo(X, Y) :-"));
	}
	
	@Test
	public void testValidRuleInput_shouldFail_3() {
		InputParser parser = InputParser.getInstance();
		Assert.assertFalse(parser.isValidRuleInput("hijo(X, Y) :- mujer"));
	}
	
	@Test
	public void testValidRuleInput_shouldFail_4() {
		InputParser parser = InputParser.getInstance();
		Assert.assertFalse(parser.isValidRuleInput("subtract(X, Y, Z) :- add(Y, Z, X)"));
	}
	
	@Test
	public void testValidRuleInput_shouldFail_5() {
		InputParser parser = InputParser.getInstance();
		Assert.assertFalse(parser.isValidRuleInput("subtract(X, Y, Z) :-add(Y, Z, X)."));
	}
	
	@Test
	public void testValidRuleInput_shouldFail_6() {
		InputParser parser = InputParser.getInstance();
		Assert.assertFalse(parser.isValidRuleInput("hija(X, Y) :- mujer(X),padre(Y, X)."));
	}
	
	
}
