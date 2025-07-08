package co.edu.udea.certificacion.gestionreclutamiento.userinterfaces;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CandidatesPageUserInterface {

    public static final Target USERNAME_INPUT = Target.the("username field")
            .located(By.name("username"));

    public static final Target PASSWORD_INPUT = Target.the("password field")
            .located(By.name("password"));

    public static final Target LOGIN_BUTTON = Target.the("login button")
            .located(By.cssSelector("button[type='submit']"));

    public static final Target MODULE = Target.the("module {0}")
            .locatedBy("//span[text()='{0}']");

    public static final Target TAB = Target.the("tab {0}")
            .locatedBy("//*[text()='{0}']");

    public static final Target JOB_TITLE_DROPDOWN = Target
            .the("Job title dropdown")
            .located(By.xpath("//label[contains(text(),'Job Title')]/following::div[contains(@class,'oxd-select-text')]"));

    public static Target JOB_TITLE_OPTION(String option) {
        return Target.the("Job title option " + option)
                .located(By.xpath("//div[@role='listbox']//span[text()='" + option + "']"));
    }

    public static final Target SEARCH_BUTTON = Target.the("search button")
            .locatedBy("//button[contains(.,'Search')]");

    public static final Target RESET_BUTTON = Target.the("reset button")
            .locatedBy("//button[contains(.,'Reset')]");

    public static final Target ADD_BUTTON = Target.the("add button")
            .locatedBy("//button[contains(.,'Add')]");

    public static final Target SAVE_BUTTON = Target.the("save button")
            .locatedBy("//button[@type='submit' and contains(.,'Save')]");

    public static Target RESULT_WITH_JOB_TITLE(String jobTitle) {
        return Target.the("result with job title " + jobTitle)
                .located(By.xpath("//div[@role='table']//div[contains(text(),'" + jobTitle + "')]"));
    }

    public static final Target FIRST_NAME_INPUT = Target.the("first name input field")
            .located(By.name("firstName"));


    public static final Target LAST_NAME_INPUT = Target.the("Last Name field")
            .locatedBy("//input[@name='lastName']");

    public static final Target EMAIL_INPUT = Target.the("email input")
            .located(By.xpath("//input[@placeholder='Type here']"));

    public static Target CANDIDATE_NAME(String nombreCompleto) {
        return Target.the("nombre del candidato en la lista")
                .located(By.xpath(
                        "//p[contains(@class, 'oxd-text') and contains(@class, 'oxd-text--p') and contains(normalize-space(.),'" + nombreCompleto + "')]"
                ));
    }


//    public static final Target SUCCESS_MESSAGE = Target.the("Success message")
//            .locatedBy("//div[@id='oxd-toaster_1']//div[contains(text(),'Success')]");

}
