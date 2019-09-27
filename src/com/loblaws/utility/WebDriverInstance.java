package com.loblaws.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.loblaws.RuntimeConfigs;

public final class WebDriverInstance {
	
	private static WebDriver webDriverInstance = null;

	public static WebDriver getWebDriverInstace() throws Exception {
		
		String browserDesktop;

		browserDesktop    = RuntimeConfigs.getconfigValue("app.Browser");
			
			if (browserDesktop.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + RuntimeConfigs.getconfigValue("chrome.driver"));
				if (webDriverInstance == null){
					DesiredCapabilities cap = DesiredCapabilities.chrome();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("test-type");
					//options.addArguments("headless");
					options.addArguments("disable-extensions");
					options.setExperimentalOption("useAutomationExtension", false);
					options.addArguments("disable-infobars");
					options.addArguments("start-maximized");
					cap.setCapability(ChromeOptions.CAPABILITY, options);
					
					webDriverInstance = new ChromeDriver(cap);
				}
			}else if(browserDesktop.equals("IE")) {
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + RuntimeConfigs.getconfigValue("IE.driver"));
				if (webDriverInstance == null){
					DesiredCapabilities capIE = DesiredCapabilities.internetExplorer();
					capIE.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
					capIE.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					capIE.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					capIE.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
					capIE.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
					capIE.setCapability("nativeEvents", false);
					capIE.setCapability("requireWindowFocus", true);
					capIE.setCapability("unexpectedAlertBehaviour", "accept");
					capIE.setCapability("ignoreProtectedModeSettings", true);
					capIE.setCapability("disable-popup-blocking", true);
					capIE.setCapability("enablePersistentHover", true);
					capIE.setCapability("allow-blocked-content", true);
					capIE.setCapability("allowBlockedContent", true);
					webDriverInstance = new InternetExplorerDriver(capIE);					
				}				
			}
		return webDriverInstance;
	}
	
	public static WebDriver getWebDriver(){
		
		return webDriverInstance;
	}
}
