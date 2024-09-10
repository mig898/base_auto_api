package com.example.base.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetConsultarObjetos implements Task {
    private static final String URL_PATH = "/objects";

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(Get.resource(URL_PATH)
                    .with(request -> request
                            .relaxedHTTPSValidation()
                            .contentType(ContentType.JSON)
                            .header("accept", "application/json")
                            .header("Content-Type", "application/json")
                            .log().all()
                    ));
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.toString());
        }

        System.out.println(SerenityRest.lastResponse().getStatusCode());


    }


}
