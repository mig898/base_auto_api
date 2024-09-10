package com.example.pe.definitions;

import com.example.base.questions.ResponseStatus;
import com.example.base.tasks.GetConsultarObjetos;
import com.example.base.tasks.GetConsultarObjetosPorId;
import com.example.base.tasks.PostCrearObjetos;
import com.example.base.util.ApiCommons;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;


public class ConsultaObjetosStepDefinition {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^que (.*) es una API publica")
    public void queObjetosEsUnaAPIPublica(String actor) {
        ApiCommons.URL_BASE = "https://api.restful-api.dev";
        theActorCalled(actor).whoCan(CallAnApi.at(ApiCommons.URL_BASE));
    }

    @When("Se realiza la consulta de la lista de objetos")
    public void seRealizaLaConsultaDeLaListaDeObjetos() {
        theActorInTheSpotlight().attemptsTo(
                new GetConsultarObjetos()
        );
    }

    @Then("^valida la respuesta sea (.*)$")
    public void validaLaRespuestaSea(int i) {
        System.out.println("RESP:" +lastResponse().getBody().asString());
        theActorInTheSpotlight().should(seeThat("El código de respuesta", ResponseStatus.getResponseStatus(), equalTo(i)));
    }

    @When("^Se inserta parametros al api consultar datos de Objetos (.*)")
    public void seInsertaParametrosAlApiConsultarDatosDeObjetosId(String id) {
        theActorInTheSpotlight().attemptsTo(GetConsultarObjetosPorId.withData(id));
    }

    @When("^Se inserta parametros al api crear datos de objetos (.*), (.*), (.*), (.*), (.*)")
    public void seInsertaParametrosAlApiCrearDatosDeObjetoS(String nombre, String periodo, String precio, String modelo, String capacidad) {
        theActorInTheSpotlight().attemptsTo(PostCrearObjetos.withData(nombre, periodo, precio, modelo, capacidad));
    }
}
