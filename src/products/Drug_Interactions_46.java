package products;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import repository.Keywords;
import base.Browsers;

public class Drug_Interactions_46 extends Browsers
{
Keywords obj;
	
	@Test(priority=0)
	public void drugInteractions()
	{
		obj=new Keywords(driver);
		driver.navigate().to("http://hendrick-medical.stg.adam.com/content.aspx?productId=46");
		obj.expliciteWait(500);
		//obj.verifyLinksErrorCode();
		
		
	}
	
	@Test(priority=1)
	public void Logo()
	{
		obj.Se3_Logo("className", "Se3LogoImg");
	}
	
	
	@Test(priority=2)
	public void searchBox() throws IOException
	{
		obj.placeHolderValue("id", "txtsearch");
		obj.Search_Validation_Message("className", "search-submit-button");
		obj.enter_Text("id", "txtsearch", "Heart");
		obj.expliciteWait(500);
		obj.getScreenShot("Typeaheadbox");
		System.out.println("*********************Clicking on Search button*******************");
		obj.click_On_Button("className", "search-submit-button");
		obj.expliciteWait(500);
		obj.isElementPresent("Read Full Article");
		driver.navigate().back();
		driver.findElement(By.id("txtsearch")).clear();
		obj.enter_Text("id", "txtsearch", "Heart");
		obj.expliciteWait(500);
		System.out.println("*********************Clicking on Enter button*******************");
		driver.findElement(By.id("txtsearch")).sendKeys(Keys.ENTER);
		obj.expliciteWait(500);
		obj.isElementPresent("Read Full Article");
		driver.navigate().back();
		obj.click_On_Link("className", "atoz-submit-button");
		obj.getScreenShot("Browse_A_Z");
		obj.click_On_Link("xpath", ".//*[@id='hm-AdamSearchBox']/div[2]/a[1]");
		obj.expliciteWait(500);
		driver.navigate().back();
	}
	
	@Test(priority=3)
	public void home_Page()
	{
		System.out.println("****************CSS Used in Product Title************************");
		obj.fontProperty("className", "titleText");
		System.out.println("******************CSS Used in body text***************************");
		obj.fontProperty("xpath", ".//*[@id='inside-page']/div/div/div[2]/div/table[2]/tbody/tr/td[2]/span");
		obj.enter_Text("id", "ADAMSearchBox2", "Tylenol");
		obj.click_On_Button("className", "adambtn");
		obj.expliciteWait(500);
		obj.click_On_Button("id", "AdamAdd");
		obj.click_On_Button("id", "AdamAdd");
		obj.click_On_Button("id", "AdamAdd");
		obj.click_On_Button("id", "AdamAdd");
		obj.click_On_Button("xpath", ".//*[@id='tdCheckInteraction']/div/div");
	
	}
	@Test(priority=4)
	public void secondary_Page()
	{
		System.out.println("********************CSS Used in secondary page Links*************************");
		obj.fontProperty("xpath", ".//*[@id='inside-page']/div/div/div[2]/div/div/table[2]/tbody/tr[2]/td[2]");
		System.out.println("********************CSS Used in Body text in Secondary page*****************");
		obj.fontProperty("xpath", ".//*[@id='inside-page']/div/div/div[2]/div/div/div[5]");
		System.out.println("*******************CSS Used in disclaimer Section ***********************");
		obj.fontProperty("xpath", ".//*[@id='disclaimer']");
	}

}
