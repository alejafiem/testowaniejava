package MockExamples.MockExamples;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;

import java.util.Arrays;
import java.util.List;

@RunWith(EasyMockRunner.class)
public class FriendshipsMongoEasyMockTest {

	@TestSubject
	FriendshipsMongo friendships = new FriendshipsMongo();
	
	//A nice mock expects recorded calls in any order and returning null for other calls
	@Mock(type = MockType.NICE)
	FriendsCollection friends;
	
	@Test
	public void mockingWorksAsExpected(){
		Person joe = new Person("Joe");
		//Zapisanie zachowania - co sie ma stac
		expect(friends.findByName("Joe")).andReturn(joe);
		//Odpalenie obiektu do sprawdzenia zachowania
		replay(friends);
		assertThat(friends.findByName("Joe")).isEqualTo(joe);
	}
	
	@Test
	public void alexDoesNotHaveFriends(){
		assertThat(friendships.getFriendsList("Alex")).isEmpty();
	}
	
	@Test
	public void joeHas5Friends(){
		List<String> expected = Arrays.asList(new String[]{"Karol","Dawid","Maciej","Tomek","Adam"});
		Person joe = createMock(Person.class);
		expect(friends.findByName("Joe")).andReturn(joe);
		expect(joe.getFriends()).andReturn(expected);
		replay(friends);
		replay(joe);
		assertThat(friendships.getFriendsList("Joe")).hasSize(5).containsOnly("Karol","Dawid","Maciej","Tomek","Adam");
	}
	
	@Test
	public void joeAndAlexAreFriends(){
		Person joe = createMock(Person.class);
		Person alex = createMock(Person.class);
				
		List<String> expected1 = Arrays.asList(new String[]{"Alex"});
		List<String> expected2 = Arrays.asList(new String[]{"Joe"});
		
		expect(friends.findByName("Joe")).andReturn(joe);
		expect(friends.findByName("Alex")).andReturn(alex);	
		
		expect(joe.getFriends()).andReturn(expected1);
		expect(alex.getFriends()).andReturn(expected2);
		
		replay(friends);
		replay(joe);
		replay(alex);
		
		assertThat(friendships.areFriends("Joe", "Alex"));				
		
	}
	
	@Test
	public void addAlexToJoe(){
		Person joe = createMock(Person.class);

		expect(friends.findByName("Joe")).andReturn(joe);	
		
		replay(friends);
		
		friendships.addFriend("Joe", "Alex");
		
		assertThat(friendships.areFriends("Joe", "Alex"));
	}
	
	@Test
	public void makeJoeAndAlexFriends(){
		Person joe = createMock(Person.class);
		Person alex = createMock(Person.class);

		expect(friends.findByName("Joe")).andReturn(joe);
		expect(friends.findByName("Alex")).andReturn(alex);
		
		replay(friends);
		
		friendships.addFriend("Joe", "Alex");
		
		assertThat(friendships.areFriends("Joe", "Alex"));
	}
	
}
