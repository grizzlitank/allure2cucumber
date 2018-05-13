package ru.arkhipov.autotest.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.arkhipov.autotest.steps.BaseSteps;
import ru.arkhipov.autotest.utils.Stash;

import java.util.Formatter;
import java.util.List;

public class PosterPage extends BasePageObject {

    @FindBy(xpath = ".//a[text()='Кино']")
    List<WebElement> menuMovie;


    @FindBy(xpath = ".//h1")
    public WebElement title;

    @FindBy(xpath = ".//span[text()='Когда']/parent::button")
    public WebElement buttonWhen;

    @FindBy(xpath = ".//span[text()='Завтра']/parent::div")
    public WebElement buttonTomorrow;

    @FindBy(xpath = "//span[text()='Закрыть']/parent::button")
    public WebElement close1;

    @FindBy(xpath = "//div[@class='tutorial-modal__close']")
    public WebElement close2;


    @FindBy(xpath = "//div[@class='event-rating__value']")
    public List<WebElement> rating;

    @FindBy(xpath = ".//h1[@class='event-heading__title']")
    public WebElement titleFilm;


    @FindBy(xpath = "//span[@class='event-heading__place']")
    public WebElement countFilm;

    private static final String filmXpath = "//div[@class='event-rating__value' and text()='%s' ]//ancestor::div[@class='event__image']/following-sibling::div[@class='event__inner']";

    public PosterPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMenuMovie(String itemName){
        selectCollectionItem(itemName, menuMovie);
    }

    public void selectDate(){
        close1.click();
        waiting(buttonWhen);
        buttonWhen.click();
        waiting(buttonTomorrow);
        buttonTomorrow.click();
    }

    public void selectFilm(){
        close2.click();

        String ratingNumber="";
        for(WebElement element : rating){
            if(element.getText().startsWith("8")) ratingNumber = element.getText();
        }

        Formatter f = new Formatter();

        WebElement film = BaseSteps.getDriver().findElement(By.xpath(f.format(filmXpath, ratingNumber).toString()));

        Stash.put("name", film.findElement(By.xpath(".//h2")).getText());

        Stash.put("count", film.findElement(By.xpath(".//span[@class='event__place-name']")).getText());

        film.click();
    }

    public void checkFilm(){

        waiting(titleFilm);

        Assert.assertEquals("Название фильма соответствует заявленному", Stash.get("name"), titleFilm.getText());

        Assert.assertEquals("Количество кинотеатров соответствует заявленному", Stash.get("count"), countFilm.getText());
    }

}
