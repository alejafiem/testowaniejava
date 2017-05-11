package CustomMatcher.Matcher;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicTest {

	Person person;
	
	@Before
	public void setUp() throws Exception {
		person = new Person();
	}

	@After
	public void tearDown() throws Exception {
		person = null;
	}

	@Test
	public void testHasName() {
		person.setFirstName("Justin");
		assertThat(person.getFirstName(),is("Justin"));
	}

}
