package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();


    /**
     * This method is used to initialize the threadlocal driver on the basis of given browser
     *
     * @param browser
     * @return
     */
    public WebDriver init_driver(String browser) {
        System.out.println("browser value is: " + browser);

        if (browser.equals("chrome")) {

//            ChromeOptions options = driver.ChromeOptions();
//            options.addArguments("ignore-certificate-errors");
            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("ignore-certificate-errors");
//            options.addArguments("chrome.switches", "-disable-extensions");
//            options.addArguments("--start-maximized");
//            options.addArguments("--disable-web-security");
//            options.addArguments("--disable-notifications");
//            options.addArguments("--no-proxy-server");
//            options.addArguments("--remote-allow-origins=*");
//            options.addArguments("--allowed-ips");
//            options.addArguments("--ignore-ssl-errors=yes");
//            options.addArguments("--ignore-certificate-errors");
//            options.addArguments("--allow-insecure-localhost");
//
//            Map<String, Object> prefs = new HashMap<>();
//            prefs.put("credentials_enable_service", false);
//            prefs.put("profile.password_manager_enabled", false);
//            options.setExperimentalOption("prefs", prefs);
//            options.setExperimentalOption("excludeSwitches", List.of(
//                    "enable-automation"));
//            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//            driver = new ChromeDriver(options);
            tlDriver.set(new ChromeDriver());
//
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            tlDriver.set(new EdgeDriver());
        } else {
            System.out.println("Please pass the correct browser value");
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    /**
     * This is used to get the driver with ThreadLocal
     *
     * @return
     */
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

}
