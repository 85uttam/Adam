package products;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import repository.Keywords;
import base.Browsers;

public class Health_Search_26 extends Browsers
{
	Keywords obj;
	@Test(priority=0)
	public void healthSearch()
	{
		obj=new Keywords(driver);
		System.out.println("******************************Start Testing of Health Search**************************");
		driver.navigate().to("http://se3-rnd.stg.adam.com/content.aspx?productId=26");
		obj.expliciteWait(500);
		try {
			obj.getScreenShot("26_Search");
		} catch (IOException e) {
			System.out.println("Not Taking ScreenShot");
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void Logo()
	{
		System.out.println("***********************Verify Se3 Logo**********************************************");
		obj.Se3_Logo("className", "Se3LogoImg");
	}
	
	@Test(priority=2)
	public void searchBox() throws IOException
	{
		System.out.println("************************Verify Search box***************************************");
		obj.placeHolderValue("id", "txtsearch");
		obj.Search_Validation_Message("className", "search-submit-button");
		obj.click_On_Button("className", "search-home-button");
		obj.expliciteWait(500);
		driver.navigate().back();
		obj.click_On_Link("className", "atoz-submit-button");
		obj.getScreenShot("26_Browse_A_Z");
		obj.click_On_Link("xpath", ".//*[@id='hm-AdamSearchBox']/div[2]/a[1]");
		obj.expliciteWait(500);
		driver.navigate().back();
		driver.findElement(By.id("txtsearch")).clear();
		obj.enter_Text("id", "txtsearch", "Heart");
		obj.expliciteWait(500);
		obj.getScreenShot("26_Typeaheadbox");
		obj.click_On_Button("className", "search-submit-button");
		obj.expliciteWait(500);
		obj.getScreenShot("Search_Secondary_Page");
		
		
		
	}
	
	@Test(priority=3)
	public void secondary_Page_Search_box() throws IOException
	{
		System.out.println("********************Verify Search box in Secondary page*******************");		
		System.out.println("*********************Used CSS in secondary Page Heading**********************");
		obj.fontProperty("className", "ADAM_se-entry");
		System.out.println("*************************Used CSS in Paragraph**************************************");
		obj.fontProperty("className", "ADAM_se-p");
		System.out.println("************************CSS Used in Links****************************************");
		obj.fontProperty("xpath", ".//*[@id='Self_Care']/div[2]/ul");
	}
	
	
	@Test(priority=4)
	public void Health_News()
	{
		System.out.println("**************Health News Section In secondary page Search box************************");
		obj.isElementPresent("Health News:");
	}
	
	
	@Test(priority=5)
	public void RHN_Section() throws FindFailed
	{
		System.out.println("******************RHN Section in Health Search************************************");
		
		Screen s=new Screen();
		Pattern video=new Pattern("C:\\Users\\suneel.kumar\\workspace\\ADAM\\src\\Images\\Video_image.PNG");
		Pattern image=new Pattern("C:\\Users\\suneel.kumar\\workspace\\ADAM\\src\\Images\\26_image.PNG");
		Pattern presentation=new Pattern("C:\\Users\\suneel.kumar\\workspace\\ADAM\\src\\Images\\presentation_image.PNG");
		s.click(video);
		System.out.println("*********************CSS Used in Video Popup Sub Title****************************");
		obj.fontProperty("className", "ADAM_video-sub-title");
		System.out.println("*****************************CSS Used in Video popup Paragraph **************************");
		obj.fontProperty("className", "ADAM_video-sub-p");
		obj.expliciteWait(500);
		obj.click_On_Button("id", "Close_allTab200135");
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
		obj.expliciteWait(500);
		s.click(image);
		System.out.println("*********************CSS Used in images Popup Sub Title****************************");
		obj.fontProperty("id", "video-sub-title");
		System.out.println("*****************************CSS Used in image popup Paragraph **************************");
		obj.fontProperty("id", "video-sub-p");
		obj.expliciteWait(500);
		obj.click_On_Button("xpath", ".//*[@id='img-1-large']/a");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		obj.expliciteWait(500);
		s.click(presentation);
		System.out.println("******************CSS Used in presentation Popup Sub Title*******************");
		obj.fontProperty("xpath", ".//*[@id='slider_allTab000129']/div[1]/strong");
		System.out.println("******************CSS Used in presentation Popup Paragraph*******************");
		obj.fontProperty("xpath", ".//*[@id='slider_allTab000129']/div[1]/p");
		obj.click_On_Button("className", "ADAM_illustration-cls-btn");
	}

}
