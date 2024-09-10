package com.example.base.util;

import net.serenitybdd.screenplay.Actor;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ApiCommons {

    public static String URL_BASE = "";
    public static Actor act;


    public static String getTemplate(String templatePath) {
        try {
            return IOUtils.toString(new ClassPathResource(templatePath).getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
