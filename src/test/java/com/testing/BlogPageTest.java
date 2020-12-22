package com.testing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BlogPageTest extends BaseTest {

    @BeforeClass
    public void setUp() {
        webDriver.manage().window().maximize();
    }

    @Test
    public void checkBlogPageContent() {
        webDriver.get("https://t3ch5tuff5.wordpress.com");
        BlogPage blogPage = new BlogPage(webDriver).clickBlogMenu();

        assertEquals(blogPage.getPageTitle(), "Blog");
        assertEquals(blogPage.getArticleTitle(1),"Test automation and Cloud technologies — Part II: Using AWS ECR and AWS EC2");
        assertEquals(blogPage.getArticleTitle(2),"Containerization in test automation (II) – Containerization with microservices testing");
        assertEquals(blogPage.getArticleTitle(3),"Containerization in test automation (I) – Containerization with UI testing");
        assertEquals(blogPage.getArticleTitle(4),"Test automation and Cloud technologies — Part I: Using AWS EC2");
    }

}