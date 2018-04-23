package repository;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

public class Keywords 
{
	public WebDriver driver;

	public Keywords(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	
	
//******************************************locate Value*******************************************************
	public By locatorValue(String locatorTpye, String value) {
		By by;
		switch (locatorTpye) {
		case "id":
			by = By.id(value);
			break;
		case "className":
			by = By.className(value);
			break;
		case "name":
			by = By.name(value);
			break;
		case "xpath":
			by = By.xpath(value);
			break;
		case "css":
			by = By.cssSelector(value);
			break;
		case "linkText":
			by = By.linkText(value);
			break;
		case "partialLinkText":
			by = By.partialLinkText(value);
			break;
		default:
			by = null;
			break;
		}
		return by;
	}
	
	


	
//*******************************************enter_Text************************************************************
	public void enter_Text(String locatorType, String value, String text) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.sendKeys(text);
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to enter text" + e);
		}
	}

	
	
//****************************************************click_On_Link*************************************************
	public void click_On_Link(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.click();
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to enter text" + e);
		}
	}

	
//******************************************************click_On_Button*******************************************
	public void click_On_Button(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.click();
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to perform click" + e);
		}
	}
	
	
//*********************************Select Value fom drop down*****************************************************
	public void select_Value_from_DropDown(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			Select se=new Select(element);
			se.selectByIndex(3);
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to Select" + e);
		}
	}
	


//*********************************************Se3_Logo**********************************************************
	public void Se3_Logo(String locatorType, String value) 
	{
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
        		if (ImagePresent)
        		{
             			System.out.println("Smart Engage Logo Image is displayed.");
        		}
        		else
        		{
            			System.out.println("Smart Engage Logo Image is not displayed.");
        		}
			
			} 
			catch (NoSuchElementException e) 
			{
				System.err.format("No Element Found to perform click" + e);
			}
	}
	
	
//************************************************place Holder Value**********************************************
	public void placeHolderValue(String locatorType, String value) 
	{
		try 
		{
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			//String actValue="Health Search";
			Assert.assertEquals("Health Search", element.getAttribute("value"));
			System.out.println("Place Holder value is:-"+element.getAttribute("value"));
		} 
		catch (NoSuchElementException e) 
		{
			System.err.format("PlaceHolder value is not correct" + e);
		}
	}
	
	
//**********************************************Search_Validation_Message******************************************
	public void Search_Validation_Message(String locatorType, String value) 
	{
		try 
		{
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.click();
			Alert alert=driver.switchTo().alert();
			//Assert.assertEquals("Please be more specific with your search.",alert.getText());
			System.out.println("Validation message text is:-"+alert.getText());
			alert.accept();
		} 
		catch (NoSuchElementException e) 
		{
			System.err.format("Validation message is not correct" + e);
		}
	}
	
//********************************************font Property*******************************************************
	public void fontProperty(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			//Read font-size property and print It In console.
				  String fontSize = element.getCssValue("font-size");
				  System.out.println("Font Size -> "+fontSize);
				  
				  //Read color property and print It In console.
				  String fontColor = element.getCssValue("color");
				  String[] hexValue = fontColor.replace("rgba(", "").replace(")", "").split(",");
				  hexValue[0] = hexValue[0].trim();
				  int hexValue1 = Integer.parseInt(hexValue[0].trim());
				  //hexValue[1] = hexValue[1].trim();
				  int hexValue2 = Integer.parseInt(hexValue[1].trim());
				  //hexValue[2] = hexValue[2].trim();
				  int hexValue3 = Integer.parseInt(hexValue[2].trim());
				  //String actualColor = String.format(""#%02x%02x%02x", hexValue1, hexValue2, hexValue3);"
				  String ActualColor="#" + Integer.toHexString(hexValue1) + Integer.toHexString(hexValue2) + Integer.toHexString(hexValue3);
				  System.out.println("Font Color -> "+ActualColor);
				  
				  
				  //Read font-family property and print It In console.
				  String fontFamily = element.getCssValue("font-family");
				  System.out.println("Font Family -> "+fontFamily);
				  
				  //Read Text Decoration property and print it in console
				  String textDecoration = element.getCssValue("text-decoration");
				  System.out.println("Text Decoration ->"+textDecoration);
			
		} catch (NoSuchElementException e) {
			System.err.format("No Element found to read font Property" + e);
		}
	}
	
	
	
	
	
	public void backGround_Color(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			
				  
				  //Read color property and print It In console.
				  String brandingColor = element.getCssValue("background-color");
				  String[] hexValue = brandingColor.replace("rgba(", "").replace(")", "").split(",");
				  hexValue[0] = hexValue[0].trim();
				  int hexValue1 = Integer.parseInt(hexValue[0].trim());
				  //hexValue[1] = hexValue[1].trim();
				  int hexValue2 = Integer.parseInt(hexValue[1].trim());
				  //hexValue[2] = hexValue[2].trim();
				  int hexValue3 = Integer.parseInt(hexValue[2].trim());
				  //String actualColor = String.format(""#%02x%02x%02x", hexValue1, hexValue2, hexValue3);"
				  String ActualHeaderColor="#" + Integer.toHexString(hexValue1) + Integer.toHexString(hexValue2) + Integer.toHexString(hexValue3);
				  System.out.println("Font Color -> "+ActualHeaderColor);
			
		} catch (NoSuchElementException e) {
			System.err.format("No Element found to read font Property" + e);
		}
	}
	
	
