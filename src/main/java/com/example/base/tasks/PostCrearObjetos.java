package com.example.base.tasks;

import com.example.base.util.ApiCommons;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostCrearObjetos implements Task {
    private static final String URL_PATH = "/objects";
    private static final String JSON_REQUEST = "/request/pruebaDeApi.json";

    private final String nombre, periodo, precio, modelo, capacidad;

    public PostCrearObjetos(String nombre, String periodo, String precio, String modelo, String capacidad) {
        this.nombre = nombre;
        this.periodo = periodo;
        this.precio = precio;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(Post.to(URL_PATH)
                    .with(request -> request
                            .relaxedHTTPSValidation()
                            .contentType(ContentType.JSON)
                            .header("accept", "application/json")
                            .header("Content-Type", "application/json")
                            .log().all()
                            .body(ApiCommons.getTemplate(JSON_REQUEST)
                                    .replace("{nombre}",nombre)
                                    .replace("{periodo}",periodo)
                                    .replace("{precio}",precio)
                                    .replace("{modelo}",modelo)
                                    .replace("{capacidad}",capacidad)

                            )
                    ));
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.toString());
        }

        System.out.println(SerenityRest.lastResponse().getStatusCode());

    }

    public static Performable withData(String nombre,String periodo,String precio, String modelo, String capacidad) {
        return instrumented(PostCrearObjetos.class, nombre, periodo, precio, modelo, capacidad);
    }

}
