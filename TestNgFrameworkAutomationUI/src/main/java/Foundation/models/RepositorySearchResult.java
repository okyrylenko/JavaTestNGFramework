package Foundation.models;

import Foundation.Enums.Languages;
import org.openqa.selenium.WebElement;

import java.util.Date;
import java.util.List;

public class RepositorySearchResult {

    private String title;
    private WebElement url;
    private Languages language;
    private String license;
    private List<Languages> languages;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public WebElement getUrl() {
        return url;
    }

    public void setUrl(WebElement url) {
        this.url = url;
    }

    public Languages getLanguage() {
        return language;
    }

    public void setLanguage(Languages language) {
        this.language = language;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public List<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Languages> languages) {
        this.languages = languages;
    }
}
