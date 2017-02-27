package introductionHamcrest;

import java.util.List;

public class SquareArray {
	
	private List<Integer> list;

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}
	
	public int findIndexOfElement(int element)
	{
		int index = this.list.indexOf(element);
		return index;
	}
	
	public void doubleElement(int index)
	{
		int element = this.list.get(index);
		element = element * 2;
		list.set(index, element);
	}
	
	public boolean isElementEven(int index)
	{
		int element = this.list.get(index);
		if((element % 2 ) == 0)
			return true;
		else
			return false;
	}
	
}
