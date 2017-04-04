package JBehaveExample.ExampleJBehave;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ SimpleTest.class, Simple2Test.class })
public class AllTests {
  
}