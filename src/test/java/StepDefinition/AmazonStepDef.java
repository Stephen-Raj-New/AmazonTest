package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import PageObjectModule.AmazonPOM;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonStepDef {
	
	WebDriver driver;
	
	AmazonPOM Transfer;
	
	@Given("Launch the Browser and Open the Amazon Website")
	public void launch_the_browser_and_open_the_amazon_website() {
		System.setProperty("webdriver.edge.driver","C:\\WebDriver\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/?tag=msndeskabkin-21&ref=pd_sl_8m0512m97v_e&adgrpid=1317216540160148&hvadid=82326299627209&hvnetw=o&hvqmt=e&hvbmt=be&hvdev=c&hvlocint=&hvlocphy=143843&hvtargid=kwd-82326918609608:loc-90&hydadcr=5623_2377284&mcid=f13fcffd1964377ea436bb8da9e6f147");
		Transfer = new AmazonPOM(driver);
	}

	@When("Verify the user on the Webpage")
	public void verify_the_user_on_the_webpage() {
	    Transfer.VerifyTheAmazonIn();
	}

	@Then("CLose the Browser")
	public void c_lose_the_browser() {
		Transfer.CLoseTheBrowser();
	}

	@Then("Search Phone on Search box")
	public void search_phone_on_search_box()  {
		
	    try {
			Transfer.SearchPhoneOnSearchField();
		} catch (Exception e) {
			e.getCause();
			e.getMessage();
			e.printStackTrace();
		}
	}
	@Then("Click on Search")
	public void click_on_search() {
	    Transfer.ClickOnSearch();
	}

	@And("Click on Nokia phone")
	public void click_on_nokia_phone()  {
	    Transfer.CLickOnNokiaPhone();
	}

	@Then("Verify the Page was loaded")
	public void verify_the_page_was_loaded() throws InterruptedException {
	    Transfer.VerifyThePhonePageLoaded();
	}

	@And("Close the Browser")
	public void close_the_browser() {
	    Transfer.CLoseTheBrowser();
	}

}
