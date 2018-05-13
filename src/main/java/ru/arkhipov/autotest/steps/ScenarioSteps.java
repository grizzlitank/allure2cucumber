package ru.arkhipov.autotest.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by m.baykova on 13.09.2017.
 */
public class ScenarioSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();

    PosterPageSteps posterPageSteps = new PosterPageSteps();


    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMenuItem(String menuName){
        mainPageSteps.selectMenuItem(menuName);
    }

    @When("^выбран вид развлечения \"(.+)\"$")
    public void selectMenuMovie(String menuNameMovie){
        posterPageSteps.selectMenuMovie(menuNameMovie);
    }

    @Then("^заголовок страницы кино равен \"(.+)\"$")
    public void checkTitleMoviePage(String title){
        posterPageSteps.checkTitle(title);
    }

    @When("^выбрана дата - Завтра$")
    public void selectMenuDate(){
        posterPageSteps.selectDate();
    }

    @When("^выбран фильм с оценкой болше 8$")
    public void selectMenuFilm(){
        posterPageSteps.selectFilmEight();
    }

    @Then("^фильм соответствует выбранному$")
    public void checkMenuFilm(){
        posterPageSteps.checkFilmEight();
    }


}
