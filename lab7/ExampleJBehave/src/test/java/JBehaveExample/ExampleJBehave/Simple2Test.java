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
public class Simple2Test {

	private Calculator test;
	
	private int inputA;
	private int inputB;
	private int output;
	
	@Parameters
    public static Collection<Object[]> data() {
        Object[][] c = {
        		{9,8,1}, {12,24,-12}, {13,12,1}, {100,25,75}
   		};
        return  Arrays.asList(c);
    }
    
	@Before
	public void setUp(){
		 test = new Calculator();
	}
	
	public Simple2Test(int a, int b, int c){
		inputA = a;
		inputB = b;
		output = c;
	}
	
	@Test
	public void testAdd() {
		assertEquals(output,test.substract(inputA, inputB));
	}

	@After
	public void teardown(){
		test = null;
	}
	
}