//*********************************Element Present or Not***********************************************************
		public void isElementPresent(String text)
		{
			if(driver.getPageSource().contains(text))
			{
				System.out.println(text+" "+"Text is present");
			}
			else
			{
				System.out.println(text+" "+"Text is not present");
			}
		}
		
		
//***************************************************emplicitWait**************************************************		
		public void emplicitWait(String waitTO)
		{
			WebDriverWait wait=new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(waitTO)));
		}

		
//**********************************************expliciteWait******************************************************
		public void expliciteWait(int waitTo)
		{
			try 
			{
				Thread.sleep(waitTo);
			} 
			catch (InterruptedException e) 
			{
				
				System.out.println("Failed - unable to load the page");
				//return "Failed - unable to load the page";
			}
			//return "Pass";
		}
	
	
//****************************************Take the screenshot******************************************************
		
		public void getScreenShot(String imageName) throws IOException
		{
			try{
			if(imageName.equals(""))
			{
				imageName="blank";
			}
			File image = (File) ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//String imagelocation=System.getProperty("user.dir")+"\\src\\screenshot";
			String imagelocation="C:\\Users\\suneel.kumar\\workspace\\ADAM\\src\\screenshot\\";
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat farmater = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
			String actualImageName=imagelocation+imageName+"_"+farmater.format(calendar.getTime())+".png";
			File deatFile=new File(actualImageName);
			FileUtils.copyFile(image, deatFile);
			System.out.println("*********Scren Shot available in Images Dir in Project Directory****");
			}catch(Exception e)
			{
				System.out.println("Unable to take screenshot");
			}
		}
		
		

//******************take the screenshot of the entire home page and save it to a png file**************************
//		public void full_Page_ScreenShot(String imageName){
//		Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(1000)).takeScreenshot(driver);
//		String imagelocation="C:\\Users\\suneel.kumar\\workspace\\ADAM\\src\\screenshot\\";
//		Calendar calendar = Calendar.getInstance();
//		SimpleDateFormat farmater = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
//		String actualImageName=imagelocation+imageName+"_"+farmater.format(calendar.getTime())+".png";
//		try {
//			ImageIO.write(screenshot.getImage(), "PNG", new File(actualImageName));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		}
	
		
//******************************************verify Links Error Code************************************************
		
		public void verifyLinksErrorCode()
		{
			List<WebElement> links = driver.findElements(By.tagName("a"));	
			System.out.println("Total links are "+links.size());		
			for(int i=0; i<links.size(); i++) 
			{
				WebElement element = links.get(i);
				String url=element.getAttribute("href");
				verifyLink(url);			
			}	
		}
	
		public static void verifyLink(String urlLink) {
			//Sometimes we may face exception "java.net.MalformedURLException". 
			//Keep the code in try catch block to continue the broken link analysis
	        try {
				URL link = new URL(urlLink);
				HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
				httpConn.setConnectTimeout(2000);
				httpConn.connect();
					if(httpConn.getResponseCode()== 200) 
					{	
						System.out.println(urlLink+" - "+httpConn.getResponseMessage());
					}
					if(httpConn.getResponseCode()== 404) 
					{
						System.out.println(urlLink+" - "+httpConn.getResponseMessage());
					}
					
					if(httpConn.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
		           {
			               System.out.println(urlLink+" - "+httpConn.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
			       }
				}	
				catch (Exception e) {
			}
		}
		
		
		
		
}
