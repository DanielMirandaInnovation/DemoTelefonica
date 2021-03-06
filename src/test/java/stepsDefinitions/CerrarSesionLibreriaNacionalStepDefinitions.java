package stepsDefinitions;

import java.io.IOException;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import questions.Condition;
import tasks.CerrarSesionLibreriaNacional;
import uis.IniciarSesionUserInterface;

public class CerrarSesionLibreriaNacionalStepDefinitions {

	@Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());

    }
	
	@Cuando("^cierre la sesion en la pagina$")
	public void cierreLaSesionEnLaPagina() {

	    OnStage.theActorInTheSpotlight().attemptsTo(CerrarSesionLibreriaNacional.deUsuarioLogueado());
		if (Condition.conditionVisible(OnStage.theActorInTheSpotlight(),IniciarSesionUserInterface.EMERGENT_WINDOW)){
			OnStage.theActorInTheSpotlight().attemptsTo(Click.on(IniciarSesionUserInterface.EMERGENT_WINDOW_CLOSE_BUTTON));
		}
	}
	
	@Entonces("^no podre ver el mensaje (.*) en la pagina$")
	public void noPodreVerElMensajeBienvenidoATuCuentaEnLaPagina(String mensajeEnPantalla) {
		OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(IniciarSesionUserInterface.TXT_VALIDACION.of(mensajeEnPantalla)), WebElementStateMatchers.isNotVisible()));
	}
}
