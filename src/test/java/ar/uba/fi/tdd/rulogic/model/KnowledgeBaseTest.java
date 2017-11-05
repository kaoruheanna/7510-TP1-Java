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
	
	private void initKnowledgeParents() {
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

	@Test
	public void testAnswer_parents_shouldPass_1() {
		Assert.assertTrue(this.knowledgeBaseParents.answer("varon(pepe)"));
	}
	
	@Test
	public void testAnswer_parents_shouldFail_1() {
		Assert.assertFalse(this.knowledgeBaseParents.answer("varon(lucia)"));
	}
	
	@Test
	public void testAnswer_parents_shouldPass_2() {
		Assert.assertTrue(this.knowledgeBaseParents.answer("varon(hector)"));
	}
	
	@Test
	public void testAnswer_parents_shouldPass_3() {
		Assert.assertTrue(this.knowledgeBaseParents.answer("mujer(cecilia)"));
	}
	
	@Test
	public void testAnswer_parents_shouldFail_2() {
		Assert.assertFalse(this.knowledgeBaseParents.answer("mujer(pepe)"));
	}
	
	@Test
	public void testAnswer_parents_shouldPass_4() {
		Assert.assertTrue(this.knowledgeBaseParents.answer("padre(juan, pepe)"));
	}
	
	@Test
	public void testAnswer_parents_shouldPass_5() {
		Assert.assertTrue(this.knowledgeBaseParents.answer("padre(hector, maria)"));
	}
	
	@Test
	public void testAnswer_parents_shouldPass_6() {
		Assert.assertTrue(this.knowledgeBaseParents.answer("padre(roberto, cecilia)"));
	}
	

}
