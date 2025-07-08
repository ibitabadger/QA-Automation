package co.edu.udea.certificacion.gestionreclutamiento.stepdefinitions;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.annotations.Managed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

import net.serenitybdd.screenplay.actions.*;
import co.edu.udea.certificacion.gestionreclutamiento.tasks.NavigateToCandidateTask;
import co.edu.udea.certificacion.gestionreclutamiento.userinterfaces.CandidatesPageUserInterface;




public class CandidatesFilterStepDefinition {

    @Managed(driver="chrome")
    public WebDriver driver;

    private final Actor usuario = Actor.named("usuario");

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("que estoy en el módulo de {string} en la pestaña {string}")
    public void userIsInRecruitmentModule(String modulo, String pestana) {
        usuario.attemptsTo(
                NavigateToCandidateTask.page()
        );
    }

    @When("selecciono el campo {string} con valor {string} de la lista desplegable")
    public void selectsJobTitleFromDropdown(String campo, String valor) {
        if (campo.equalsIgnoreCase("Job Title")) {
            usuario.attemptsTo(
                    Click.on(CandidatesPageUserInterface.JOB_TITLE_DROPDOWN),
                    Click.on(CandidatesPageUserInterface.JOB_TITLE_OPTION(valor))
            );
        } else {
            throw new IllegalArgumentException("Campo no soportado: " + campo);
        }
    }

    @And("hago clic en el botón {string}")
    public void clicksSearchButton(String boton) {
        usuario.attemptsTo(
                Click.on(CandidatesPageUserInterface.SEARCH_BUTTON)
        );
    }

    @Then("la lista de candidatos se actualiza mostrando solo los perfiles con {string} como Job Title")
    public void candidateListFilteredByJobTitle(String jobTitle) {
        usuario.attemptsTo(
                Ensure.that(CandidatesPageUserInterface.RESULT_WITH_JOB_TITLE(jobTitle)).isDisplayed()
        );
    }


}



