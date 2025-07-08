package co.edu.udea.certificacion.gestionreclutamiento.stepdefinitions;

import co.edu.udea.certificacion.gestionreclutamiento.tasks.NavigateToCandidateTask;
import co.edu.udea.certificacion.gestionreclutamiento.userinterfaces.CandidatesPageUserInterface;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.WebDriver;

public class ResetFilterStepDefinition {

    @Managed(driver = "chrome")
    public WebDriver driver;

    private final Actor usuario = Actor.named("usuario");

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("que estoy en el módulo {string} en la pestaña {string}")
    public void userIsInRecruitmentModule(String modulo, String pestana) {
        usuario.attemptsTo(
                NavigateToCandidateTask.page()
        );
    }

    @When("selecciono el campo {string} de valor {string} de la lista desplegable")
    public void selectsFieldFromDropdown(String campo, String valor) {
        if (campo.equalsIgnoreCase("Job Title")) {
            usuario.attemptsTo(
                    Click.on(CandidatesPageUserInterface.JOB_TITLE_DROPDOWN),
                    Click.on(CandidatesPageUserInterface.JOB_TITLE_OPTION(valor))
            );
        } else {
            throw new IllegalArgumentException("Campo no soportado: " + campo);
        }
    }


    @And("hago click en el botón {string}")
    public void clicksResetButton(String boton) {
        usuario.attemptsTo(
                Click.on(CandidatesPageUserInterface.RESET_BUTTON)
        );
    }


    @Then("los filtros de búsqueda se muestran en su estado inicial")
    public void filtersAreReset() {
        usuario.attemptsTo(
                Ensure.that(CandidatesPageUserInterface.JOB_TITLE_DROPDOWN)
                        .text().isEqualTo("-- Select --")
        );
    }
}
