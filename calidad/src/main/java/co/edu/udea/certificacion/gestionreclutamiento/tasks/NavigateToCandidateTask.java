package co.edu.udea.certificacion.gestionreclutamiento.tasks;

//public class NavigateToCandidateTask {
//    private NavigateToCandidateTask(){}
//}



import static co.edu.udea.certificacion.gestionreclutamiento.userinterfaces.CandidatesPageUserInterface.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavigateToCandidateTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"),
                Enter.theValue("Admin").into(USERNAME_INPUT),
                Enter.theValue("admin123").into(PASSWORD_INPUT),
                Click.on(LOGIN_BUTTON),
                Click.on(MODULE.of("Recruitment")),
                WaitUntil.the(TAB.of("Candidates"), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(TAB.of("Candidates"))
        );
    }

    public static NavigateToCandidateTask page() {
        return new NavigateToCandidateTask();
    }
}
