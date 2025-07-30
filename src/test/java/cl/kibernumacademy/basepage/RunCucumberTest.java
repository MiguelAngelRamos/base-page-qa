package cl.kibernumacademy.basepage;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

// Clase con una suite de pruebas para ejecutar Cucumber
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/Login.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "cl.kibernumacademy.basepage.steps") // Indicar donde estan los steps definitions
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,summary,json:target/cucumber-reports.json")
public class RunCucumberTest {
  
}
