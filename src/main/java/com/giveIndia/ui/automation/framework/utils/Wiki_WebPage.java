package com.giveIndia.ui.automation.framework.utils;

import com.google.common.io.Files;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.List;

public class Wiki_WebPage {
    public Wiki_WebPage_Objects wikiWebPageObjects;
    WebDriver driver;

    public Wiki_WebPage() {
        System.setProperty("webdriver.gecko.driver","C:\\geckoDriver\\geckodriver.exe");
        wikiWebPageObjects = new Wiki_WebPage_Objects();
        driver = new FirefoxDriver();
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    public void getWikiPage() {
        driver.get(wikiWebPageObjects.getWikiUrl());
    }

    public void clickExternalLinks() {
        driver.findElement(By.xpath(wikiWebPageObjects.getExternalLinks()));
    }

    public void verifyExternalLinks() {
        String externalLinkText = driver.findElement(By.xpath(wikiWebPageObjects.getExternalLinkHeader())).getText();
        Assert.assertEquals("External links", externalLinkText);
    }

    public void clickOxygenLink() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(wikiWebPageObjects.getOxygenLink())));
        element.click();
    }

    public void verifyOxygenFeaturedArticle() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals("https://en.wikipedia.org/wiki/Oxygen", currentURL);
    }

    public WebElement getElementInfoTable() {
        WebElement element = driver.findElement(By.xpath(wikiWebPageObjects.getElementInfoTable()));
        return element;
    }

    public String getElementPropertiesScreenshot() throws Exception {
        String filePath = System.getProperty("user.home") + "/ElementProperties.png";
        WebElement element = getElementInfoTable();
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver, element);
        ImageIO.write(screenshot.getImage(), "PNG", new File(filePath));
        return filePath;
    }

    public Integer getRefPDFLinksCount() {
        WebElement rootWebElement = driver.findElement(By.xpath(wikiWebPageObjects.getReferences()));
        List<WebElement> refPDFLinksCount = rootWebElement.findElements(By.tagName("li"));
        return refPDFLinksCount.size();
    }

    public void search() {
        driver.findElement(By.xpath(wikiWebPageObjects.getSearchTextBox())).sendKeys("pluto");
    }

    public void verifySearch() {
        WebElement searchElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(wikiWebPageObjects.getSearchPlutonium())));
        Assert.assertEquals("Plutonium", searchElement.getText());
    }
}
