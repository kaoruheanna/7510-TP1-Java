package ar.uba.fi.tdd.rulogic.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueryTemplateTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testQuery_withOneArgument_shouldPass_1() {
		ArrayList<String> templateArgs = new ArrayList<String>(Arrays.asList("X"));
		QueryTemplate template = new QueryTemplate("varon",templateArgs);
		
		ArrayList<String> keys = new ArrayList<String>(Arrays.asList("X"));
		ArrayList<String> values = new ArrayList<String>(Arrays.asList("Roberto"));
		ArgumentsMap map = new ArgumentsMap(keys, values);
		Query query = template.getQuery(map);
		
		Assert.assertEquals(query.getName(),"varon");
		Assert.assertEquals(query.getArguments(),new ArrayList<String>(Arrays.asList("Roberto")));
	}
	
	@Test
	public void testQuery_shouldPass_2() {
		ArrayList<String> templateArgs = new ArrayList<String>(Arrays.asList("X"));
		QueryTemplate template = new QueryTemplate("mujer",templateArgs);
		
		ArrayList<String> keys = new ArrayList<String>(Arrays.asList("X"));
		ArrayList<String> values = new ArrayList<String>(Arrays.asList("Cecilia"));
		ArgumentsMap map = new ArgumentsMap(keys, values);
		Query query = template.getQuery(map);
		
		Assert.assertEquals(query.getName(),"mujer");
		Assert.assertEquals(query.getArguments(),new ArrayList<String>(Arrays.asList("Cecilia")));
		Assert.assertNotEquals(query.getArguments(),new ArrayList<String>(Arrays.asList("Maria")));
	}

	@Test
	public void testQuery_withDifferentName_shouldFail_1() {
		ArrayList<String> templateArgs = new ArrayList<String>(Arrays.asList("X"));
		QueryTemplate template = new QueryTemplate("mujer", templateArgs);
		
		ArrayList<String> keys = new ArrayList<String>(Arrays.asList("X"));
		ArrayList<String> values = new ArrayList<String>(Arrays.asList("Cecilia"));
		ArgumentsMap map = new ArgumentsMap(keys, values);
		Query query = template.getQuery(map);
		
		Assert.assertEquals(query.getArguments(),new ArrayList<String>(Arrays.asList("Cecilia")));
		Assert.assertNotEquals(query.getName(),"varon");
	}
	
	@Test
	public void testQuery_withSeveralArguments_shouldPass_1() {
		ArrayList<String> templateArgs = new ArrayList<String>(Arrays.asList("Y", "Z", "X"));
		QueryTemplate template = new QueryTemplate("add",templateArgs);
		
		ArrayList<String> keys = new ArrayList<String>(Arrays.asList("X", "Y", "Z"));
		ArrayList<String> values = new ArrayList<String>(Arrays.asList("one", "two", "three"));
		ArgumentsMap map = new ArgumentsMap(keys, values);
		Query query = template.getQuery(map);
		
		Assert.assertEquals(query.getName(),"add");
		Assert.assertEquals(query.getArguments(),new ArrayList<String>(Arrays.asList("two", "three", "one")));
	}
	
	@Test
	public void testQuery_withSeveralArguments_shouldPass_2() {
		ArrayList<String> templateArgs = new ArrayList<String>(Arrays.asList("Y", "Z", "X"));
		QueryTemplate template = new QueryTemplate("add",templateArgs);
		
		ArrayList<String> keys = new ArrayList<String>(Arrays.asList("X", "Y", "Z"));
		ArrayList<String> values = new ArrayList<String>(Arrays.asList("equis", "y griega", "zeta"));
		ArgumentsMap map = new ArgumentsMap(keys, values);
		Query query = template.getQuery(map);
		
		Assert.assertEquals(query.getName(),"add");
		Assert.assertEquals(query.getArguments(),new ArrayList<String>(Arrays.asList("y griega", "zeta", "equis")));
	}
	
	@Test
	public void testQuery_withSeveralArguments_shouldPass_3() {
		ArrayList<String> templateArgs = new ArrayList<String>(Arrays.asList("Z"));
		QueryTemplate template = new QueryTemplate("add",templateArgs);
		
		ArrayList<String> keys = new ArrayList<String>(Arrays.asList("X", "Y", "Z"));
		ArrayList<String> values = new ArrayList<String>(Arrays.asList("equis", "y griega", "zeta"));
		ArgumentsMap map = new ArgumentsMap(keys, values);
		Query query = template.getQuery(map);
		
		Assert.assertEquals(query.getName(),"add");
		Assert.assertEquals(query.getArguments(),new ArrayList<String>(Arrays.asList("zeta")));
	}

}
