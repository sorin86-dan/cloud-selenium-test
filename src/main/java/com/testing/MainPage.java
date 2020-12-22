package com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.Logger;

public class MainPage extends TemplatePage {

    private WebDriver webDriver;
    private final static Logger logger = Logger.getLogger(MainPage.class.getName());

    private final static String TITLE = "//div[@class='entry-content']//h1";

    @FindBy(how = How.XPATH, using = TITLE)
    private WebElement title;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public String getTitle() {
        logger.info("Retrieving Home title");
        return title.getText();
    }

    public String getArticleTitle(int nrCrt) {
        logger.info("Retrieving title for article no. " + nrCrt);
        return webDriver.findElement(By.xpath("//div[contains(@class, 'wp-block-group')]//article[" + nrCrt + "]//h2")).getText();
    }

}
