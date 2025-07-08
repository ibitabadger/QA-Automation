package co.edu.udea.certificacion.gestionreclutamiento.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/add_candidates.feature",
        glue = "co.edu.udea.certificacion.gestionreclutamiento.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class AddCandidateRunner {
}