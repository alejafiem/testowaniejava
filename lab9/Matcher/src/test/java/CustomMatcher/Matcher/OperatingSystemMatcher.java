package CustomMatcher.Matcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class OperatingSystemMatcher {
	  public static Matcher<OperatingSystem> is128Bit(){
		  return new TypeSafeMatcher<OperatingSystem>(){

			public void describeTo(final Description description) {
				description.appendText("expected result from getNbOfBits(): 128");
			}

			@Override
			public boolean matchesSafely(OperatingSystem os) {
			
				return os.getNbOfBits() == 128;
			}
			
			public void describeMismatchSafely(final OperatingSystem os, final Description mismatchDescription) {
				mismatchDescription.appendText("was ").appendValue(os.getNbOfBits());
			}
		  };
	  }
	  
	  public static Matcher<OperatingSystem> hasName(){
		  return new TypeSafeMatcher<OperatingSystem>(){

			public void describeTo(final Description description) {
				description.appendText("expected result from getName() to not be empty");
			}

			@Override
			public boolean matchesSafely(OperatingSystem os) {
			
				return os.getName() != "";
			}
			
			public void describeMismatchSafely(final OperatingSystem os, final Description mismatchDescription) {
				mismatchDescription.appendText("was ").appendValue(os.getName());
			}
		  };
	  }
	  
	  public static Matcher<OperatingSystem> wasReleasedIn(final int year){
		  return new TypeSafeMatcher<OperatingSystem>(){

			public void describeTo(final Description description) {
				description.appendText("expected result from getReleaseYear() : ").appendValue(year);;
			}

			@Override
			public boolean matchesSafely(OperatingSystem os) {
			
				return os.getReleaseYear() == year;
			}
			
			public void describeMismatchSafely(final OperatingSystem os, final Description mismatchDescription) {
				mismatchDescription.appendText("was ").appendValue(os.getReleaseYear());
			}
		  };
	  }
	  
	  public static Matcher<OperatingSystem> hasVersion(final String version){
		  return new TypeSafeMatcher<OperatingSystem>(){

			public void describeTo(final Description description) {
				description.appendText("expected result from getVersion() : ").appendValue(version);;
			}

			@Override
			public boolean matchesSafely(OperatingSystem os) {
			
				return version.equals(os.getVersion());
			}
			
			public void describeMismatchSafely(final OperatingSystem os, final Description mismatchDescription) {
				mismatchDescription.appendText("was ").appendValue(os.getVersion());
			}
		  };
	  }
}

