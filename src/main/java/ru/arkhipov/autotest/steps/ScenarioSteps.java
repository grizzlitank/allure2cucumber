package ru.arkhipov.autotest.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();

    StudentsPageSteps studentsPageSteps = new StudentsPageSteps();

    SearchPageSteps searchPageSteps = new SearchPageSteps();


    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMenuItem(String menuName){
        mainPageSteps.selectMenuItem(menuName);
    }

    @When("^присутствует раздел меню \"(.+)\"$")
    public void checkMenuItem(String menuName){
        mainPageSteps.checkMenuItem(menuName);
    }

    @When("^присутствуют поля:$")
    public void checkMenuItem(DataTable fields){
        fields.asList(String.class)
                .forEach((value) -> mainPageSteps.checkMenuItem(value));
    }

    @When("^перемещаем мышь в центр элемента \"(.+)\"$")
    public void moveToItem(String menuName){
        mainPageSteps.moveToItem(menuName);
    }

    @When("^открыта страница \"(.+)\"$")
    public void checkUrlPage(String urlPage){
        studentsPageSteps.checkUrlPage(urlPage);
    }

    @When("^присутствует заголовок \"(.+)\"$")
    public void checkTitle(String titlePage){
        studentsPageSteps.checkTitle(titlePage);
    }

    @When("^присутствует ссылка \"(.+)\"$")
    public void checkLink(String link){
        studentsPageSteps.checkLink(link);
    }

    @When("^выбран заголовок \"(.+)\"$")
    public void selectTitle(String menuName){
        mainPageSteps.selectTitle(menuName);
    }

    @When("^запущен поиск$")
    public void selectSearch(){
        mainPageSteps.selectSearch();
    }

    @When("^вводим в поиск \"(.+)\"$")
    public void selectSearch(String search){
        mainPageSteps.inputText(search);
    }

    @When("^проверяем количество найденных в графе Suggestions равно \"(.+)\"$")
    public void checkSearch(String search){
        mainPageSteps.checkSearch(search);
    }

    @When("^проверяем количество найденных записей на странице равно \"(.+)\" и во всех есть кнопка ADD TO CART$")
    public void checkSearchList(String search){
        searchPageSteps.checkSearchList(search);
    }

    @When("^сохраняем найденный список$")
    public void saveSearchList(){
        searchPageSteps.saveSearchList();
    }

    @When("^проверяем, что список по тому же значению равен предыдущей итерации$")
    public void compareSearchList(){
        searchPageSteps.compareSearchList();
    }


}
