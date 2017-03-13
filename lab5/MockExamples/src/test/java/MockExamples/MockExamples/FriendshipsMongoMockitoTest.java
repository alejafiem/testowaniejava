package MockExamples.MockExamples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// Ta linia jest wymagana
@RunWith(MockitoJUnitRunner.class)
public class FriendshipsMongoMockitoTest {
	
	//Nasza atrapa
	@InjectMocks
	FriendshipsMongo friendships;
	
	//Co zastepujemy
	@Mock
	FriendsCollection friends;
	
	
	@Test
	public void mockingWorskAsExpected(){
		Person joe = new Person("Joe");
		doReturn(joe).when(friends).findByName("Joe");
		assertThat(friends.findByName("Joe")).isEqualTo(joe);
	}
	
	@Test
	public void alexDoesNotHaveFriends(){
		assertThat(friendships.getFriendsList("Alex")).isEmpty();
	}
	
	@Test
	public void joeHas5Friends(){
		List<String> expected = Arrays.asList(new String[]{"Karol","Dawid","Maciej","Tomek","Adam"});
		//Spy przechwytuje wywołania z przekazywanymi pośrednio danymi w celu
		// późniejszego zbadania tych danych w teście - tutaj w przykładzie lista przyjaciół Joe
		Person joe = spy(new Person("Joe"));
		doReturn(joe).when(friends).findByName("Joe");
		doReturn(expected).when(joe).getFriends();
		assertThat(friendships.getFriendsList("Joe")).hasSize(5).containsOnly("Karol","Dawid","Maciej","Tomek","Adam");
	}

	@Test
    public void joeAndAlexAreFriends() {
        Person p1 = spy(new Person("Joe"));
        Person p2 = spy(new Person("Alex"));
       
        doReturn(p1).when(friends).findByName("Joe");
        doReturn(p2).when(friends).findByName("Alex");
       
        doReturn(Arrays.asList("Alex")).when(p1).getFriends();
        doReturn(Arrays.asList("Joe")).when(p2).getFriends();
       
        assertThat(friendships.areFriends("Joe", "Alex"));
    }
   
    @Test
    public void addAlexToJoe() {
        Person p1 = spy(new Person("Joe"));
       
        doReturn(p1).when(friends).findByName("Joe");
       
        friendships.addFriend("Joe", "Alex");
       
        assertThat(friendships.getFriendsList("Joe")).hasSize(1).containsOnly("Alex");
    }
   
    @Test
    public void makeJoeAndAlexFriends() {
        Person p1 = spy(new Person("Joe"));
        Person p2 = spy(new Person("Alex"));
       
        doReturn(p1).when(friends).findByName("Joe");
        doReturn(p2).when(friends).findByName("Alex");
       
        friendships.makeFriends("Joe", "Alex");
       
        assertThat(friendships.getFriendsList("Joe")).hasSize(1).containsOnly("Alex");;
    }
}
