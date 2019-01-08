package Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import com.deque.axe.AXE;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
public class Test_Accessibility {
	@Rule
	public TestName testName = new TestName();
	//WebDriver driver;
	private static final URL scriptUrl = Test_Accessibility.class.getResource("/axe.min.js");

	@Test
	public void testAccessibility ()
	{
		 WebDriver driver;
			System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://demo.guru99.com/v4/");
			
			JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).analyze();

			JSONArray violations = responseJSON.getJSONArray("violations");

			if (violations.length() == 0) {
				assertTrue("No violations found", true);
			} else {
				AXE.writeResults(testName.getMethodName(), responseJSON);
				assertTrue(AXE.report(violations), false);
			}
	}

}
