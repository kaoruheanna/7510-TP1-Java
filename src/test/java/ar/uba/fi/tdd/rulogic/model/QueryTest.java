package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueryTest {

	private Query query;
	
	@Before
	public void setUp() throws Exception {
		ArrayList<String> args = new ArrayList<String>();
		args.add("Juan");
		args.add("Lucas");
		args.add("Marcos");
		query = new Query("hermanos",args);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetName_shouldPass() {
		Assert.assertEquals(query.getName(),"hermanos");
	}
	
	@Test
	public void testGetName_shouldFail() {
		Assert.assertNotEquals(query.getName(),"sobrinos");
	}
	
	@Test
	public void testGetArguments_shouldPass() {
		ArrayList<String> args = new ArrayList<String>();
		args.add("Juan");
		args.add("Lucas");
		args.add("Marcos");
		Assert.assertEquals(query.getArguments(),args);
	}
	
	@Test
	public void testGetArguments_withLessArguments_shouldFail() {
		ArrayList<String> args = new ArrayList<String>();
		args.add("Juan");
		args.add("Lucas");
		Assert.assertNotEquals(query.getArguments(),args);
	}
	
	@Test
	public void testGetArguments_withMoreArguments_shouldFail() {
		ArrayList<String> args = new ArrayList<String>();
		args.add("Juan");
		args.add("Lucas");
		args.add("Marcos");
		args.add("Rodrigo");
		Assert.assertNotEquals(query.getArguments(),args);
	}
	
	@Test
	public void testGetArguments_withUnorderedArguments_shouldFail() {
		ArrayList<String> args = new ArrayList<String>();
		args.add("Juan");
		args.add("Marcos");
		args.add("Lucas");
		Assert.assertNotEquals(query.getArguments(),args);
	}

}
