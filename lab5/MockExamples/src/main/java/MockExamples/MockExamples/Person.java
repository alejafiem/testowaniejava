package MockExamples.MockExamples;

import java.util.ArrayList;
import java.util.List;

public class Person {
  
  public String name;
  private List<String> friends;
  
  public Person() { }
  
  public Person(String name){
	  this.name = name;
	  setFriends(new ArrayList<String>());
  }

  public List<String> getFriends() {
	return friends;
  }

  public void setFriends(List<String> friends) {
	this.friends = friends;
  }

  public void addFriend(String name){
	  if(!friends.contains(name)){
		  friends.add(name);
	  }
  }
  
}
