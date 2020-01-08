package UIComponents;

import Foundation.BasePage;
import Foundation.Enums.Languages;
import Foundation.models.RepositorySearchResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class ReposList extends BasePage {

    public ReposList(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private final By lstReposList = locateElementByCss("ul.repo-list>li");
    private final By txtTitle = locateElementByCss("div:nth-child(1)>h3");
    private final By lnkTitle = locateElementByCss("div:nth-child(1)>h3>a");
    private final By txtLanguages = locateElementByCss("div:nth-child(1)>div:nth-of-type(1)>a");
    private final By txtPrimaryLanguage = locateElementByCss(" span[itemprop='programmingLanguage']");

    public HashSet<RepositorySearchResult> getAllResults(){
        List<WebElement> repos = getResults();
        HashSet<RepositorySearchResult> results = new HashSet<>();

        for(WebElement repo: repos){
            RepositorySearchResult result = new RepositorySearchResult();
            result.setTitle(getTitle(repo));
            result.setUrl(getLink(repo));
            result.setLanguages(getSupportedLanguages(repo));
            result.setLanguage(getPrimaryLanguage(repo));

            results.add(result);
        }

        return results;
    }

    private ArrayList<Languages> getSupportedLanguages(WebElement element){
        ArrayList<Languages> languages = new ArrayList<>();

        List<WebElement> el = findNestedElements(element,txtLanguages);
        for(WebElement language: el){
            try{
                languages.add(Languages.valueOf(getText(language)));
            }catch(Exception ex){
                languages.add(Languages.unknown);
            }
        }
        return languages;
    }
    private Languages getPrimaryLanguage(WebElement element){
        try{
            String s = getText(findNestedElement(element, txtPrimaryLanguage )).toLowerCase();
            return Languages.valueOf(s);
        }catch(IllegalArgumentException e){
            return Languages.unknown;
        }

    }
    private String getTitle(WebElement element){
        return getText(findNestedElement(element, txtTitle));
    }

    private WebElement getLink(WebElement element){
        return findNestedElement(element, lnkTitle);
    }
    private List<WebElement> getResults(){
        return  findElements(lstReposList);
    }
}
