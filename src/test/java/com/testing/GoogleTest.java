package com.testing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.testng.Assert.assertTrue;

public class GoogleTest extends BaseTest {

    private final Logger logger = Logger.getLogger(GoogleTest.class.getName());
    private GooglePage googlePage;

    @BeforeClass
    public void setUp() {
        googlePage = new GooglePage(webDriver);

        webDriver.manage().window().maximize();
    }


    @Test
    public void clickFirstSearchOutputLink() throws Exception {
        runTest(0);
    }

    @Test
    public void clickSecondSearchOutputLink() throws Exception {
        runTest(1);
    }

    @Test
    public void clickThirdSearchOutputLink() throws Exception {
        runTest(2);
    }

    @Test
    public void clickForthSearchOutputLink() throws Exception {
        runTest(3);
    }

    @Test
    public void clickFifthSearchOutputLink() throws Exception {
        runTest(4);
    }

    @Test
    public void clickSixthSearchOutputLink() throws Exception {
        runTest(5);
    }

    @Test
    public void clickSeventhSearchOutputLink() throws Exception {
        runTest(6);
    }

    @Test
    public void clickEightSearchOutputLink() throws Exception {
        runTest(7);
    }

    @Test
    public void clickNinethSearchOutputLink() throws Exception {
        runTest(8);
    }

    @Test
    public void clickLastSearchOutputLink() throws Exception {
        runTest(9);
    }

    public void runTest(int id) throws Exception {
        webDriver.get("https://www.google.com");
        googlePage.fillSearchBox("cloud automated testing");

        assertTrue(googlePage.isSearchOutputLinkPresent());
        assertTrue(googlePage.getSearchOutputLinks().size() >= 10);

        try {
            googlePage.clickSearchOutputLink(id);
        } catch (Exception e) {
            logger.warning("test-google-" + id + "-" + browser + ".png - " + getErrorMessage(e.getMessage()));
            takeSnapShot(webDriver, "test-google-" + id + "-" + browser + ".png");
        }
    }

}