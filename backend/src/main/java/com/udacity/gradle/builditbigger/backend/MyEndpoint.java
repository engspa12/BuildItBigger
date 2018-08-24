package com.udacity.gradle.builditbigger.backend;

import com.example.javajokeslibrary.JavaJoke;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that tells a joke */
    @ApiMethod(name = "sayJoke")
    public MyBean sayJoke() {

        JavaJoke joke = new JavaJoke();
        MyBean response = new MyBean();
        response.setData(joke.getJokeFromJavaLibrary() + " using our Google Cloud Endpoints development server.");

        return response;
    }

}
