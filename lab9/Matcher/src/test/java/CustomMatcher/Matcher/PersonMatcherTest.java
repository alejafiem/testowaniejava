package CustomMatcher.Matcher;

import static org.hamcrest.MatcherAssert.*;
import static CustomMatcher.Matcher.PersonMatcher.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonMatcherTest {
	
	Person test;

	@Before
	public void setUp() throws Exception {
		test = new Person();
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}

	@Test
	public void testMatcherCorrect() {
		test.setFirstName("Justin");
		assertThat(test,hasFirstName("Justin"));
	}
	
	@Test
	public void testMatcherInCorrect() {
		test.setFirstName("Justin");
		assertThat(test,hasFirstName("Justin Bieber"));
	}
	
	@Test
	public void testMatcherIsOlder()
	{
		test.setAge(20);
		assertThat(test, isOlder(18));
	}
	
	@Test
	public void testMatcherIsOlderInCorrect()
	{
		test.setAge(12);
		assertThat(test, isOlder(18));
	}
	
	@Test
	public void testMatcherIsLower()
	{
		test.setHeight(1.82);
		assertThat(test, isLower(1.99));
	}
	
	@Test
	public void testMatcherIsLowerInCorrect()
	{
		test.setHeight(2.01);
		assertThat(test, isLower(1.99));
	}
}
