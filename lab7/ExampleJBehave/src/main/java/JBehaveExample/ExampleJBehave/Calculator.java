package JBehaveExample.ExampleJBehave;

public class Calculator {
	
	private int left,right;

	public int add(int a, int b){
		return a+b;
	}
	
	public int substract(int a, int b){
		return a-b;
	}
	
	public int multiply(int a, int b){
		return a*b;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}
}
