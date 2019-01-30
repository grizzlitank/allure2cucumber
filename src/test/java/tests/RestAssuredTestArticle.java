package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.testng.annotations.Test;

public class RestAssuredTestArticle {

    @Test(description = "GET")
    public void getRequestExampleTest() throws JSONException {
        RestAssured.baseURI = "https://httpbin.org/delay";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/10");
        System.out.println("Response Body is =>  " + response.asString());
    }

    @Test(description = "GET")
    public void getRequestImgExampleTest() throws JSONException {
        RestAssured.baseURI = "https://httpbin.org/image";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/png");
        System.out.println("Response Body is =>  " + response.asString());
    }

}
