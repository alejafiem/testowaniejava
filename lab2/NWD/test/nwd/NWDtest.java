package nwd;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class NWDtest {
	
	private NWD nwd;
	
	@Before
	public void setUp() throws Exception {
		nwd = new NWD();
	}
	
	@Test
	public void Euklides()
	{
		int result;
		result = nwd.Euklides(5, 10);
		
		assertThat(result, instanceOf(int.class));
		assertThat(result, greaterThan(0));
		assertThat(result, is(notNullValue()));
		assertThat(result, equalTo(5));
	}
	
	@After
	public void tearDown() throws Exception {
		nwd = null;
	}
}
