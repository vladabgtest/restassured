package org.api.testing;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetRequest{
    

    String BaseURL = "http://restapi.demoqa.com/utilities/weather/city";


    @Test
    public void getWeatherDetails() {
        RestAssured.baseURI = BaseURL;
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET,"/Belgrade");
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        int statusCode = response.getStatusCode();
        System.out.println("Status code: " + statusCode);
        Assert.assertEquals(statusCode, 200);

        String statusLine = response.getStatusLine();
        System.out.println("Status line: " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }
}
