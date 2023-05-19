package test.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "src/test/resources/AppFeatures",
        glue = {"stepDefinitions", "appHooks"},
        plugin = { "pretty",
                "timeline:test-output-thread/",
                "html:test-output/cucumber-report/nopCommerce-pretty.html",
                "json:test-output/cucumber-report/nopCommerce.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

        },
        tags = "@skip"


)
public class MyTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }

}