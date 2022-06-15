package com.testing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MainPageTest extends BaseTest {

    @BeforeClass
    public void setUp() {
        webDriver.manage().window().maximize();
    }

    @Test
    public void checkMainPageContent() {
        webDriver.get("https://t3ch5tuff5.wordpress.com");
        MainPage mainPage = new TemplatePage(webDriver).clickHomeMenu();

        assertEquals(mainPage.getTitle(), "Welcome!");
        assertEquals(mainPage.getArticleTitle(1),"Test automation and Containerization (IV) – UI testing using Selenium Grid and Kubernetes");
        assertEquals(mainPage.getArticleTitle(2),"Test automation and Containerization (III) – UI testing using Selenium Grid and Testcontainers");
        assertEquals(mainPage.getArticleTitle(3),"Test automation and Cloud technologies — Part II: Using AWS ECR and AWS EC2");
    }

}