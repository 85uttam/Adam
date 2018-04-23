package products;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import base.Browsers;
import repository.Keywords;

public class Testing extends Browsers
{
	Keywords obj;
	
	@Test(priority=0)
	public void case1()
	{
		obj=new Keywords(driver);
		driver.navigate().to("http://hendrick-medical.stg.adam.com/content.aspx?productId=65");
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
	public void home_Page() throws FindFailed
	{
		obj.Search_Validation_Message("id", "ADAMHN_GoButton");
		Screen s=new Screen();
		Pattern image=new Pattern("C:\\Users\\suneel.kumar\\workspace\\ADAM\\src\\Images\\65_Hero_Image.PNG");
		s.click(image);
		obj.Search_Validation_Message("id", "ADAMHN_GoButton");
		
	
	}
	@Test(priority=4)
	public void secondary_Page()
	{
		
	}

}
