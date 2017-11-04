package ar.uba.fi.tdd.rulogic.model;

import static org.junit.Assert.*;

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

	// query
	@Test
	public void testValidQuery_shouldPass_1() {
		InputParser parser = InputParser.getInstance();
		Assert.assertTrue(parser.isValidQuery("varon(javier)"));
	}
	
	@Test
	public void testValidQuery_shouldFail_1() {
		InputParser parser = InputParser.getInstance();
		Assert.assertFalse(parser.isValidQuery("varon"));
	}
	
	@Test
	public void testValidQuery_shouldPass__2() {
		InputParser parser = InputParser.getInstance();
		Assert.assertTrue(parser.isValidQuery("varon(lucia)"));
	}
	
	@Test
	public void testValidQuery_shouldPass_3() {
		InputParser parser = InputParser.getInstance();
		Assert.assertTrue(parser.isValidQuery("mujer(lucia)"));
	}
	
	@Test
	public void testValidQuery_shouldPass_4() {
		InputParser parser = InputParser.getInstance();
		Assert.assertTrue(parser.isValidQuery("hijo(pepe, juan)"));
	}
	
	@Test
	public void testValidQuery_shouldPass_5() {
		InputParser parser = InputParser.getInstance();
		Assert.assertTrue(parser.isValidQuery("padre(juan, pepe)"));
	}
	
	@Test
	public void testValidQuery_shouldPass_6() {
		InputParser parser = InputParser.getInstance();
		Assert.assertTrue(parser.isValidQuery("add(two, one, zero)"));
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
		Assert.assertTrue(parser.isValidFactInput("varon(juan)."));
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
		Assert.assertTrue(parser.isValidFactInput("padre(juan, pepe)."));
	}
	
	@Test
	public void testValidFactInput_shouldPass_3() {
		InputParser parser = InputParser.getInstance();
		Assert.assertTrue(parser.isValidFactInput("varon(alejandro)."));
	}
	
	@Test
	public void testValidFactInput_shouldPass_4() {
		InputParser parser = InputParser.getInstance();
		Assert.assertTrue(parser.isValidFactInput("padre(juan, pepa)."));
	}
	
	@Test
	public void testValidFactInput_shouldPass_5() {
		InputParser parser = InputParser.getInstance();
		Assert.assertTrue(parser.isValidFactInput("padre(hector, maria)."));
	}
	
	@Test
	public void testValidFactInput_shouldPass_6() {
		InputParser parser = InputParser.getInstance();
		Assert.assertTrue(parser.isValidFactInput("add(zero, one, one)."));
	}
	
	@Test
	public void testValidFactInput_shouldPass_7() {
		InputParser parser = InputParser.getInstance();
		Assert.assertTrue(parser.isValidFactInput("add(zero, zero, zero)."));
	}
	
	@Test
	public void testValidFactInput_shouldPass_8() {
		InputParser parser = InputParser.getInstance();
		Assert.assertTrue(parser.isValidFactInput("add(zero, two, two)."));
	}
	
	@Test
	public void testValidFactInput_shouldPass_9() {
		InputParser parser = InputParser.getInstance();
		Assert.assertTrue(parser.isValidFactInput("mujer(maria)."));
	}
	
	@Test
	public void testValidFactInput_shouldPass_10() {
		InputParser parser = InputParser.getInstance();
		Assert.assertTrue(parser.isValidFactInput("mujer(cecilia)."));
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
