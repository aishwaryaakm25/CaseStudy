package cucumber.CaseStudy;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import mainJavaClass.UtilityFile;

public class Test {
	
	WebDriver driver;
    WebElement search;
	
	
//****Case1****
	
	@Given("Enter to Signup page")
	public void enter_to_Signup_page() {
		driver=UtilityFile.getDriver("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp/RegisterUser.htm");  
	}

	@When("Enter the required details")
	public void enter_the_required_details(io.cucumber.datatable.DataTable dataTable) {
		 List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
		    for(int i=0;i<list.size();i++)
		    {
		    driver.findElement(By.name("userName")).sendKeys(list.get(i).get("UserName"));
		    driver.findElement(By.name("firstName")).sendKeys(list.get(i).get("FirstName"));
		    driver.findElement(By.name("lastName")).sendKeys(list.get(i).get("LastName"));
		    driver.findElement(By.id("password")).sendKeys(list.get(i).get("ConPassword"));
		    driver.findElement(By.id("pass_confirmation")).sendKeys(list.get(i).get("Password"));
		    driver.findElement(By.xpath("//*[@id='gender']")).click();
		    driver.findElement(By.id("emailAddress")).sendKeys(list.get(i).get("Email"));
		    driver.findElement(By.id("mobileNumber")).sendKeys(list.get(i).get("MobileNum"));
		    
		    driver.findElement(By.name("dob")).sendKeys("07/18/1997");
		    driver.findElement(By.id("address")).sendKeys(list.get(i).get("Address"));
		    Select question = new Select(driver.findElement(By.id("securityQuestion")));
		    question.selectByValue("411011");
		    driver.findElement(By.id("answer")).sendKeys("black");
		    
    }
	}

	@And("Click on register button")
	public void click_on_register_button() {
		driver.findElement(By.name("Submit")).click();
		Assert.assertEquals(driver.getTitle(), "Login");
		driver.close();
		System.out.println("Signup is passed");
	}
	
	
	
	//****Case2*****
	
	@Given("Enter registred user name {string}")
	public void enter_registred_user_name(String string) {
		driver=UtilityFile.getDriver("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		driver.findElement(By.name("userName")).sendKeys(string);
	}

	@When("Enter Password {string}")
	public void enter_Password(String string) {
		driver.findElement(By.name("password")).sendKeys(string);
	}

	@And("Click on submit button")
	public void click_on_submit_button() {
		driver.findElement(By.name("Login")).click();
	}

	@Then("Registred page will be displayed")
	public void registred_page_will_be_displayed() {
		Assert.assertEquals(driver.getTitle(), "Home");
		  System.out.println("Signin scenerio is passed");	 
	}

	
	
	//****Case3*****
	
	@Given("Enter Product name using four characters")
	public void enter_Product_name_using_four_characters() {
		driver=UtilityFile.getDriver("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.findElement(By.name("products")).sendKeys("head");
		//Actions act=new Actions(driver);
	    //act.keyDown(Keys.SHIFT).sendKeys("h").keyUp(Keys.SHIFT).sendKeys("ead").build().perform();
	   // act.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE);
	   // act.keyDown(Keys.SHIFT).sendKeys("Head").keyUp(Keys.SHIFT).perform();
	}

	@When("Click on the suggested product")
	public void click_on_the_suggested_product() {
		System.out.println("Entering into product details by next step");
		//driver.findElement(By.xpath("//*[@id=\'myInputautocomplete-list\']/div/input")).click();
	}

	@When("Click on find button")
	public void click_on_find_button() { 
		driver.findElement(By.xpath("/html/body/div[1]/form/input")).click();
	}

	@Then("Product page will be displayed")
	public void product_page_will_be_displayed() {
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[1]/center[1]/h4"));
		Assert.assertEquals(driver.getTitle(), "Search");
	
		driver.close();
	}

	
	
	
	//***Case4****
	
	@Given("Signin the pages {string} and {string}")
	public void signin_the_pages_and(String string1, String string2) {
		driver=UtilityFile.getDriver("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		driver.findElement(By.name("userName")).sendKeys(string1);
		driver.findElement(By.name("password")).sendKeys(string2);
		driver.findElement(By.name("Login")).click(); 
		Assert.assertEquals(driver.getTitle(), "Home");
	}

	@When("search the products headphone")
	public void search_the_products_headphone() {
		driver.findElement(By.name("products")).sendKeys("head");
		driver.findElement(By.xpath("/html/body/div[1]/form/input")).click();
		
	}

	@When("Try to pay without add that item")
	public void try_to_pay_without_add_that_item() {
		System.out.println("Try to pay without add that item");
	
}

	@Then("Testme don't display that icon")
	public void testme_don_t_display_that_icon() {
		Assert.assertNull(driver.findElement(By.xpath("//*[@id='header']/div[1]/div/div/div[2]/div/a[2]")));
		driver.close();
	}
	
	@Given("Signin the pages Login {string} and {string}")
	public void signin_the_pages_Login_and(String string11, String string22) {
		driver=UtilityFile.getDriver("chrome");  
		driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		driver.findElement(By.name("userName")).sendKeys(string11);
		driver.findElement(By.name("password")).sendKeys(string22);
		driver.findElement(By.name("Login")).click(); 
		Assert.assertEquals(driver.getTitle(), "Home");
	}
	
	@When("search the product in headphone")
	public void search_the_product_in_headphone() {
		driver.findElement(By.name("products")).sendKeys("head");
		driver.findElement(By.xpath("/html/body/div[1]/form/input")).click();
	}

	@When("add the product in the cart")
	public void add_the_product_in_the_cart() {
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click(); 
	}

	@Then("find the cart icon")
	public void find_the_cart_icon() {
		Assert.assertEquals( driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).getText(),"Cart "+ driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]/b")).getText()+"   ");
		driver.close();

	}

}
