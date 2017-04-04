package JBehaveExample.ExampleJBehave;

import org.jbehave.core.annotations.*;
import static org.junit.Assert.*;
public class CalculatorStepsRunner2{
	
	private Calculator test;
	
	/*@Given("mam nowy kalkulator")
	public void givenMamUtworzonyNowyKalkulator(){
		test = new Calculator();
	}
	@Then("po dodaniu otrzymam <output>")
	@Alias("bede mial <output>")
	public void thenPoDodaniu(@Named("output") int output){
		 assertEquals(output,test.add(test.getLeft(), test.getRight()));
	}
	@When("dodam oba parametry <a> i <b>")
	@Alias("<a> i <b> zostana dodane")
	public void whenDodamLiczby(@Named("a") int a, @Named("b") int b){
		 test.setLeft(a);
		 test.setRight(b);
	}
	
	@AfterScenario(uponOutcome=AfterScenario.Outcome.SUCCESS,uponType=ScenarioType.EXAMPLE)
	public void sucess() {
	    System.out.println("sukces");
	}
	     
	@AfterScenario(uponOutcome=AfterScenario.Outcome.FAILURE,uponType=ScenarioType.EXAMPLE)
	public void fail() {
		System.out.println("fail");
	}*/
	
	
	@Given("mam nowy kalkulator i a rowne 0")
	public void givenMamUtworzonyNowyKalkulator(){
		test = new Calculator();
		 test.setLeft(0);
	}
	
	@Then("bede mial 0")
	public void thenPoMnozeniu(){
		 assertEquals(0,test.multiply(test.getLeft(), test.getRight()));
	}
	@When("b {rowna sie|jest} $b")
	public void when(int b){
		 test.setRight(b);

	}
	
	
}