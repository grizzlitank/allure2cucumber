package ru.arkhipov.autotest.steps;

import io.qameta.allure.Step;
import ru.arkhipov.autotest.pages.PosterPage;

import static org.junit.Assert.assertTrue;

public class PosterPageSteps{

    @Step("выбран вид развлечения {menuMovie}")
    public void selectMenuMovie(String menuMovie){
        new PosterPage().selectMenuMovie(menuMovie);
    }


    @Step("заголовок страницы кино равен {expectedTitle}")
    public void checkTitle(String expectedTitle){
        String actualTitle = new PosterPage().title.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @Step("выбрана дата - Завтра")
    public void selectDate(){
        new PosterPage().selectDate();
    }

    @Step("выбран фильм с оценкой болше 8")
    public void selectFilmEight(){
        new PosterPage().selectFilm();
    }

    @Step("фильм соответствует выбранному")
    public void checkFilmEight(){
        new PosterPage().checkFilm();
    }
}
