package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArgumentsMapTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ArrayList<String> keys = new ArrayList<String>(Arrays.asList("X", "Y", "Z"));
		ArrayList<String> values = new ArrayList<String>(Arrays.asList("one", "two", "three"));
		ArgumentsMap map = new ArgumentsMap(keys, values);
		Assert.assertEquals(map.getForKey("X"),"one");
		Assert.assertEquals(map.getForKey("Y"),"two");
		Assert.assertEquals(map.getForKey("Z"),"three");
	}
	
	@Test
	public void test2() {
		ArrayList<String> keys = new ArrayList<String>(Arrays.asList("X", "Y", "Z"));
		ArrayList<String> values = new ArrayList<String>(Arrays.asList("one", "two", "one"));
		ArgumentsMap map = new ArgumentsMap(keys, values);
		Assert.assertEquals(map.getForKey("X"),"one");
		Assert.assertEquals(map.getForKey("Y"),"two");
		Assert.assertEquals(map.getForKey("Z"),"one");
	}

}
