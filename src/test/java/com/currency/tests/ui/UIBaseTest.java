package com.currency.tests.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.logging.Logger;

public class UIBaseTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "//drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void afterMethod() {
        this.driver.quit();
    }
}
