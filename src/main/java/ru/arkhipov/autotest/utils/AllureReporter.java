package ru.arkhipov.autotest.utils;


import gherkin.formatter.model.Result;
import io.qameta.allure.cucumberjvm.AllureCucumberJvm;
import ru.arkhipov.autotest.steps.BaseSteps;


/**
 * Created by 777 on 08.05.2017.
 */
public class AllureReporter extends AllureCucumberJvm {

    @Override
    public void result(final Result result) {
        if (result.getStatus().equals("failed")){
            BaseSteps.takeScreenshot();
        }
        super.result(result);
    }


}



