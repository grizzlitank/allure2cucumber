package ru.arkhipov.autotest.steps;



import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.arkhipov.autotest.pages.BasePageObject;

import java.util.List;


public class MainPageSteps {

    private BasePageObject basePageObject = new BasePageObject();

    @Step("выбран пункт меню {menuItem}")
    public void selectMenuItem(String menuItem){
        try {
            WebElement title = BaseSteps.getDriver().findElement(By.xpath(".//a[text()='" + menuItem + "']"));
            title.click();
        } catch (NoSuchElementException nsee) {
            System.out.println("Все не очень хорошо, потому что " + menuItem + " не найден");
            return;
        }
        System.out.println("Все хорошо " + menuItem + " найден");
        System.out.println();
    }

    @Step("выбран заголовок {menuItem}")
    public void selectTitle(String menuItem){
        WebElement title = BaseSteps.getDriver().findElement(By.xpath("//img[@title='" + menuItem + "']"));
        title.click();
        System.out.println("Все хорошо " + menuItem + " найден");
        System.out.println();
    }

    @Step("присутствует раздел меню {menuItem}")
    public void checkMenuItem(String menuItem) {
        WebElement title = BaseSteps.getDriver().findElement(By.xpath(".//a[text()='" + menuItem + "']"));
        Assert.assertEquals("Все не очень хорошо", menuItem, title.getText());
        System.out.println("Все хорошо " + menuItem + " найден");
        System.out.println();
    }

    @Step("перемещаем мышь в центр элемента {menuItem}")
    public void moveToItem(String menuItem) {
        WebElement title = BaseSteps.getDriver().findElement(By.xpath(".//a[text()='" + menuItem + "']"));
        Actions actions = new Actions(BaseSteps.getDriver());
        actions.moveToElement(title).build().perform();
        System.out.println("Все хорошо " + menuItem + " найден");
        System.out.println();
    }

    @Step("запущен поиск")
    public void selectSearch(){
        WebElement title = BaseSteps.getDriver().findElement(By.xpath(".//button[text()='Search']"));
        title.click();
        System.out.println("Все хорошо поиск найден");
        System.out.println();
    }

    @Step("вводим в поиск {search}")
    public void inputText(String search) {
        WebElement searchText = BaseSteps.getDriver().findElement(By.xpath("//input[@type = 'search']"));
        basePageObject.fillField(searchText, search);
        System.out.println("Все хорошо поиск найден");
        System.out.println();
    }

    @Step("проверяем количество найденных в графе Suggestions равно {searchCount}")
    public void checkSearch(String searchCount) {
        List<WebElement> searchElements = BaseSteps.getDriver().findElements(By.xpath("//h3[text() = 'Suggestions']/following-sibling::div/div"));
        Assert.assertEquals("Все не очень хорошо", Integer.parseInt(searchCount), searchElements.size());
        System.out.println("Все хорошо " + searchCount + " найдено");
        System.out.println();
    }



}
