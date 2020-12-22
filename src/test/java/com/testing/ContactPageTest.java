package com.testing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactPageTest extends BaseTest {

    @BeforeClass
    public void setUp() {
        webDriver.manage().window().maximize();
    }

    @Test
    public void checkContactPageContent() {
        webDriver.get("https://t3ch5tuff5.wordpress.com");
        ContactPage contactPage = new ContactPage(webDriver).clickContactMenu();

        assertEquals(contactPage.getPageTitle(), "Contact");
        assertEquals(contactPage.getTitle(), "Send Us a Message");
        assertTrue(contactPage.checkNameFieldPresent());
        assertTrue(contactPage.checkEmailFieldPresent());
        assertTrue(contactPage.checkWebsiteFieldPresent());
        assertTrue(contactPage.checkMessageFieldPresent());
        assertTrue(contactPage.checkSubmitButtonPresent());
    }

}