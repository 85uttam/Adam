package products;

import java.io.IOException;

import org.testng.annotations.Test;



import base.Browsers;
import repository.Keywords;

public class MyCheckups_43 extends Browsers
{
	Keywords obj;
	
	
	@Test(priority=0)
	public void myCheckUps()
	{
		obj=new Keywords(driver);
		System.out.println("*************************Start Testing of Mycheckups*******************************");
		driver.navigate().to("http://se3-rnd.stg.adam.com/content.aspx?productId=43");
		try {
			obj.getScreenShot("MycheckUps");
		} catch (IOException e) {
			System.out.println("Not taking Screen Shot");
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
		obj.getScreenShot("43_Typeaheadbox");
		obj.click_On_Button("className", "search-submit-button");
		obj.expliciteWait(500);
		driver.navigate().back();
		obj.click_On_Link("className", "atoz-submit-button");
		obj.getScreenShot("43_Browse_A_Z");
		obj.click_On_Link("xpath", ".//*[@id='hm-AdamSearchBox']/div[2]/a[1]");
		obj.expliciteWait(500);
		driver.navigate().back();
		obj.click_On_Button("className", "search-home-button");
		obj.expliciteWait(500);
		driver.navigate().back();
	}
	
	
	@Test(priority=3)
	public void cssProperty()
	{
		System.out.println("********************Used CSS in Heading****************************");
		obj.fontProperty("className", "se-entry");
		System.out.println("********************Used CSS in Body Text****************************");
		obj.fontProperty("xpath", ".//*[@id='AgeStart']/div[2]/p");
		System.out.println("************************Used CSS Body text age selection**************************");
		obj.fontProperty("xpath", "html/body/div[1]/div[4]/div[3]/div[1]/div[2]/div/div[2]/p");
	}
	
	
	@Test(priority=4)
	public void selectAge()
	{
		obj.select_Value_from_DropDown("id", "M");
		obj.click_On_Button("className", "checkups-submit2");
		obj.expliciteWait(500);
		obj.isElementPresent("Health exams for: Men ages 50-59");
	}
	
	@Test(priority=5)
	public void secondaryPage()
	{
		System.out.println("*************CSS Used in secondary Page Exam Links******************************");
		obj.fontProperty("xpath", ".//*[@id='ResultMainDiv']/div/div[2]/div/div[1]/table/tbody/tr[1]/td[1]/a");
		System.out.println("**********************CSS Used in Frequency Text********************************");
		obj.fontProperty("xpath", ".//*[@id='ResultMainDiv']/div/div[2]/div/div[1]/table/tbody/tr[1]/td[2]");
		System.out.println("******************************CSS used in Inner Heading***********************");
		obj.fontProperty("className", "showImg-H2");
		System.out.println("***********************CSS Used in li*****************************************");
		obj.fontProperty("xpath", ".//*[@id='FooterNotes']/div/ul[1]");
		
	}

}
