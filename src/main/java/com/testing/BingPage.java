package com.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class BingPage extends PageFactory {

    private WebDriver webDriver;
    private final static Logger logger = Logger.getLogger(BingPage.class.getName());

    private final static String SEARCH_BOX = "//input[@name='q']";
    private final static String SEARCH_OUTPUT_LINK = "//h2/a";

    @FindBy(how = How.XPATH, using = SEARCH_BOX)
    private WebElement searchBox;

    @FindBy(how = How.XPATH, using = SEARCH_OUTPUT_LINK)
    private List<WebElement> searchOutputLink;

    public BingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void fillSearchBox(String text) {
        logger.info("Filling search box with '" + text + "'");
        searchBox.clear();
        searchBox.sendKeys(text);
        searchBox.submit();
    }

    public boolean isSearchOutputLinkPresent() {
        logger.info("Checking if search output link is present");
        return searchOutputLink.size() > 0 && searchOutputLink.get(0).isDisplayed();
    }

    public String getSearchOutputLink(int current) {
        logger.info("Retrieving the content of search output link: " + searchOutputLink.get(current).getText());
        return searchOutputLink.get(current).getText();
    }

    public void clickSearchOutputLink(int current) {
        logger.info("Clicking search output link '" + searchOutputLink.get(current).getText() + "'");
        searchOutputLink.get(current).click();
    }

    public List<String> getSearchOutputLinks() {
        logger.info("Retrieving search output links");
        return searchOutputLink.stream().map(el -> el.getText()).collect(Collectors.toList());
    }
}
