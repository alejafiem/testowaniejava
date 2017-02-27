package introductionHamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SquareArrayTest {
	
	private SquareArray array; 

	@Before
	public void setUp() throws Exception {
		array = new SquareArray();
	}
	
	@Test
	public void getArray(){
		array.setList(Arrays.asList(1,2,3));
		List <Integer> tempList = array.getList();
		assertThat(tempList,contains(1,2,3));
	}
	
	@Test
	public void findIndexOfElement(){
		array.setList(Arrays.asList(1,2,3));
		int index = array.findIndexOfElement(2);
		assertThat(index, equalTo(1));
		index = array.findIndexOfElement(3);
		assertThat(index, equalTo(2));
		index = array.findIndexOfElement(997);
		assertThat(index, is(notNullValue()));					
		assertThat(index, equalTo(-1));
	}
	
	@Test
	public void doubleElement(){
		array.setList(Arrays.asList(1,2,3));
		assertThat(array.getList().size(), equalTo(3));
		array.doubleElement(2);
		assertThat(array.getList().get(2), equalTo(6));
		assertThat(array.getList().get(0), equalTo(1));
		assertThat(array.getList().get(1), equalTo(2));
		assertThat(array.getList().size(), equalTo(3));
	}
	
	@Test
	public void isElementEven(){
		array.setList(Arrays.asList(1,2,3));
		assertThat(array.isElementEven(2), equalTo(false));
		assertThat(array.isElementEven(1), equalTo(true));
	}
	
	@After
	public void tearDown() throws Exception {
		array = null;
	}
	
}
