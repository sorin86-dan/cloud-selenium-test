package com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class BlogPage extends TemplatePage {

    private WebDriver webDriver;
    private final static Logger logger = Logger.getLogger(BlogPage.class.getName());



    public BlogPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public String getArticleTitle(int nrCrt) {
        logger.info("Retrieving title for article no. " + nrCrt);
        return webDriver.findElement(By.xpath("//article[" + nrCrt + "]//h2")).getText();
    }
}
