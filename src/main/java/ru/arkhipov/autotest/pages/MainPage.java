package ru.arkhipov.autotest.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.arkhipov.autotest.steps.BaseSteps;

import java.util.List;


/**
 * Created by Maria on 29.04.2017.
 */
public class MainPage extends BasePageObject{


    @FindBy(xpath = ".//a[text()='Афиша']")
    List<WebElement> menuItems;



    public MainPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMenuItem(String itemName){
        selectCollectionItem(itemName, menuItems);
    }


}


