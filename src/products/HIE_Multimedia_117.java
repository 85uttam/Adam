package products;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.Browsers;
import repository.Keywords;

public class HIE_Multimedia_117 extends Browsers
{
	Keywords obj;
	
	@Test(priority=0)
	public void HIE()
	{
	obj=new Keywords(driver);
	driver.navigate().to("http://se3-rnd.stg.adam.com/content.aspx?productId=117");
	obj.expliciteWait(500);
	System.out.println("*********************Start Testing of HIE Multimedia page*********************************");
	try {
		obj.getScreenShot("LadingPage");
	} catch (IOException e) {
		System.out.println("Not taking ScreenShot");
		e.printStackTrace();
	}
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
		obj.click_On_Button("className", "search-submit-button");
		obj.expliciteWait(500);
		driver.navigate().back();
		obj.click_On_Link("className", "atoz-submit-button");
		obj.getScreenShot("Browse_A_Z");
		obj.click_On_Link("xpath", ".//*[@id='hm-AdamSearchBox']/div[2]/a[1]");
		obj.expliciteWait(500);
		driver.navigate().back();
	}

}
