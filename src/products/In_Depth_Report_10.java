package products;
import java.io.IOException;
import org.testng.annotations.Test;
import repository.Keywords;
import base.Browsers;

public class In_Depth_Report_10 extends Browsers
{
	Keywords obj;
	@Test(priority=0)
	public void InDepthReport() throws IOException
	{
		obj=new Keywords(driver);
		System.out.println("******************************Start Testing of Health Search**************************");
		driver.navigate().to("https://ssl.stg.adam.com/content.aspx?productId=10&site=kaleidahealth.adam.com&login=KALE7876");
		obj.expliciteWait(500);
		obj.getScreenShot("10_Search");
		obj.backGround_Color("xpath", ".//*[@id='ADAMbranding']/div");
		//String ADAMbrandingColor = driver.findElement(By.xpath(".//*[@id='ADAMbranding']/div")).getCssValue("background-color");
		//System.out.println("Header BackGround Color:-"+ADAMbrandingColor);
	}
	
	@Test(priority=1)
	public void Logo()
	{
		System.out.println("***********************Verify Se3 Logo**********************************************");
		obj.Se3_Logo("className", "Se3LogoImg");
		obj.click_On_Link("className", "Se3LogoImg");
		//obj.emplicitWait("500");
		obj.isElementPresent("Smart Decisions. Smart Health.");
		driver.navigate().back();
	}
	
	@Test(priority=2)
	public void searchBox() throws IOException
	{
		System.out.println("************************Verify Search box***************************************");
		obj.placeHolderValue("id", "txtsearch");
		obj.Search_Validation_Message("className", "search-submit-button");
		obj.enter_Text("id", "txtsearch", "Heart");
		obj.expliciteWait(500);
		obj.getScreenShot("10_Typeaheadbox");
		obj.click_On_Button("className", "search-submit-button");
		obj.expliciteWait(500);
		driver.navigate().back();
		obj.click_On_Link("className", "atoz-submit-button");
		obj.getScreenShot("10_Browse_A_Z");
		obj.click_On_Link("xpath", ".//*[@id='hm-AdamSearchBox']/div[2]/a[1]");
		obj.expliciteWait(500);
		driver.navigate().back();
		obj.click_On_Button("className", "search-home-button");
		obj.expliciteWait(500);
		driver.navigate().back();
	}
	
	
	@Test(priority=3)
	public void HomePage_InDepthReport()
	{
		System.out.println("*********************CSS Used in Product Title Heading*************************************");
		obj.fontProperty("xpath", ".//*[@id='header']/h1");
		System.out.println("***********************CSS Used in Browse Text********************************");
		obj.fontProperty("xpath", ".//*[@id='header']/div[1]/span");
		System.out.println("*********************CSS Used in Browse Link A-Z******************************");
		obj.fontProperty("xpath", ".//*[@id='A']");
		System.out.println("**************************CSS Used in achor index Title*************************");
		obj.fontProperty("xpath", ".//*[@id='LinkToMoveA']/span");
		System.out.println("***************************CSS Used in links***********************************");
		obj.fontProperty("xpath", ".//*[@id='all-pane']/ul[1]/li[1]/a");
	}
	
	
	@Test(priority=4)
	public void secondaryPage_InDepthReport() throws IOException
	{
		obj.click_On_Link("xpath", ".//*[@id='all-pane']/ul[1]/li[21]/a");
		obj.expliciteWait(500);
		obj.getScreenShot("second_IndepthReport");
		System.out.println("***************************CSS Used in H1 Heading**************************************");
		obj.fontProperty("className", "ADAM_se-entry");
		System.out.println("**************************CSS Used in H2 Heading*************************************");
		obj.fontProperty("className", "ADAM_se-h2");
		System.out.println("**************************CSS Used in H4 Heading*************************************");
		obj.fontProperty("className", "ADAM_se-h4-grn");
		System.out.println("**************************CSS Used in P Tag Text*********************************");
		obj.fontProperty("className", "ADAM_se-p");
		System.out.println("**************************CSS Used in List Item Text*****************************");
		obj.fontProperty("xpath", ".//*[@id='content']/article/ul[1]/li[1]");
		System.out.println("**************************CSS Used in Strong Text in Body*****************************");
		obj.fontProperty("xpath", ".//*[@id='content']/article/ul[1]/li[1]/strong");
		System.out.println("************************CSS Used in Video Title Text in RHN************************");
		obj.fontProperty("className", "ADAM_se-h4");
		System.out.println("************************CSS Used in RHN Links************************");
		obj.fontProperty("className", "ADAM_anchor");
	}
	
	
	

}
