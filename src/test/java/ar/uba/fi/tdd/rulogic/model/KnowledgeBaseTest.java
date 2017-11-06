package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class KnowledgeBaseTest {

	private KnowledgeBase knowledgeBaseParents;

	@Before
	public void setUp() throws Exception {
		this.initKnowledgeParents();
	}
	
	private void initKnowledgeParents() throws Exception {
		String fullInput = "varon(juan).\n" + 
				"varon(pepe).\n" + 
				"varon(hector).\n" + 
				"varon(roberto).\n" + 
				"varon(alejandro).\n" + 
				"mujer(maria).\n" + 
				"mujer(cecilia).\n" + 
				"padre(juan, pepe).\n" + 
				"padre(juan, pepa).\n" + 
				"padre(hector, maria).\n" + 
				"padre(roberto, alejandro).\n" + 
				"padre(roberto, cecilia).\n" + 
				"hijo(X, Y) :- varon(X), padre(Y, X).\n" + 
				"hija(X, Y) :- mujer(X), padre(Y, X).";
		
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
		Assert.assertTrue(this.knowledgeBaseParents.answer("varon(pepe)"));
	}
	
	@Test
	public void testAnswer_parents_shouldFail_1() throws Exception {
		Assert.assertFalse(this.knowledgeBaseParents.answer("varon(lucia)"));
	}
	
	@Test
	public void testAnswer_parents_shouldPass_2() throws Exception{
		Assert.assertTrue(this.knowledgeBaseParents.answer("varon(hector)"));
	}
	
	@Test
	public void testAnswer_parents_shouldPass_3() throws Exception{
		Assert.assertTrue(this.knowledgeBaseParents.answer("mujer(cecilia)"));
	}
	
	@Test
	public void testAnswer_parents_shouldFail_2() throws Exception{
		Assert.assertFalse(this.knowledgeBaseParents.answer("mujer(pepe)"));
	}
	
	@Test
	public void testAnswer_parents_shouldPass_4() throws Exception {
		Assert.assertTrue(this.knowledgeBaseParents.answer("padre(juan, pepe)"));
	}
	
	@Test
	public void testAnswer_parents_shouldPass_5() throws Exception {
		Assert.assertTrue(this.knowledgeBaseParents.answer("padre(hector, maria)"));
	}
	
	@Test
	public void testAnswer_parents_shouldPass_6() throws Exception {
		Assert.assertTrue(this.knowledgeBaseParents.answer("padre(roberto, cecilia)"));
	}
	
	/*
	 * Rules
	 */
	@Test
	public void testAnswer_hijo_shouldPass_1() throws Exception {
		Assert.assertTrue(this.knowledgeBaseParents.answer("hijo(pepe, juan)"));
	}
	
	@Test
	public void testAnswer_hijo_shouldFail_1() throws Exception {
		Assert.assertFalse(this.knowledgeBaseParents.answer("hija(maria, roberto)"));
	}
	
	@Test
	public void testAnswer_hijo_shouldPass_2() throws Exception {
		Assert.assertTrue(this.knowledgeBaseParents.answer("hijo(alejandro, roberto)"));
	}
	
	@Test
	public void testAnswer_hijo_shouldPass_3() throws Exception {
		Assert.assertTrue(this.knowledgeBaseParents.answer("hija(maria, hector)"));
	}
	
	@Test
	public void testAnswer_hijo_shouldPass_4() throws Exception {
		Assert.assertTrue(this.knowledgeBaseParents.answer("hija(cecilia, roberto)"));
	}
	
	@Test
	public void testAnswer_hijo_shouldFail_2() throws Exception {
		Assert.assertFalse(this.knowledgeBaseParents.answer("hija(roberto, cecilia)"));
	}
	
	@Test
	public void testAnswer_hijo_shouldFail_3() throws Exception {
		Assert.assertFalse(this.knowledgeBaseParents.answer("hijo(cecilia, roberto)"));
	}
	
}
