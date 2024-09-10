package com.example.base.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseStatus{
    public static Question<Integer> getResponseStatus(){
        return actor -> SerenityRest.lastResponse().statusCode();
    }
}