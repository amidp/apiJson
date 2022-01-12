import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class JsonPlaceHolder {
@BeforeClass
    public static void setUp(){
   // RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
  //  RestAssured.basePath="todos/29";
}
    @Test
    public void getUse_ToDos(){
        Response response = given()
                .baseUri("https://jsonplaceholder.typicode.com/")
                .basePath("todos")
                .when()
                .get("29");
        System.out.println(response.body().asString());
        Assert.assertEquals(200,response.statusCode());
        System.out.println(response.statusCode());
        JsonPath responseJson = response.getBody().jsonPath();
        Assert.assertEquals("laborum aut in quam",responseJson.getString("title"));
        System.out.println(responseJson.getString("title"));
        Assert.assertEquals("false",responseJson.getString("completed"));
        System.out.println(responseJson.getString("completed"));
    }


@Test
    public void verify_By_Address_Gratitude(){
    Response response = given()
            .baseUri("https://jsonplaceholder.typicode.com/")
            .basePath("users")
            .when()
            .get("5");
    Assert.assertEquals(200,response.statusCode());
    System.out.println(response.statusCode());
    System.out.println(response.body().asString());
    JsonPath responseJson = response.getBody().jsonPath();
    Assert.assertEquals("Chelsey Dietrich",responseJson.getString("name"));
    System.out.println(responseJson.getString("name"));
    Assert.assertEquals("Skiles Walks",responseJson.getString("address.street"));
    System.out.println(responseJson.getString("address.street"));
    Assert.assertEquals("-31.8129",responseJson.getString("address.geo.lat"));
    System.out.println(responseJson.getString("address.geo.lat"));
    Assert.assertEquals("User-centric fault-tolerant solution",responseJson.getString("company.catchPhrase"));
    System.out.println(responseJson.getString("company.catchPhrase"));
}


@Test
    public void verify_By_Title_Id(){
    Response response = given()
            .baseUri("https://jsonplaceholder.typicode.com/")
            .basePath("posts")
            .when()
            .get("15");
    System.out.println(response.body().asString());
    Assert.assertEquals(200,response.statusCode());
    System.out.println(response.statusCode());
    JsonPath responseJson = response.getBody().jsonPath();
    Assert.assertEquals("eveniet quod temporibus",responseJson.getString("title"));
    Assert.assertEquals(2,responseJson.getInt("userId"));

}

}
