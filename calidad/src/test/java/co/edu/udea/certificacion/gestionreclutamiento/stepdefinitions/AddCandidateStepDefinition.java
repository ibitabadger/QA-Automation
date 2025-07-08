package co.edu.udea.certificacion.gestionreclutamiento.stepdefinitions;

import co.edu.udea.certificacion.gestionreclutamiento.tasks.NavigateToCandidateTask;
import co.edu.udea.certificacion.gestionreclutamiento.userinterfaces.CandidatesPageUserInterface;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class AddCandidateStepDefinition {
    @Managed(driver = "chrome")
    public WebDriver driver;

    private final Actor usuario = Actor.named("usuario");

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("que estoy en el modulo de {string} en la pestana {string}")
    public void userIsInRecruitmentModule(String modulo, String pestana) {
        usuario.attemptsTo(
                NavigateToCandidateTask.page()
        );
    }

    @When("hago clic en el boton {string}")

    public void clicksAddButton(String boton) {
        usuario.attemptsTo(
                Click.on(CandidatesPageUserInterface.ADD_BUTTON)
        );
    }

    @And("completo el campo {string} con {string}")
    public void fillFieldWithValue(String campo, String valor) {
        switch (campo) {
            case "First Name":
                usuario.attemptsTo(
                        Enter.theValue(valor).into(CandidatesPageUserInterface.FIRST_NAME_INPUT)
                );
                break;
            case "Last Name":
                usuario.attemptsTo(
                        Enter.theValue(valor).into(CandidatesPageUserInterface.LAST_NAME_INPUT)
                );
                break;
            default:
                throw new IllegalArgumentException("Campo no soportado: " + campo);
        }
    }

    @And("ingreso el email {string}")
    public void enterEmail(String email) {
        usuario.attemptsTo(
                Enter.theValue(email).into(CandidatesPageUserInterface.EMAIL_INPUT)
        );
    }

    @And("hago clic en el botonn {string}")

    public void clickButtonn(String boton) {
        if (boton.equalsIgnoreCase("Save")) {
            usuario.attemptsTo(
                    Click.on(CandidatesPageUserInterface.SAVE_BUTTON)
            );
        } else {
            throw new IllegalArgumentException("Botón no soportado: " + boton);
        }
    }

    @Then("el candidato se registra exitosamente y aparece en la lista de candidatos {string}")
    public void verifyCandidateIsListed(String nombreCompleto) {
        usuario.attemptsTo(
                WaitUntil.the(CandidatesPageUserInterface.CANDIDATE_NAME(nombreCompleto), isVisible())
                        .forNoMoreThan(15).seconds(),
                Ensure.that(CandidatesPageUserInterface.CANDIDATE_NAME(nombreCompleto)).isDisplayed()
        );
    }


}
