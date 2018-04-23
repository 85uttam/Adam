package products;
import java.io.IOException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import base.Browsers;
import repository.Keywords;

public class CAM_107 extends Browsers
{
	Keywords obj;
	
	@Test(priority=0)
	public void CAM()
	{
	obj=new Keywords(driver);
	driver.navigate().to("http://se3-rnd.stg.adam.com/content.aspx?productId=107");
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
	
	
	@Test(priority=3)
	public void HomePage()
	{
		System.out.println("*******************************CCS Used in Home Page Product Title********************************************");
		obj.fontProperty("className", "ADAM_se-entry");
		System.out.println("****************************CSS Used in H4 Heading************************************************************");
		obj.fontProperty("className", "ADAM_se-h4");
		System.out.println("*************************************CSS Used in Home Page Hyperlinks*****************************************");
		obj.fontProperty("xpath", ".//*[@id='cam-u-left-col']/ul/li[1]/a");
		System.out.println("***************************************CSS Used in Body Text***************************************************");
		obj.fontProperty("xpath", ".//*[@id='cam-l-left-col']/ul/li[1]/p");
		
	}
	
	
	@Test(priority=4)
	public void secondary_Page() throws IOException
	{
		obj.click_On_Link("xpath", ".//*[@id='cam-u-left-col']/ul/li[1]/a");
		obj.expliciteWait(500);
		obj.getScreenShot("107_Secondary_Page");
		System.out.println("**************************CSS Used in Secondary Page H1 Heading*************************************************");
		obj.fontProperty("className", "ADAM_se-entry-107");
		System.out.println("*****************************************CSS Used in Browse Text*************************************************");
		obj.fontProperty("id", "BrawseLI");
		System.out.println("*****************************************CSS Used in Browse Links A-Z*****************************************");
		obj.fontProperty("id", "A");
		System.out.println("*************************************CSS Used in Move to links Browse Text*********************************** ");
		obj.fontProperty("xpath", ".//*[@id='LinkToMoveA']/span");
		System.out.println("*******************************CSS Used in Secondary Page Hyperlinks********************************************");
		obj.fontProperty("xpath", ".//*[@id='se-search-results']/li[1]/a");
		System.out.println("******************************************Index Color*******************************************************");
		obj.backGround_Color("xpath", ".//*[@id='se-search-results']/li[2]");
		
	}
	
	
	@Test(priority=5)
	public void article_InnerPage() throws IOException
	{
		obj.click_On_Link("xpath", ".//*[@id='se-search-results']/li[4]/a");
		obj.expliciteWait(500);
		obj.getScreenShot("107_Article_Page");
		System.out.println("**********************CSS Used in Body text node-set P Tag****************");
		obj.fontProperty("xpath", ".//*[@id='node-set']/p[4]");
		System.out.println("********************CSS Used in Body text content Div P Tag****************");
		obj.fontProperty("xpath", ".//*[@id='contentDiv']/p");
		System.out.println("********************CSS Used in content Div Heading************************");
		obj.fontProperty("xpath", ".//*[@id='contentDiv']/h3");
		System.out.println("***************CSS Used in content li item*******************************");
		obj.fontProperty("xpath", ".//*[@id='contentDiv']/ul/li[4]");
		System.out.println("************CSS Used in strong Text in Between body Text*****************");
		obj.fontProperty("xpath", ".//*[@id='contentDiv']/ul[8]/li[2]/strong");
		
		
	}
	
	@Test(priority=6)
	public void RHN_Section() throws FindFailed
	{
		Screen screen=new Screen();
		Pattern video=new Pattern("C:\\Users\\suneel.kumar\\workspace\\ADAM\\src\\Images\\Video_image.PNG");
		screen.click(video);
		System.out.println("*******************CSS Used IN ADAM_video-sub-title**************************");
		obj.fontProperty("className", "ADAM_video-sub-title");
		System.out.println("*******************CSS Used in Video Paragraph*******************************");
		obj.fontProperty("className", "ADAM_video-sub-p");
		obj.click_On_Button("className", "ADAM_video-cls-btn");
		System.out.println("*******************CSS Used in RHN Hyperlinks*********************************");
		obj.fontProperty("xpath", ".//*[@id='advanced-module']/ul/li[1]/a");
		System.out.println("******************CSS Used in H3 Heading in RHN*******************************");
		obj.fontProperty("className", "ADAM_se-h3");
	}
}
