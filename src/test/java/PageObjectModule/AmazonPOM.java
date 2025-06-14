package PageObjectModule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

public class AmazonPOM {
	
	WebDriver driver;
	
@FindBy(xpath= "//span[@class='nav-logo-locale']")
WebElement Amazon_Locator;

@FindBy(xpath= "//input[@type='text']")
WebElement Search_Locator;

@FindBy(xpath= "//input[@type='submit']")
WebElement Search_Icon_Locator;

@FindBy(xpath= "(//span[@class='a-price-whole'])[5]")
WebElement Nokia_Locator;

@FindBy(xpath= "(//span[contains(text(),'974')])[10]")
WebElement Price_Locator;

@FindBy(xpath= "//span[contains(text(),'Operating System Version')]")
WebElement Operating_System_Version;


	public AmazonPOM(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

	public void VerifyTheAmazonIn() {
		String Amazon = Amazon_Locator.getText();
		String ExpectedAmazon = ".in";
		org.junit.Assert.assertEquals(Amazon, ExpectedAmazon);
	}
	public void SearchPhoneOnSearchField() {
		
		Search_Locator.sendKeys("Phone");
	}
	public void ClickOnSearch() {
		Search_Icon_Locator.click();
	}
	public void CLickOnNokiaPhone()  {
		
		Nokia_Locator.click(); 	
	}
	public void VerifyThePhonePageLoaded() throws InterruptedException {
		
		Thread.sleep(5000);
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
    	js2.executeScript("arguments[0].scrollIntoView(true);", Operating_System_Version);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'974')])[10]")));
		
		String Phone = Price_Locator.getText();
		String ExpectedPhone = "974";
		org.junit.Assert.assertEquals(Phone, ExpectedPhone);
	}
	public void CLoseTheBrowser() {
		driver.quit();
	}
}
