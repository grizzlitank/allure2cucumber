package ru.arkhipov.autotest.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPageSteps {

    public static List<WebElement> searches;
    @Step("проверяем количество найденных записей на странице равно {searchCount} и во всех есть кнопка ADD TO CART")
    public void checkSearchList(String searchCount) {
        List<WebElement> searchElements = BaseSteps.getDriver().findElements(By.xpath("//div[@class = 'products-list']/section"));
        Assert.assertEquals("Все не очень хорошо", Integer.parseInt(searchCount), searchElements.size());
        for (int i = 1; i <= 10; i++) {
            WebElement add = BaseSteps.getDriver().findElement(By.xpath("//div[@class = 'products-list']/section[" + i + "]//*[text()='Add to cart']"));
            Assert.assertEquals("Все не очень хорошо", "ADD TO CART", add.getText());
        }
        System.out.println("Все хорошо " + searchCount + " найдено");
        System.out.println();
    }

    @Step("сохраняем найденный список")
    public void saveSearchList() {
        List<WebElement> searchElements = BaseSteps.getDriver().findElements(By.xpath("//div[@class = 'products-list']/section"));
        searches = searchElements;
        System.out.println("Все хорошо список найден и сохранен");
        System.out.println();
    }

    @Step("проверяем, что список по тому же значению равен предыдущей итерации")
    public void compareSearchList() {
        List<WebElement> searchElements = BaseSteps.getDriver().findElements(By.xpath("//div[@class = 'products-list']/section"));
        Assert.assertEquals("Все не очень хорошо", searches, searchElements);
        System.out.println("Все хорошо список найден");
        System.out.println();
    }


}
