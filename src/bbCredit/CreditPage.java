package bbCredit;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditPage {
	
	@FindBy(xpath="//span[contains(@class,'gender-male')]")
	private WebElement male;
	@FindBy(xpath="//span[contains(@class,'gender-female')]")
	private WebElement female;
	@FindBy(xpath="(//div[@class='tooltip-inner'])[1]")
	private WebElement ageSlider;
	@FindBy(xpath="//table[@class='table eform-tcurve']//td")
	private List<WebElement> monthPicker;
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']//td")
	private List<WebElement> dateTable;
	@FindBy(xpath="//button[.='Continue']")
	private WebElement continueBtn;
	@FindBy(xpath="//span[.='Mumbai']")
	private WebElement mumbaiLogo;
	@FindBy(xpath="//span[.='Chennai']")
	private WebElement chennaiLogo;
	@FindBy(xpath="//span[.='New Delhi']")
	private WebElement delhiLogo;
	@FindBy(xpath="//span[.='Bangalore']")
	private WebElement bangaloreLogo;
	@FindBy(xpath="//input[contains(@name,'companyName')]")
	private WebElement companyTB;
	@FindBy(xpath="//a[.='Salaried ']")
	private WebElement salaryBtn;
	@FindBy(xpath="//a[.='Self-employed']")
	private WebElement selfEmployeeBtn;
	@FindBy(xpath="//input[contains(@name,'TakeHomeSalary') and @type='tel']")
	private WebElement salaryTextBox;
	@FindBy(xpath="//div[@class='tooltip-inner' and text()='0']")
	private WebElement salSlider;
	public CreditPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMale(){
		male.click();
	}
	public void clickOnFemale(){
		female.click();
	}
	public void selectTheAge(WebDriver driver,int age){
		for(int i=18;i<=70;i++)
		{
			Actions action=new Actions(driver);
			action.dragAndDropBy(ageSlider, 10, 0).build().perform();
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			if(i==age){
				break;
			}
		}
	}
	
	public void setTheSalSlider(WebDriver driver,String sal){
		for(int i=0;i<=70;i++)
		{
			Actions act=new Actions(driver);
			act.dragAndDropBy(salSlider, 10, 0);
		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(sal.equals(sal)){
				break;
			}
		}
		
	}
	public void clickOnMonth(String month){
		for(WebElement mth:monthPicker){
			String text=mth.getText();
			if(text.contains(month)){
				mth.click();
				break;
			}
		}
	}
	public void clickOnDate(String date){
		for(WebElement dt:dateTable){
			String text=dt.getText();
			System.out.println(text);
			if(text.equalsIgnoreCase(date)){
				dt.click();
				break;
			}
		}
	}
	public void mouseHoverAndClick(WebDriver driver,WebElement element){
		Actions act=new Actions(driver);
		act.moveToElement(element).click().build().perform();
	}
	public void clickOnContinue(){
		continueBtn.click();
	}
	public void clickOnCity(WebDriver driver,String city){
		if(city.equalsIgnoreCase("Mumbai")){
			mouseHoverAndClick(driver, mumbaiLogo);
		}
		else if(city.equalsIgnoreCase("Chennai")){
			mouseHoverAndClick(driver, chennaiLogo);
		}
		else if(city.equalsIgnoreCase("New Delhi")){
			mouseHoverAndClick(driver, delhiLogo);
		}
		else{
			mouseHoverAndClick(driver, bangaloreLogo);
		}
		
	}
//	public void clickOnMumbai(){
//		mumbaiLogo.click();
//	}
//	public void clickOnChennai(){
//		chennaiLogo.click();
//	}
//	public void clickOnNewDelhi(){
//		delhiLogo.click();
//	}
//	public void clickOnBangalore(){
//		bangaloreLogo.click();
//	}
	public void setCompanyName(String cname){
		companyTB.sendKeys(cname);
	}
	public void clickOnSalaried(){
		
		salaryBtn.click();
	}
	public void clickOnSelfEmployed(){
		selfEmployeeBtn.click();
	}
	public void setTheSalry(String amt){
		salaryTextBox.sendKeys(amt);
	}
	

}
