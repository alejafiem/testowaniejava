package JBehaveExample.ExampleJBehave;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SimpleTest {

	private Calculator test;
	
	private int inputA;
	private int inputB;
	private int output;
	
	@Parameters
    public static Collection<Object[]> data() {
        Object[][] c = {
        		{9,8,17}, {12,24,36}, {13,12,25}, {100,25,125}
   		};
        return  Arrays.asList(c);
    }
    
	@Before
	public void setUp(){
		 test = new Calculator();
	}
	
	public SimpleTest(int a, int b, int c){
		inputA = a;
		inputB = b;
		output = c;
	}
	
	@Test
	public void testAdd() {
		assertEquals(output,test.add(inputA, inputB));
	}

	@After
	public void teardown(){
		test = null;
	}
	
}
