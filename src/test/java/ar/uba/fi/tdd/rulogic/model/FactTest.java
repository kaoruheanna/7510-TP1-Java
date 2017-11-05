package ar.uba.fi.tdd.rulogic.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FactTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAnswer_shouldPass_1() {
		ArrayList<String> factArgs = new ArrayList<String>(Arrays.asList("Javier"));
		Fact fact = new Fact("varon",factArgs);
		
		ArrayList<String> args = new ArrayList<String>(factArgs);
		Query query = new Query("varon",args);
		Assert.assertTrue(fact.answer(query));
	}
	
	@Test
	public void testAnswer_withDifferentName_shouldFail_1() {
		ArrayList<String> factArgs = new ArrayList<String>(Arrays.asList("Javier"));
		Fact fact = new Fact("varon",factArgs);
		
		ArrayList<String> args = new ArrayList<String>(factArgs);
		Query query = new Query("mujer",args);
		
		Assert.assertFalse(fact.answer(query));
	}
	
	@Test
	public void testAnswer_shouldPass_2() {
		ArrayList<String> factArgs = new ArrayList<String>(Arrays.asList("Maria"));
		Fact fact = new Fact("mujer",factArgs);
		
		ArrayList<String> args = new ArrayList<String>(factArgs);
		Query query = new Query("mujer",args);
		
		Assert.assertTrue(fact.answer(query));
	}
	
	@Test
	public void testAnswer_withDifferentArgs_shouldFail_1() {
		ArrayList<String> factArgs = new ArrayList<String>(Arrays.asList("Javier"));
		Fact fact = new Fact("varon",factArgs);
		
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("Maria"));
		Query query = new Query("varon",args);
		
		Assert.assertFalse(fact.answer(query));
	}
	
	@Test
	public void testAnswer_withDifferentArgs_shouldFail_2() {
		ArrayList<String> factArgs = new ArrayList<String>();
		factArgs.add("Javier");
		Fact fact = new Fact("varon",factArgs);
		
		ArrayList<String> args = new ArrayList<String>();
		args.add("Lucia");
		Query query = new Query("varon",args);
		
		Assert.assertFalse(fact.answer(query));
	}
	
	@Test
	public void testAnswer_shouldPass_3() {
		ArrayList<String> factArgs = new ArrayList<String>();
		factArgs.add("Lucia");
		Fact fact = new Fact("mujer",factArgs);
		
		ArrayList<String> args = new ArrayList<String>();
		args.add("Lucia");
		Query query = new Query("mujer",args);
		
		Assert.assertTrue(fact.answer(query));
	}
	
	@Test
	public void testAnswer_shouldPass_4() {
		ArrayList<String> factArgs = new ArrayList<String>(Arrays.asList("Hector","Maria"));
		Fact fact = new Fact("padre",factArgs);
		
		ArrayList<String> args = new ArrayList<String>(factArgs);
		Query query = new Query("padre",args);
		
		Assert.assertTrue(fact.answer(query));
	}
	
	@Test
	public void testAnswer_shouldPass_5() {
		ArrayList<String> factArgs = new ArrayList<String>(Arrays.asList("Roberto","Cecilia"));
		Fact fact = new Fact("padre",factArgs);
		
		ArrayList<String> args = new ArrayList<String>(factArgs);
		Query query = new Query("padre",args);
		
		Assert.assertTrue(fact.answer(query));
	}
	
	@Test
	public void testAnswer_shouldPass_6() {
		ArrayList<String> factArgs = new ArrayList<String>(Arrays.asList("zero", "zero", "zero"));
		Fact fact = new Fact("add",factArgs);
		
		ArrayList<String> args = new ArrayList<String>(factArgs);
		Query query = new Query("add",args);
		
		Assert.assertTrue(fact.answer(query));
	}
	
	@Test
	public void testAnswer_shouldPass_7() {
		ArrayList<String> factArgs = new ArrayList<String>(Arrays.asList("one", "two", "three"));
		Fact fact = new Fact("add",factArgs);
		
		ArrayList<String> args = new ArrayList<String>(factArgs);
		Query query = new Query("add",args);
		
		Assert.assertTrue(fact.answer(query));
	}
	
	@Test
	public void testAnswer_withDifferentArgs_shouldFail_3() {
		ArrayList<String> factArgs = new ArrayList<String>(Arrays.asList("Roberto","Cecilia"));
		Fact fact = new Fact("padre",factArgs);
		
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("Roberto","Maria"));
		Query query = new Query("padre",args);
		
		Assert.assertFalse(fact.answer(query));
	}
	
	@Test
	public void testAnswer_withDifferentArgs_shouldFail_8() {
		ArrayList<String> factArgs = new ArrayList<String>(Arrays.asList("one", "two", "three"));
		Fact fact = new Fact("add",factArgs);
		
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("zero", "zero", "zero"));
		Query query = new Query("add",args);
		
		Assert.assertFalse(fact.answer(query));
	}
	
	@Test
	public void testAnswer_withLessArgs_shouldFail_1() {
		ArrayList<String> factArgs = new ArrayList<String>(Arrays.asList("Roberto","Cecilia"));
		Fact fact = new Fact("padre",factArgs);
		
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("Roberto"));
		Query query = new Query("padre",args);
		
		Assert.assertFalse(fact.answer(query));
	}
	
	@Test
	public void testAnswer_withMoreArgs_shouldFail_1() {
		ArrayList<String> factArgs = new ArrayList<String>(Arrays.asList("one", "two", "three"));
		Fact fact = new Fact("add",factArgs);
		
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("one", "two", "three", "four"));
		Query query = new Query("add",args);
		
		Assert.assertFalse(fact.answer(query));
	}
	
	@Test
	public void testAnswer_withUnorderedArgs_shouldFail_1() {
		ArrayList<String> factArgs = new ArrayList<String>(Arrays.asList("one", "two", "three"));
		Fact fact = new Fact("add",factArgs);
		
		ArrayList<String> args = new ArrayList<String>(Arrays.asList("three", "two", "one"));
		Query query = new Query("add",args);
		
		Assert.assertFalse(fact.answer(query));
	}

}
