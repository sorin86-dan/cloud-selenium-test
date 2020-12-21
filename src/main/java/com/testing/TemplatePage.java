package com.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.logging.Logger;

public class TemplatePage extends PageFactory {

    private WebDriver webDriver;
    private final static Logger logger = Logger.getLogger(TemplatePage.class.getName());

    private final static String SITE_MENU = "//ul[@id='menu-primary']/li";

    @FindBy(how = How.CLASS_NAME, using = "site-title")
    private WebElement siteTitle;

    @FindBy(how = How.CLASS_NAME, using = "entry-title")
    private WebElement pageTitle;

    @FindBy(how = How.XPATH, using = SITE_MENU)
    private List<WebElement> siteMenu;

    public TemplatePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public MainPage clickSiteTitle() {
        logger.info("Clicking website title");
        siteTitle.click();
        return new MainPage(webDriver);
    }

    public MainPage clickHomeMenu() {
        logger.info("Clicking Home menu item");
        siteMenu.get(0).click();
        return new MainPage(this.webDriver);
    }

    public BlogPage clickBlogMenu() {
        logger.info("Clicking Blog menu item");
        siteMenu.get(1).click();
        return new BlogPage(this.webDriver);
    }

    public AboutPage clickAboutMenu() {
        logger.info("Clicking About menu item");
        siteMenu.get(2).click();
        return new AboutPage(this.webDriver);
    }

    public ContactPage clickContactMenu() {
        logger.info("Clicking Contact menu item");
        siteMenu.get(3).click();
        return new ContactPage(this.webDriver);
    }

    public String getPageTitle() {
        logger.info("Retrieving page title");
        return pageTitle.getText();
    }
}
