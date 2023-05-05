package ui_tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/ShopForMultipleItemsTest.feature"},
        glue = {"steps.ShopStepDefinitions"}
)
public class StepRunner {
}
