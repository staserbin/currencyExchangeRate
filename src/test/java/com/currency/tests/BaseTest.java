package com.currency.tests;

import com.currency.api.CurrencyEndpoint;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.logging.Logger;

public class BaseTest {

    public static final Logger LOGGER = Logger.getLogger("com.api.jar");

//    WebDriver driver;
//    CurrencyEndpoint currencyEndpoint;
//
//    @BeforeMethod
//    public void beforeMethod() {
//        System.setProperty("webdriver.chrome.driver", "//drivers/chromedriver");
//        driver = new ChromeDriver();
//        driver.get(BASE_URL);
//        currencyEndpoint = new CurrencyEndpoint(BASE_URL);
//    }
//
//    @AfterMethod
//    public void afterMethod() {
//        this.driver.quit();
//    }
}
