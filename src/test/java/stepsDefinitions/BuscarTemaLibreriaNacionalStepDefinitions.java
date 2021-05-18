package stepsDefinitions;

import java.io.IOException;

import net.serenitybdd.screenplay.actions.Click;
import org.hamcrest.Matchers;

import cucumber.api.java.Before;
import cucumber.api.java.es.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.Condition;
import questions.ValidarExistenciaElemento;
import tasks.BuscarTemaLibreriaNacional;
import uis.InformacionPersonalUserInterface;
import uis.IniciarSesionUserInterface;


public class BuscarTemaLibreriaNacionalStepDefinitions {

	@Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());



    }
	
	@Cuando("^busque el tema (.*) en la pagina$")
	public void busqueElTemaFilosofiaEnLaPagina(String tema) {

		OnStage.theActorInTheSpotlight().attemptsTo(BuscarTemaLibreriaNacional.deObjectivo(tema));
		if (Condition.conditionVisible(OnStage.theActorInTheSpotlight(),IniciarSesionUserInterface.EMERGENT_WINDOW)){
			OnStage.theActorInTheSpotlight().attemptsTo(Click.on(IniciarSesionUserInterface.EMERGENT_WINDOW_CLOSE_BUTTON));
		}
	}

	@Entonces("^podre ver que obtuvo (.*) en resultados de la busqueda$")
	public void podreVerQueObtuvoTrueEnResultadosDeLaBusqueda(String respuesta) {
	OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarExistenciaElemento.conTarget(InformacionPersonalUserInterface.LIST_RESULTADOS_TEMA), Matchers.equalTo(Boolean.valueOf(respuesta))));
	}
}
