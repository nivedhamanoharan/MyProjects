package com.giveIndia.ui.automation.framework.utils;

public class Wiki_WebPage_Objects {
    private String wikiUrl = "https://en.wikipedia.org/wiki/Selenium";
    private String references = "(.//ol[contains(@class, 'references')])[2]";
    private String externalLinks = ".//li[contains(@class, 'toclevel-1 tocsection-33')]/a/span[contains(@class, 'toctext')]/..";
    private String externalLinkHeader = ".//span[@id='External_links']";
    private String oxygenLink = ".//td[contains(@title, 'Oxygen')]//a[contains(@title, 'Oxygen')]/..";
    private String elementInfoTable = ".//table[contains(@class, 'infobox')]";
    private String searchTextBox = ".//input[@type='search']";
    private String searchPlutonium = ".//div[contains(@class, 'suggestions-results')]/a[2]";

    public Wiki_WebPage_Objects() {}

    public void setWikiUrl(String wikiUrl) {
        this.wikiUrl = wikiUrl;
    }

    public String getWikiUrl() {
        return wikiUrl;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public String getReferences() {
        return references;
    }

    public void setExternalLinks(String externalLinks) {
        this.externalLinks = externalLinks;
    }

    public String getExternalLinks() {
        return externalLinks;
    }

    public void setExternalLinkHeader(String externalLinkHeader) {
        this.externalLinkHeader = externalLinkHeader;
    }

    public String getExternalLinkHeader() {
        return externalLinkHeader;
    }

    public void setOxygenLink(String oxygenLink) {
        this.oxygenLink = oxygenLink;
    }

    public String getOxygenLink() {
        return oxygenLink;
    }

    public void setElementInfoTable(String elementInfoTable) {
        this.elementInfoTable = elementInfoTable;
    }

    public String getElementInfoTable() {
        return elementInfoTable;
    }

    public void setSearchTextBox(String searchTextBox) {
        this.searchTextBox = searchTextBox;
    }

    public String getSearchTextBox() {
        return searchTextBox;
    }

    public void setSearchPlutonium(String searchPlutonium) {
        this.searchPlutonium = searchPlutonium;
    }

    public String getSearchPlutonium() {
        return searchPlutonium;
    }
}
