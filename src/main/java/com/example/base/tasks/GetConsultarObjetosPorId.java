package com.example.base.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetConsultarObjetosPorId implements Task {
    private static final String URL_PATH = "/objects";
    private final String id;

    public GetConsultarObjetosPorId(String id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(Get.resource(URL_PATH)
                    .with(request -> request
                            .relaxedHTTPSValidation()
                            .contentType(ContentType.JSON)
                            .header("accept", "application/json")
                            .header("Content-Type", "application/json")
                            .param("id", id)
                            .log().all()
                    ));
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.toString());
        }

        System.out.println(SerenityRest.lastResponse().getStatusCode());

    }

    public static Performable withData(String id) {
        return instrumented(GetConsultarObjetosPorId.class, id);
    }

}
