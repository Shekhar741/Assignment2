package bbCredit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreditScore {
	static{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws Exception {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bankbazaar.com/credit-score.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		CreditPage c=new CreditPage(driver);
		c.clickOnMale();
		c.selectTheAge(driver, 29);
		c.clickOnMonth("Jul");
		c.clickOnDate("14");
		c.clickOnContinue();
		Thread.sleep(3000);
		c.clickOnCity(driver, "Chennai");
		Thread.sleep(2000);
		c.setCompanyName("Testyantra");
		c.clickOnSalaried();
		c.clickOnContinue();
		Thread.sleep(3000);
		c.setTheSalry("15000");
		c.clickOnContinue();

	}

}
