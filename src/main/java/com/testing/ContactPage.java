package com.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.Logger;

public class ContactPage extends TemplatePage {

    private WebDriver webDriver;
    private final static Logger logger = Logger.getLogger(ContactPage.class.getName());

    private final static String TITLE = "//h2";
    private final static String NAME = "//input[@class='name']";
    private final static String EMAIL = "//input[@class='email']";
    private final static String WEBSITE = "//input[@class='url']";
    private final static String SUBMIT = "//button[@type='submit']";
    private final static String RESPONSE_TITLE = "//h3";

    @FindBy(how = How.XPATH, using = TITLE)
    private WebElement title;

    @FindBy(how = How.XPATH, using = NAME)
    private WebElement name;

    @FindBy(how = How.XPATH, using = EMAIL)
    private WebElement email;

    @FindBy(how = How.XPATH, using = WEBSITE)
    private WebElement website;

    @FindBy(how = How.CLASS_NAME, using = "textarea")
    private WebElement message;

    @FindBy(how = How.XPATH, using = SUBMIT)
    private WebElement submit;

    @FindBy(how = How.XPATH, using = RESPONSE_TITLE)
    private WebElement responseTitle;


    public ContactPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public String getTitle() {
        logger.info("Retrieving Contact title");
        return title.getText();
    }

    public boolean checkNameFieldPresent() {
        logger.info("Checking if field 'Name' is present");
        return name.isDisplayed();
    }

    public boolean checkEmailFieldPresent() {
        logger.info("Checking if field 'Email' is present");
        return email.isDisplayed();
    }

    public boolean checkWebsiteFieldPresent() {
        logger.info("Checking if field 'Website' is present");
        return website.isDisplayed();
    }

    public boolean checkMessageFieldPresent() {
        logger.info("Checking if field 'Message' is present");
        return message.isDisplayed();
    }

    public boolean checkSubmitButtonPresent() {
        logger.info("Checking if 'Submit' button is present");
        return submit.isDisplayed();
    }


}
