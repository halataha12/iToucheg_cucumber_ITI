package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
@CucumberOptions(
         features = "./src/main/java/features",
        glue = {"steps"},
        plugin = {"pretty",
                "html:Test-Output/cucumber-reports/report.html",
               "junit:Test-Output/cucumber-reports/report.xml",
                "json:Test-Output/cucumber-reports/report.json"
}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
