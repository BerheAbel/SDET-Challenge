package Page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.UUID;

public class BasePage {

    public static AppiumDriver<MobileElement> driver;
    public static Properties prop;

    public BasePage() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"//Properties//Config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName",prop.getProperty("platformName") );
        capabilities.setCapability("udid", prop.getProperty("DeivceName"));
        capabilities.setCapability("app", prop.getProperty("appDirectory"));

        try {
            driver = new AndroidDriver<>(new URL(prop.getProperty("URL")), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
	public void screenshot(String path_screenshot) throws IOException{
	    File srcFile=driver.getScreenshotAs(OutputType.FILE);
	    String filename=UUID.randomUUID().toString(); 
	    File targetFile=new File("C:\\Users\\ppsde\\eclipse-workspace-sdet\\Android\\ScreenShots" + filename +".jpg");
	    FileUtils.copyFile(srcFile,targetFile);
	}
}

