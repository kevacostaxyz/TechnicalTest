package tests1;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ApiTest {

    @Test
    public void testApiOne() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Response response = RestAssured.get("/posts/1");
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("title"), "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
    }

    @Test
    public void testApiTwo() {
        RestAssured.baseURI = "https://reqres.in";
        Response response = RestAssured.get("/api/users/2");
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("data.first_name"), "Janet");
        assertEquals(response.jsonPath().getString("data.last_name"), "Weaver");
    }
}
