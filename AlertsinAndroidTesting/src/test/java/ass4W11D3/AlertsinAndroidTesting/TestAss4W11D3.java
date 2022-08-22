package ass4W11D3.AlertsinAndroidTesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class TestAss4W11D3 {
	private AndroidDriver driver;

	@BeforeSuite
	public void setUp() throws MalformedURLException, InterruptedException {

		// Setting up desire caps using DesireCapabilities class
		// Create an object for Desired Capabilities
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

		// Set capabilities
		desiredCapabilities.setCapability("appium:app",
				"C:\\Users\\lo0ol\\eclipse-workspace\\AlertsinAndroidTesting\\Collect-data-Application.apk");
		desiredCapabilities.setCapability("appium:deviceName", "23b9cb400c1c7ece");
		desiredCapabilities.setCapability("appium:platformName", "Android");
		desiredCapabilities.setCapability("appium:platformVersion", "10");
		desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

		// Java package of the Android app you want to run
		desiredCapabilities.setCapability("appium:appPackage", "com.example.mahhid_collect_data");

		// Activity name for the Android activity you want to launch from your package
		desiredCapabilities.setCapability("appium:appActivity", "com.example.mahhid_collect_data.SplashScreen");

		// Initialize the driver object with the URL to Appium Server and
		// passing the capabilities
		URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@BeforeTest
	public void location() throws InterruptedException {
		// Allow using location
		if (driver
				.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"))
				.isDisplayed()) {
			WebElement allowElement = driver.findElement(
					AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
			allowElement.click();
			System.out.println("Click on Button");
		}
		Thread.sleep(4000);
	}

	@Test
	public void sendKeyTest() throws InterruptedException {
		// Enable location
		if (driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout")).isDisplayed()) {
			// click on more detail icon (arrow)
			WebElement moreDetail = driver.findElement(AppiumBy.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout"));
			moreDetail.click();
			System.out.println("click on arrow");
			Thread.sleep(2000);

			// take the message
			String result = driver.findElement(AppiumBy.id("com.google.android.gms:id/message")).getText();
			System.out.println("Alert text Is -> " + result);
			Thread.sleep(2000);

			// click on OK
			WebElement ok = driver.findElement(AppiumBy.id("android:id/button1"));
			ok.click();
			System.out.println("Click on OK");

		}
		Thread.sleep(5000);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
