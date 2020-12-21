package com.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.Logger;

public class AboutPage extends TemplatePage {

    private WebDriver webDriver;
    private final static Logger logger = Logger.getLogger(AboutPage.class.getName());

    private final static String TITLE = "//h2";
    private final static String DESC = "//p";

    @FindBy(how = How.XPATH, using = TITLE)
    private WebElement title;

    @FindBy(how = How.XPATH, using = DESC)
    private WebElement description;



    public AboutPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public String getTitle() {
        logger.info("Retrieving About title");
        return title.getText();
    }

    public String getDescription() {
        logger.info("Retrieving About description");
        return description.getText();
    }

}
