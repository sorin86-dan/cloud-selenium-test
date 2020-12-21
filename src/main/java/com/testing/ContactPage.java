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
    private final static String SUBMIT = "//button[@type='submit']";
    private final static String RESPONSE_TITLE = "//h3";

    @FindBy(how = How.XPATH, using = TITLE)
    private WebElement title;

    @FindBy(how = How.CLASS_NAME, using = "name")
    private WebElement name;

    @FindBy(how = How.CLASS_NAME, using = "email")
    private WebElement email;

    @FindBy(how = How.CLASS_NAME, using = "url")
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

    public void fillName(String text) {
        logger.info("Filling field 'Name' with value: " + text);
        name.clear();
        name.click();
        name.sendKeys(text);
    }

    public void fillEmail(String text) {
        logger.info("Filling field 'Email' with value: " + text);
        email.clear();
        email.click();
        email.sendKeys(text);
    }

    public void fillWebsite(String text) {
        logger.info("Filling field 'Website' with value: " + text);
        website.clear();
        website.click();
        website.sendKeys(text);
    }

    public void fillMessage(String text) {
        logger.info("Filling field 'Message' with value: " + text);
        message.clear();
        message.click();
        message.sendKeys(text);
    }

    public void clickSubmitButton() {
        logger.info("Clicking 'Submit' button");
        submit.click();
    }

    public String getResponseTitle() {
        logger.info("Retrieving response title");
        return responseTitle.getText();
    }

}
