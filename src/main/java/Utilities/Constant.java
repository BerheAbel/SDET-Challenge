package Utilities;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import Page.BasePage;

public class Constant extends BasePage {
	
	public static void PageLoadTime()throws Exception
	{
		driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);		
	}
	public static void TakeScreenshot()throws Exception
	{
		File Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screenshot, new File(System.getProperty("user.dir")+"//Screenshots//"+System.currentTimeMillis()+".png"));
		System.out.println("Screenshot is captured successfully");
	}
	public static void NormalWait()throws Exception
	{
		Thread.sleep(3000);
		System.out.println("Normal Wait time is completed successfully");		
	}
	public static void HighWait()throws Exception
	{
		Thread.sleep(6000);
		System.out.println("High Wait time is completed successfully");		
	}

}




