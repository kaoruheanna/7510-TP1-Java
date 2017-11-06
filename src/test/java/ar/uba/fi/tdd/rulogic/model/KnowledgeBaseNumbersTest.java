package ar.uba.fi.tdd.rulogic.model;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KnowledgeBaseNumbersTest {

	private KnowledgeBase knowledgeBaseParents;

	@Before
	public void setUp() throws Exception {
		this.initKnowledge();
	}
	
	private void initKnowledge() throws Exception {
		String fullInput = "add(zero, zero, zero).\n" + 
				"add(zero, one, one).\n" + 
				"add(zero, two, two).\n" + 
				"add(one, zero, one).\n" + 
				"add(one, one, two).\n" + 
				"add(one, two, zero).\n" + 
				"add(two, zero, two).\n" + 
				"add(two, one, zero).\n" + 
				"add(two, two, one).\n" + 
				"subtract(X, Y, Z) :- add(Y, Z, X).";
		
		this.knowledgeBaseParents = new KnowledgeBase();
		for (String input : fullInput.split("\n")) {
			this.knowledgeBaseParents.learn(input);
		}
	}
	
	/*
	 * Facts
	 */
	@Test
	public void testAnswer_parents_shouldPass_1() throws Exception {
		Assert.assertTrue(this.knowledgeBaseParents.answer("add(zero, zero, zero)"));
	}
	
	@Test
	public void testAnswer_parents_shouldPass_2() throws Exception {
		Assert.assertTrue(this.knowledgeBaseParents.answer("add(two, one, zero)"));
	}
	
	@Test
	public void testAnswer_parents_shouldPass_3() throws Exception {
		Assert.assertTrue(this.knowledgeBaseParents.answer("add(two, zero, two)"));
	}
	
	@Test
	public void testAnswer_parents_shouldFail_1() throws Exception {
		Assert.assertFalse(this.knowledgeBaseParents.answer("add(two, one, one)"));
	}
	
	@Test
	public void testAnswer_parents_shouldFail_2() throws Exception {
		Assert.assertFalse(this.knowledgeBaseParents.answer("add(two, one, eleven)"));
	}
	
	/*
	 * Rule
	 */
	@Test
	public void testAnswer_subtract_shouldPass_1() throws Exception {
		Assert.assertTrue(this.knowledgeBaseParents.answer("subtract(two, one, one)"));
	}
	
	@Test
	public void testAnswer_subtract_shouldFail_1() throws Exception {
		Assert.assertFalse(this.knowledgeBaseParents.answer("subtract(one, one, two)"));
	}
	
	@Test
	public void testAnswer_subtract_shouldFail_2() throws Exception {
		Assert.assertFalse(this.knowledgeBaseParents.answer("root(two, one)"));
	}
}
