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

        assertEquals("Contact", contactPage.getPageTitle());
        assertEquals("Send Us a Message", contactPage.getTitle());
    }

    @Test
    public void sendMessage() {
        webDriver.get("https://t3ch5tuff5.wordpress.com");
        ContactPage contactPage = new ContactPage(webDriver).clickContactMenu();

        contactPage.fillName("TestUser");
        contactPage.fillEmail("testuser@test.com");
        contactPage.fillWebsite("https://test-blog.test.com");
        contactPage.fillMessage("This is a test message");
        contactPage.clickSubmitButton();

        assertEquals("Message Sent (go back)", contactPage.getResponseTitle());
    }

}