import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/"}, glue = {"ru.arkhipov.autotest"},
        plugin = {
            "ru.arkhipov.autotest.utils.AllureReporter",
        }
)
public class CucumberRunner {

}
