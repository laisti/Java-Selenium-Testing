//package com.pch.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverTest {

    WebDriver driver;

    /**
     * Test to navigate Yahoo page
     *
     * Starting point will be the yahoo.com
     *
     * *** You may want to do a manual test at first to gather the needed
     * element locators needed for the test ****** Run Thru The Debugger
     *
     * https://www.yahoo.com
     *
     * Follow Steps below
     *
     */

    @Test
    public void funWithYahooPage() {

        driver.get("https://www.yahoo.com/");

        // Step 1. Assert that we are on the correct page by checking that title = 'Yahoo'
        String yahooTitle = driver.getTitle();
        Assert.assertTrue(yahooTitle.contains("Yahoo"));

        /*
         * Step 2. Display the count of options on the left side panel ('Mail', 'News', 'Sports',......)
         * including 'More Yahoo Sites' option
         */
        WebElement menu = driver.findElement(By.cssSelector("ul[class='Miw(1000px) Mx(a) HideBottomBar_Op(0) Reader-open_Op(0) ua-ie7_Maw(1000px) ua-ie8_Maw(1000px) Maw(1278px)']"));
        List<WebElement> options = menu.findElements(By.tagName("li"));
        System.out.println(options.size());

        // Step 3: Enter 'Nutrition' on the search bar on the top
        WebElement searchInput =   driver.findElement(By.xpath("//*[@id='uh-search-box']"));
        searchInput.sendKeys("Nutrition");

        // Step 4: Click Search button
        driver.findElement(By.xpath("//*[@id='uh-search-button']")).click();

        // Step 5: Display count of Images on the page
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println(images.size());

        // Step 6. Click 'Sign In' button on the top left side
        driver.findElement(By.xpath("//*[@id='yucs-login_signIn']")).click();

        // Step 7. Display the boolean state of the checkbox next to 'Keep me signed in'
        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        System.out.println(checkbox.isSelected());

        // Step 8. Click 'Sign In' button
        driver.findElement(By.xpath("//*[@id='login-signin']")).click();

        /*
         * Step 9. Error will be displayed.
         * Assert true when the error message contains the expectedErrorStr defined below
         */
        String expectedErrorStr = "Sorry, we don't recognize this email.";
        String errorMessage = driver.findElement(By.xpath("//*[@id='username-error']")).getText();
        Assert.assertTrue(errorMessage.contains(expectedErrorStr));
    }

    /**
     * Test to simulate an attempted Sign in to Paypal and validate error
     * message returned
     *
     * Starting point will be the PayPal
     *
     * *** You may want to do a manual test at first to gather the needed
     * element locators needed for the test ****** Run Thru The Debugger
     *
     * https://www.paypal.com
     *
     * Follow Steps below
     *
     */

    @Test
    public void funWithPayPalSignUpPage() {

        driver.get("https://www.paypal.com");

        /*
         * Step 1. Assert that we are on the correct page by checking that title = 'Send Money, Pay Online or Set Up
         * a Merchant Account - PayPal'
         */

        // Step 2. Click 'Sign Up for Free' button

        // Step 3: Enter email address test@google.com

        // Step 4: Enter password test123

        // Step 5: Enter confirm password test123

        // Step 6: Click 'Continue' button

        /*
         * Step 7. Error will be displayed
         * Assert True that error message contains the expectedErrorStr defined below
         */
        String expectedErrorStr = "It looks like you already signed up.";

        // Step 8. Print out the boolean state of the 'confirmPassword' input field displayed

        // Step 9. Display the count of Images on the Sign In page

        // Step 10. Display the country flag shown on the bottom right side
    }

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
