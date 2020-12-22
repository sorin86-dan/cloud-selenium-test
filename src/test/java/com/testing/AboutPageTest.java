package com.testing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AboutPageTest extends BaseTest {

    @BeforeClass
    public void setUp() {
        webDriver.manage().window().maximize();
    }

    @Test
    public void checkAboutPageContent() {
        webDriver.get("https://t3ch5tuff5.wordpress.com");
        AboutPage aboutPage = new AboutPage(webDriver).clickAboutMenu();

        assertEquals(aboutPage.getPageTitle(), "About");
        assertEquals(aboutPage.getTitle(), "Some stuffs about me and this blog");
        assertTrue(aboutPage.getDescription().contains("Cloud technologies"));
    }

}