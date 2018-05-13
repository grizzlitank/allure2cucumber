package ru.arkhipov.autotest.steps;



import io.qameta.allure.Step;
import ru.arkhipov.autotest.pages.MainPage;


/**
 * Created by Maria on 29.04.2017.
 */
public class MainPageSteps {



    @Step("выбран пункт меню {menuItem}")
    public void selectMenuItem(String menuItem){
        new MainPage().selectMenuItem(menuItem);
    }



}
