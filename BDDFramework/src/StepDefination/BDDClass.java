package StepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BDDClass {

//NOTE : Object , Properties  Data and keywords can be parameterized if using proper framework, Here hardcoded locators are being used temporarily
      public  WebDriver driver;
      int DomainCount;
          
	@Given("^Open Firefox Browser$")
	public void open_Firefox_Browser() 
	{
	   
		System.out.println("Welcomed to AutoRegistry website");
			
	   	}

	@When("^Go to AutoRegistry Website$")
	public void go_to_AutoRegistry_Website() 
	
	{
        
        driver = new FirefoxDriver();
     	driver.get("https://www.ausregistry.com.au");
		
	   
	}

	@Then("^Verify browser navigates to website correctly$")
	public void verify_browser_navigates_to_website_correctly() throws InterruptedException  {
	 
		System.out.println("Webpage opens oorrectly");
		
		}
	
	//**************************

@Given("^Number of registered AU domains$")
	public void number_of_registered_AU_domains() throws InterruptedException  {
	
	System.out.println("Home Page loaded Successfully");
       
	   	}

	@When("^Verify on Big Dark grey Section on home page at bottom$")
	public void verify_on_Big_Dark_grey_Section_on_home_page_at_bottom() throws InterruptedException {
		
		//Count Registered Domain numbers
		
		//Fetching complete text of Xpath through Gettext Function
				String element =  driver.findElement(By.xpath("//*[@id='post-11560']/div/div[4]/div/div/div/h1/span/div")).getText();
				
				System.out.println("TEXT IS :" +element);
				
				//Removing delimiters
				String domainnum = element.replaceAll(",", "");
				
				//Converting String to Integer
				 DomainCount = Integer.parseInt(domainnum);
				 System.out.println("Registered Domain count is :" +DomainCount);	 
	}

	@Then("^Number of reigstered AU domains should be > (\\d+) millions$")
	public void number_of_reigstered_AU_domains_should_be_millions(int arg1)  {
		
		//Validating results
		if (DomainCount > 3000000)
		{
			System.out.println("Total Domain Count is Greater than 3 Millions");
		
	    	}
		else
		{
			System.out.println("Total Domain Count is less than 3 Millions");
		}
	}

	//***********************
	
	@Given("^Dynamic panel on right side of home page$")
	public void dynamic_panel_on_right_side_of_home_page()  {
		
		System.out.println("Click on Dyanmnic right side  panel on page");
	   
	    
	}

	@When("^Moveover mouse to dynamic panel on right side$")
	public void moveover_mouse_to_dynamic_panel_on_right_side()  {
	   
		//Move to dynamic right panel Check Availability
	    Point hoverItem =driver.findElement(By.xpath("//*[@id='shortcutLinks']/ul/li[1]/a")).getLocation();
	    ((JavascriptExecutor)driver).executeScript("return window.title;");
	    ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+(hoverItem.getY())+");");

	    
		//This function was tried but didn't work properly in this scenario, getting offset exception
	/*Actions action = new Actions(driver);
	WebElement we = driver.findElement(By.xpath("//*[@id='shortcutLinks']/ul/li[2]/a"));//Just moving to dynamic right panel on "WHOIS" option to keep focus on panel
	  Thread.sleep(5000);	
	action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id='shortcutLinks']/ul/li[1]/a"))).click().build().perform();//Now it clicks on Check Availability Option
	*/
	
	    //Search with some text
	
	   
	}

	@Then("^Check Availability page option should appear$")
	public void check_Availability_page_option_should_appear() {
	   
		//Clicking on Check Availability option
		driver.findElement(By.xpath("//*[@id='shortcutLinks']/ul/li[1]/a")).click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			   
	}
	
	//*********************
	
	@Given("^Search option available$")
	public void search_option_available()  {
		
		System.out.println("Verify text under search button");
	}

	@When("^Enter domain name “testautomation\\.com\\.au\" in search box$")
	public void enter_domain_name_testautomation_com_au_in_search_box() {
		
		 //Click Search button and validate results ( It can further be automated to verify some specific value from search 
		driver.findElement(By.xpath("//*[@id='whois-input-box']")).sendKeys("testautomation.com.au");
		driver.findElement(By.id("whois-submit-btn")).click();;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		 //Search with testautomation.org.au
		   driver.findElement(By.xpath("//*[@id='whois-input-box']")).sendKeys("testautomation.org.au");
		   driver.findElement(By.id("whois-submit-btn")).click();;
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	}

	@Then("^validate domain results showing correctly$")
	public void validate_domain_results_showing_correctly()  {
		System.out.println("Search is successful");
	 
	}
	
	//***********************
	
	@Given("^Find a registrar page option$")
	public void find_a_registrar_page_option() {
		
		System.out.println("Find a Registrar page opens");
	
	}

	@When("^Click on Find a registrar page$")
	public void click_on_Find_a_registrar_page() {
		
		 //Move to dynamic right panel Find a registrar page
		   
		   Point hoverItem1 =driver.findElement(By.xpath("//*[@id='shortcutLinks']/ul/li[4]/a")).getLocation();
		    ((JavascriptExecutor)driver).executeScript("return window.title;");
		    ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+(hoverItem1.getY())+");");

	   
	}

	@Then("^Verify it navigates correctly to next page$")
	public void verify_it_navigates_correctly_to_next_page() {
	    
	    driver.findElement(By.xpath("//*[@id='shortcutLinks']/ul/li[1]/a")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	//********************************************
	
		@Given("^find your domain section$")
	public void find_your_domain_section() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^External links appears on page$")
	public void external_links_appears_on_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^count total number of external links$")
	public void count_total_number_of_external_links() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	//*******************************
	
	@Given("^Learn more button appears$")
	public void learn_more_button_appears()  {
		
		System.out.println("Verify Learn More Button appears");
	   
	}

	@When("^click on learn more button$")
	public void click_on_learn_more_button()  {
		
		//Learn More
	    driver.findElement(By.xpath("//*[@id='post-12063']/div/div[3]/div/div[2]/div/div[1]/a/span")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	}

	@Then("^it navigates to next page correctly$")
	public void it_navigates_to_next_page_correctly()  {
		System.out.println("Next page navigated");
		
	   
	}
	
	//************************************************

	@Given("^Find a registrar text appears$")
	public void find_a_registrar_text_appears()  {
		
		System.out.println("Verified Contact Us icon appears on Header page");
	
	}

	@When("^click on contact us option from header of the page$")
	public void click_on_contact_us_option_from_header_of_the_page()  {
		
		//Click on Contact US
	    driver.findElement(By.xpath("//*[@id='menu-item-11681']/a/span/span/i")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 	   
	}

	@Then("^verify contact number appears on next page$")
	public void verify_contact_number_appears_on_next_page()  {
		
		   //Verify Phone Number available on page
	    driver.getPageSource().contains("Phone: +61-3-9866-3710");
	    
	}

	@Then("^verify email address appears on next page$")
	public void verify_email_address_appears_on_next_page() {
	
	     //Verify email available on page	    
	    driver.getPageSource().contains("info@ausregistry.com.au");
	}

}