package uk.ac.glasgow.senotes.cook.test.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import uk.ac.glasgow.senotes.cook.model.CookeryException;
import uk.ac.glasgow.senotes.cook.model.FoodItem;
import uk.ac.glasgow.senotes.cook.model.FoodItemFactory;
import uk.ac.glasgow.senotes.cook.model.MicrowaveOven;
import uk.ac.glasgow.senotes.cook.model.Oven;
import uk.ac.glasgow.senotes.cook.model.MicrowaveOven.Mode;

public class CookSteps {

	private MicrowaveOven microwaveOven;
	private Oven oven;
	//...
	
	private FoodItem currentItem;
	private Mode currentMode;
	//..
	
	@Given("a microwave oven")
	public void aMicrowaveOven(){
		this.microwaveOven = new MicrowaveOven();		
	}
	
	@When("the $modeName mode is selected")
	public void modeIsSelected(String modeName){
		
		currentMode = 
			Mode.valueOf(modeName.toUpperCase());
				
		microwaveOven.setCurrentMode(currentMode);
	}
	
	@When("a $size chicken is selected")
	public void cookingItemName(String size)
		throws CookeryException{

		currentItem = FoodItemFactory.createChicken(size);

		microwaveOven.setCurrentFoodItem(currentItem);

	}
	
	@Then("cooking time is $expected minutes")
	public void cookingTimeIs(Integer expected)
		throws CookeryException{
		
		Integer actual =
			microwaveOven.getCalculatedTime();
						
		assertThat(actual, equalTo(expected));
	}
	
	@Given("an oven")
	public void anOven(){
		oven = new Oven();
	}
	
	@When("a chicken weighing $weight kg is roasted")
	public void aFoodItemWeighingKilosIsRoasted(Double weightInKilograms){
		
		currentItem = FoodItemFactory.createChicken(weightInKilograms);
		
		oven.roast(currentItem);
	}
	
	@Then("oven temperature is $expected degrees celsius")
	public void ovenTemperatureIs(Integer expected){
		Integer actual = oven.getTemperatureCelsius();
		
		assertThat(actual, equalTo(expected));
	}
	
	@Then("roasting time is $expected minutes")
	public void roastingTimeIs(Integer expected){
		Integer actual = oven.getRoastingTime();
		
		assertThat(actual, equalTo(expected));
	}
}
