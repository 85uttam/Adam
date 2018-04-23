package products;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Browsers;
import repository.Keywords;

public class DrugNotes_45 extends Browsers
{
	Keywords obj;
	@Test(priority=0)
	public void drugNotes()
	{
		obj=new Keywords(driver);
		System.out.println("******************************Start Testing of DrugNotes**************************");
		driver.navigate().to("http://se3-rnd.stg.adam.com/content.aspx?productId=45");
		System.out.println("***********************Taking Screen Shot of Home Page****************************");
		obj.expliciteWait(500);
		try {
			obj.getScreenShot("45_Search");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Not Taking ScreenShot");
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
		obj.enter_Text("id", "txtsearch", "Heart");
		obj.expliciteWait(500);
		System.out.println("******************Taking Screen Shot of Tyep ahead box********************");
		obj.getScreenShot("45_Typeaheadbox");
		obj.click_On_Button("className", "search-submit-button");
		obj.expliciteWait(500);
		driver.navigate().back();
		obj.click_On_Link("className", "atoz-submit-button");
		System.out.println("*******************Taking Screen Shot of Browse A-Z**********************");
		obj.getScreenShot("45_Browse_A_Z");
		obj.click_On_Link("xpath", ".//*[@id='hm-AdamSearchBox']/div[2]/a[1]");
		obj.expliciteWait(500);
		driver.navigate().back();
		obj.click_On_Button("className", "search-home-button");
		obj.expliciteWait(500);
		driver.navigate().back();
	}
	
	@Test(priority=3)
	public void drugNote_HomePage()
	{
		System.out.println("*********************I am In Home Page of Drug Notes************************");
		System.out.println("*******************CSS Used in Product Title Heading***********************");
		obj.fontProperty("className", "ADAM_se-entry");
		System.out.println("***********************CSS Used in Browse Text********************************");
		obj.fontProperty("xpath", ".//*[@id='content']/article/div");
		System.out.println("*********************CSS Used in Browse Link A-Z******************************");
		obj.fontProperty("xpath", ".//*[@id='page-a-z-nav']/li[1]/a");
		System.out.println("**************************CSS Used in achor index Title*************************");
		obj.fontProperty("xpath", ".//*[@id='content']/article/h2[1]/a");
		System.out.println("***************************CSS Used in links***********************************");
		obj.fontProperty("xpath", ".//*[@id='content']/article/ul[2]/li[1]/a");
	}
	
	
	@Test(priority=4)
	public void drugNotes_SecondaryPage() throws IOException
	{
		System.out.println("****************I am in Secondary page of DrugNotes*****************************");
		obj.click_On_Link("xpath", ".//*[@id='content']/article/ul[2]/li[1]/a");
		obj.expliciteWait(500);
		System.out.println("*****************Taking Screeen Shot of Secondary page of Drug Notes*************");
		obj.getScreenShot("45_DrugNote_SecondaryPage");
		System.out.println("**********************CSS Used in H2 heading*********************************");
		obj.fontProperty("className", "ADAM_drug-notes-h2");
		System.out.println("******************CSS Used in H3 Heading*************************************");
		obj.fontProperty("xpath", ".//*[@id='content']/article/h3");
		System.out.println("***********************CSS Used in H4 Heading*********************************");
		obj.fontProperty("xpath", ".//*[@id='content']/article/h4[1]");
		System.out.println("********************CSS Used in Body text************************************");
		obj.fontProperty("xpath", ".//*[@id='content']/article");
		System.out.println("********************CSS Used in list Item**********************************");
		obj.fontProperty("xpath", ".//*[@id='content']/article/ul[2]");
		driver.findElement(By.className("ADAM_ImgEnglishVersion")).click();
		System.out.println("*********************Clicking on Spanish Button*********************************");
		obj.isElementPresent("Por la boca");
	}
}
