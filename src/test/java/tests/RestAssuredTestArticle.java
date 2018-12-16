package tests;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class RestAssuredTestArticle {

    @Test(description = "GET")
    public void getRequestExampleTest() throws JSONException {
        Response response = get("https://httpbin.org/delay");
        System.out.println(response);
    }

    @Test(description = "GET")
    public void getRequestImgExampleTest() throws JSONException {
        Response response = get("https://httpbin.org/image/png");
        System.out.println(response);
    }

}
