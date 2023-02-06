package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Operations extends TestBase {

	@Test(priority = 1, groups = "smoke", description = "Clear any data on screen")
	public void Clear() {
		CalculatorSession.findElementByAccessibilityId("clearEntryButton").click();
		Assert.assertEquals("0", _GetCalculatorResultText());
	}

	@Test(priority = 2, groups = "smoke", description = "Check Addition Operation")
	public void Addition() {
		CalculatorSession.findElementByAccessibilityId("num1Button").click();
		CalculatorSession.findElementByAccessibilityId("plusButton").click();
		CalculatorSession.findElementByAccessibilityId("num7Button").click();
		CalculatorSession.findElementByAccessibilityId("equalButton").click();
		Assert.assertEquals("8", _GetCalculatorResultText());
	}

	@Test(priority = 3, groups = "smoke", description = "Check Combination Operation")
	public void Combination() {
		CalculatorSession.findElementByAccessibilityId("num7Button").click();
		CalculatorSession.findElementByAccessibilityId("multiplyButton").click();
		CalculatorSession.findElementByAccessibilityId("num9Button").click();
		CalculatorSession.findElementByAccessibilityId("plusButton").click();
		CalculatorSession.findElementByAccessibilityId("num1Button").click();
		CalculatorSession.findElementByAccessibilityId("equalButton").click();
		CalculatorSession.findElementByAccessibilityId("divideButton").click();
		CalculatorSession.findElementByAccessibilityId("num8Button").click();
		CalculatorSession.findElementByAccessibilityId("equalButton").click();
		Assert.assertEquals("8", _GetCalculatorResultText());
	}

	@Test(priority = 4, groups = "smoke", description = "Check Division Operation")
	public void Division() {
		CalculatorSession.findElementByAccessibilityId("num8Button").click();
		CalculatorSession.findElementByAccessibilityId("num8Button").click();
		CalculatorSession.findElementByAccessibilityId("divideButton").click();
		CalculatorSession.findElementByAccessibilityId("num1Button").click();
		CalculatorSession.findElementByAccessibilityId("num1Button").click();
		CalculatorSession.findElementByAccessibilityId("equalButton").click();
		Assert.assertEquals("8", _GetCalculatorResultText());
	}

	@Test(priority = 5, groups = "smoke", description = "Check Multiplication Operation")
	public void Multiplication() {
		CalculatorSession.findElementByAccessibilityId("num9Button").click();
		CalculatorSession.findElementByAccessibilityId("multiplyButton").click();
		CalculatorSession.findElementByAccessibilityId("num9Button").click();
		CalculatorSession.findElementByAccessibilityId("equalButton").click();
		Assert.assertEquals("81", _GetCalculatorResultText());
	}

	@Test(priority = 6, groups = "smoke", description = "Check Subtraction Operation")
	public void Subtraction() {
		CalculatorSession.findElementByAccessibilityId("num9Button").click();
		CalculatorSession.findElementByAccessibilityId("minusButton").click();
		CalculatorSession.findElementByAccessibilityId("num1Button").click();
		CalculatorSession.findElementByAccessibilityId("equalButton").click();
		Assert.assertEquals("8", _GetCalculatorResultText());
	}

	protected String _GetCalculatorResultText() {
		// trim extra text and whitespace off of the display value
		return CalculatorResult.getText().replace("Display is ", "").trim();
	}

}
