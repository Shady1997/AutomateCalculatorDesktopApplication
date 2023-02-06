package test_cases;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.windows.WindowsDriver;
import pages.PageBase;

public class TestBase {
	public static WindowsDriver<WebElement> CalculatorSession = null;
	public WebElement CalculatorResult = null;
	public DesiredCapabilities capabilities;

	@BeforeClass
	public void setup() {
		try {
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
			capabilities.setCapability("platformName", "Windows");
			capabilities.setCapability("platformVersion", "1.0");

			CalculatorSession = new WindowsDriver<WebElement>(new URL("http://127.0.0.1:4723"), capabilities);
			CalculatorSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			CalculatorResult = CalculatorSession.findElementByAccessibilityId("CalculatorResults");
			Assert.assertNotNull(CalculatorResult);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	@AfterTest
	public void TearDown() {
		CalculatorResult = null;
		if (CalculatorSession != null) {
			CalculatorSession.quit();
		}
		CalculatorSession = null;
	}

	public static void getScreenshotOnFailure() {
		PageBase.captureScreenshot(CalculatorSession, "fail" + java.time.LocalTime.now());
	}

}
