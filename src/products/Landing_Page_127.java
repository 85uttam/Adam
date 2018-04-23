package products;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;



import repository.Keywords;
import base.Browsers;

public class Landing_Page_127 extends Browsers
{
	Keywords obj;
	
	@Test(priority=0)
	public void landingPage()
	{
	obj=new Keywords(driver);
	System.out.println("*********************Start Testing of Landing page*********************************");
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
		obj.Se3_Logo("xpath", ".//*[@id='site-title']/a/img");
	}
	
	
	
	@Test(priority=2)
	public void Verify_Lang_Toggle_Button()
	{
		System.out.println("#################################Verifying Lang Toggle Button######################################");
		 	String EsLang = driver.findElement(By.xpath(".//*[@id='lang_icons']/li[2]/a")).getAttribute("href");
	        System.out.println("URL of Spanish Toggle Button is=" +" "+EsLang);
	        
	        String PtLang = driver.findElement(By.xpath(".//*[@id='lang_icons']/li[3]/a")).getAttribute("href");
	        System.out.println("URL of portuguese Toggle Button is=" +" "+PtLang);
	        
	}
	
	@Test(priority=3)
	public void Verify_Health_News()
	{
		System.out.println("#################################Verifying Health News######################################");
		String expText="Health News";
		String actText=driver.findElement(By.xpath(".//*[@id='hd-news-hdr']/a/strong")).getText();
		if(actText.contains(expText))
		{
			System.out.println("Expected text '"+expText+"' present in the web page.");
		}else {
			System.out.println("Expected Text '"+expText+"' is not present in the web page"  );
		}
		//Verify health news section redirect to PID 35 successfully
	    try
	        {
	    		driver.findElement(By.xpath(".//*[@id='hd-news-hdr']/a/strong")).click();
	    		WebElement HealthNewsPage = driver.findElement(By.xpath(".//*[@id='images-pane']/h1"));
	    		String text = HealthNewsPage.getText();
	    		if(text.equals("News"))
	    		{
	    				System.out.println("----------Sucessful Redirect -------\n-----------------------");
	    				driver.navigate().back();
	    		}else
	    		{
	    				System.out.println("----------Fail To Redirect ----------\n-----------------------");
	    		}
	       }
	     catch(Throwable e)
	        {
	    	 			System.out.println("News text not found: "+e.getMessage());
	        }
	}
	
	@Test(priority=4)
	public void Verify_Test_Above_Search()
	{
		System.out.println("#################################Verifying Test Above Search Box######################################");
		String expText="Smart Decisions. Smart Health.";
		String actText = driver.findElement(By.xpath(".//*[@id='tag-line-127']/p")).getText();
		if(actText.contains(expText))
		{
			System.out.println("Expected text '"+expText+"' present in the web page.");
		}else{
			System.out.println("Expected Text '"+expText+"' is not present in the web page");
		}
	}
	
	@Test(priority=5)
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
	
	@Test(priority=6)
	  public void Links_Text_and_Links_URL () throws InterruptedException 
	  {
		
		System.out.println("#################################Verifying Links Text and Links URL######################################");
	  try {
	    List<WebElement> no = driver.findElements(By.tagName("a"));
	    int no_of_links = no.size(); 
	    System.out.println(no_of_links);
	    for (WebElement pagelink : no)
	         {
	          String linktext = pagelink.getText();
	          String link = pagelink.getAttribute("href"); 
	          System.out.println(linktext+" ->");
	          System.out.println(link);
	          }
	   }catch (Exception e){
	             System.out.println("error "+e);
	         }
	           
	  }

}
