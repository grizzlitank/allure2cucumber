package ru.arkhipov.autotest.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class StudentsPageSteps {

    @Step("открыта страница {urlPage}")
    public void checkUrlPage(String urlPage){
        String url = BaseSteps.getDriver().getCurrentUrl();
        Assert.assertEquals("Все не очень хорошо", urlPage, url);
    }

    @Step("присутствует заголовок {title}")
    public void checkTitle(String titleOfPage) {
        WebElement title = BaseSteps.getDriver().findElement(By.xpath(".//span[text()='" + titleOfPage + "']"));
        Assert.assertEquals("Все не очень хорошо", titleOfPage, title.getText());
        System.out.println("Все хорошо " + titleOfPage + " найден");
        System.out.println();
    }

    @Step("присутствует ссылка {title}")
    public void checkLink(String link) {
        WebElement title = BaseSteps.getDriver().findElement(By.xpath(".//a[@href='" + link + "']"));
        System.out.println("Все хорошо " + link + " найден");
        System.out.println();
    }


}
