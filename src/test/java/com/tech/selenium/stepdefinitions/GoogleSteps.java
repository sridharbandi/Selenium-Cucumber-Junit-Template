package com.tech.selenium.stepdefinitions;

import com.tech.selenium.driverutil.DriverFactory;
import com.tech.selenium.pageobjects.GoogleSearchPage;
import com.tech.selenium.pageobjects.SearchResultsPage;
import cucumber.api.Scenario;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * Created by Sridhar Bandi on 28/01/19.
 */
public class GoogleSteps implements En {

    private WebDriver driver;
    GoogleSearchPage googleSearchPage;
    SearchResultsPage searchResultsPage;

    public GoogleSteps() {

        Before((Scenario scenario) -> {
            driver = DriverFactory.getBrowser();
            googleSearchPage = new GoogleSearchPage(driver);
            searchResultsPage = new SearchResultsPage(driver);
        });

        Given("^User is on Google search page$", () -> {
            googleSearchPage.openURL();
        });

        When("^User searches for Selenium$", () -> {
            googleSearchPage.searchFor("Selenium");
        });

        Then("^User can see Selenium results$", () -> {
            Assert.assertTrue(searchResultsPage._lnkSelenium.isDisplayed());
        });

        After((Scenario scenario) -> {
            driver.quit();
        });

    }
}
