package Test;

import Page.BasePage;
import Page.SignUpPage;
import Utilities.Constant;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Properties;

public class SignInTest extends BasePage {

    private SignUpPage signUpPage;
    public static Properties prop;
    
    @BeforeMethod
    public void setUp() {
        signUpPage = new SignUpPage(); 
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
    }

    @AfterMethod
    public void tearDown() {
    	try {
			Constant.TakeScreenshot();
			Constant.NormalWait();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        signUpPage.tearDown();
    }

    @Test
    public void testSuccessfulSignUp() throws InterruptedException, IOException {
        List<CSVRecord> testData = readCSVTestData(prop.getProperty("testdatadirectory"), "successfulSignUp");

        if (testData != null && !testData.isEmpty()) {
            CSVRecord scenarioData = testData.get(0);
            String username = scenarioData.get("username");
            String password = scenarioData.get("password");
            String age = scenarioData.get("age");
            String expectedMessage = scenarioData.get("expectedMessage");

            signUpPage.signUp(username, password, age);
            signUpPage.verifyWelcomeMessage(expectedMessage);
        } else {
        	System.out.println("testdata is not found");
        }
    }

    @Test
    public void testSignUpWithIncorrectUsernamePasswordAndAge() throws InterruptedException, IOException {
        List<CSVRecord> testData = readCSVTestData(prop.getProperty("testdatadirectory"), "testSignUpWithIncorrectUsernamePasswordAndAg");

        if (testData != null && !testData.isEmpty()) {
            CSVRecord scenarioData = testData.get(0);
            String username = scenarioData.get("username");
            String password = scenarioData.get("password");
            String age = scenarioData.get("age");
            String expectedErrorMessage = scenarioData.get("expectedMessage");

            signUpPage.signUp(username, password, age);
            signUpPage.verifyErrorMessage(expectedErrorMessage);
         
        } else {
            System.out.println("testdata is not found");
        }
    }
    @Test
    public void testSignUpWithNumbersAndSpecialCharacterUsername() throws InterruptedException, IOException {
        List<CSVRecord> testData = readCSVTestData(prop.getProperty("testdatadirectory"), "testSignUpWithNumbersAndSpecialCharacterUsername");

        if (testData != null && !testData.isEmpty()) {
            CSVRecord scenarioData = testData.get(0);
            String username = scenarioData.get("username");
            String password = scenarioData.get("password");
            String age = scenarioData.get("age");
            String expectedErrorMessage = scenarioData.get("expectedMessage");

            signUpPage.signUp(username, password, age);
            signUpPage.verifyErrorMessage(expectedErrorMessage);
        } else {
            System.out.println("testdata is not found");
        }
    }
    @Test
    public void testSignUpWithoutUsername() throws InterruptedException, IOException {
        List<CSVRecord> testData = readCSVTestData(prop.getProperty("testdatadirectory"), "testSignUpWithoutUsername");

        if (testData != null && !testData.isEmpty()) {
            CSVRecord scenarioData = testData.get(0);
            String username = scenarioData.get("username");
            String password = scenarioData.get("password");
            String age = scenarioData.get("age");
            String expectedErrorMessage = scenarioData.get("expectedMessage");

            signUpPage.signUp(username, password, age);
            signUpPage.verifyErrorMessage(expectedErrorMessage);
        } else {
            System.out.println("testdata is not found");
        }
    }
    @Test
    public void testSignUpWithWeakPassword() throws InterruptedException, IOException {
        List<CSVRecord> testData = readCSVTestData(prop.getProperty("testdatadirectory"), "testSignUpWithWeakPassword");

        if (testData != null && !testData.isEmpty()) {
            CSVRecord scenarioData = testData.get(0);
            String username = scenarioData.get("username");
            String password = scenarioData.get("password");
            String age = scenarioData.get("age");
            String expectedErrorMessage = scenarioData.get("expectedMessage");

            signUpPage.signUp(username, password, age);
            signUpPage.verifyErrorMessage(expectedErrorMessage);
        } else {
            System.out.println("testdata is not found");
        }
    }
    @Test
    public void testSignUpWithoutPassword() throws InterruptedException, IOException {
        List<CSVRecord> testData = readCSVTestData(prop.getProperty("testdatadirectory"), "testSignUpWithoutPassword");

        if (testData != null && !testData.isEmpty()) {
            CSVRecord scenarioData = testData.get(0);
            String username = scenarioData.get("username");
            String password = scenarioData.get("password");
            String age = scenarioData.get("age");
            String expectedErrorMessage = scenarioData.get("expectedMessage");

            signUpPage.signUp(username, password, age);
            signUpPage.verifyErrorMessage(expectedErrorMessage);
        } else {
            System.out.println("testdata is not found");
        }
    }
    @Test
    public void testSignUpWithAgeAboveLimit() throws InterruptedException, IOException {
        List<CSVRecord> testData = readCSVTestData(prop.getProperty("testdatadirectory"), "testSignUpWithAgeAboveLimit");

        if (testData != null && !testData.isEmpty()) {
            CSVRecord scenarioData = testData.get(0);
            String username = scenarioData.get("username");
            String password = scenarioData.get("password");
            String age = scenarioData.get("age");
            String expectedErrorMessage = scenarioData.get("expectedMessage");

            signUpPage.signUp(username, password, age);
            signUpPage.verifyErrorMessage(expectedErrorMessage);
        } else {
            System.out.println("testdata is not found");
        }
    }
    @Test
    public void testSignUpWithAgeBelowLimit() throws InterruptedException, IOException {
        List<CSVRecord> testData = readCSVTestData(prop.getProperty("testdatadirectory"), "testSignUpWithAgeBelowLimit");

        if (testData != null && !testData.isEmpty()) {
            CSVRecord scenarioData = testData.get(0);
            String username = scenarioData.get("username");
            String password = scenarioData.get("password");
            String age = scenarioData.get("age");
            String expectedErrorMessage = scenarioData.get("expectedMessage");

            signUpPage.signUp(username, password, age);
            signUpPage.verifyErrorMessage(expectedErrorMessage);
        } else {
            System.out.println("testdata is not found");
        }
    }
   @Test
    public void testSignUpWithOutAge() throws InterruptedException, IOException {
        List<CSVRecord> testData = readCSVTestData(prop.getProperty("testdatadirectory"), "testSignUpWithOutAge");

        if (testData != null && !testData.isEmpty()) {
            CSVRecord scenarioData = testData.get(0);
            String username = scenarioData.get("username");
            String password = scenarioData.get("password");
            String age = scenarioData.get("age");
            String expectedErrorMessage = scenarioData.get("expectedMessage");

            signUpPage.signUp(username, password, age);
            signUpPage.verifyErrorMessage(expectedErrorMessage);
        } else {
            System.out.println("testdata is not found");
        }
    }
    @Test
    public void testSignUpWithOutUsernamePasswordAndAge() throws InterruptedException, IOException {
        List<CSVRecord> testData = readCSVTestData(prop.getProperty("testdatadirectory"), "testSignUpWithOutUsernamePasswordAndAge");

        if (testData != null && !testData.isEmpty()) {
            CSVRecord scenarioData = testData.get(0);
            String username = scenarioData.get("username");
            String password = scenarioData.get("password");
            String age = scenarioData.get("age");
            String expectedErrorMessage = scenarioData.get("expectedMessage");

            signUpPage.signUp(username, password, age);
            signUpPage.verifyErrorMessage(expectedErrorMessage);
            
        } else {
            System.out.println("testdata is not found");
        }
    }
    @Test
    public void testScreenRotation() throws InterruptedException, IOException {
        List<CSVRecord> testData = readCSVTestData(prop.getProperty("testdatadirectory"), "successfulSignUp");
        
        ScreenOrientation initialOrientation = driver.getOrientation();
        System.out.println("Initial Orientation: " + initialOrientation);
        
        try {
	        driver.rotate(ScreenOrientation.LANDSCAPE);
	        if (testData != null && !testData.isEmpty()) {
	            CSVRecord scenarioData = testData.get(0);
	            String username = scenarioData.get("username");
	            String password = scenarioData.get("password");
	            String age = scenarioData.get("age");
	            String expectedMessage = scenarioData.get("expectedMessage");
	
	            signUpPage.signUp(username, password, age);
	            signUpPage.verifyWelcomeMessage(expectedMessage);
	        } else {
	        	System.out.println("testdata is not found");
	        }
        }
        catch (Exception e) {
        	System.out.println("Element not visible in landscape mode");
        }
    }
    private List<CSVRecord> readCSVTestData(String filePath, String scenarioName) throws IOException {
        Reader reader = new FileReader(filePath);
        CSVParser csvParser = CSVFormat.DEFAULT.withHeader().parse(reader);

        List<CSVRecord> records = csvParser.getRecords();
        csvParser.close();

        for (CSVRecord record : records) {
            if (record.get("scenarioName").equals(scenarioName)) {
                return List.of(record);
            }
        }

        return null;
    }
    


}
