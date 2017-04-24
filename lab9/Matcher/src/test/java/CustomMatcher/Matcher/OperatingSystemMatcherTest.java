package CustomMatcher.Matcher;

import static org.hamcrest.MatcherAssert.*;
import static CustomMatcher.Matcher.OperatingSystemMatcher.*;
import static org.hamcrest.Matchers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OperatingSystemMatcherTest {
	
	OperatingSystem test;

	@Before
	public void setUp() throws Exception {
		test = new OperatingSystem();
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}

	@Test
	public void test1()
	{
		test.setName("Okna 1o");
		test.setNbOfBits(128);
		test.setVersion("0.1");
		
		assertThat(test, allOf(is128Bit(), hasName(), hasVersion("0.1")));
	}
	
	@Test
	public void test2()
	{
		test.setNbOfBits(256);
		test.setVersion("0.1");
		test.setReleaseYear(2014);
		
		assertThat(test, anyOf(is128Bit(), hasName(), hasVersion("0.8"), wasReleasedIn(2014)));
	}
	
	@Test
	public void test3()
	{
		test.setName("Elo");
		test.setNbOfBits(256);
		test.setVersion("0.1");
		test.setReleaseYear(2014);
		
		assertThat(test, allOf(is128Bit(), hasName(), wasReleasedIn(2014)));
	}
}

