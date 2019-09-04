package com.giveIndia.ui.automation.scripts.tests;


import com.giveIndia.ui.automation.framework.utils.Wiki_WebPage;
import org.junit.Test;

public class WikiPageTests {
    String screenshotFilePath;
    Integer pdfLinksCount;
    public Wiki_WebPage wikiWebPage;

    public WikiPageTests() {
        this.wikiWebPage = new Wiki_WebPage();
    }

    @Test
    public void wikiPageTests() throws Exception {
        wikiWebPage.getWikiPage();
        wikiWebPage.waitForPageLoaded();
        wikiWebPage.clickExternalLinks();
        wikiWebPage.verifyExternalLinks();
        wikiWebPage.clickOxygenLink();
        wikiWebPage.verifyOxygenFeaturedArticle();
        screenshotFilePath = wikiWebPage.getElementPropertiesScreenshot();
        pdfLinksCount = wikiWebPage.getRefPDFLinksCount();
        wikiWebPage.search();
        wikiWebPage.verifySearch();

        System.out.println("Screenshot taken for element properties is stored in : " + screenshotFilePath);
        System.out.println("PDF Links count under References Section : " + pdfLinksCount);
    }
}
