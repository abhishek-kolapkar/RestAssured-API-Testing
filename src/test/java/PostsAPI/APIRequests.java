package PostsAPI;

import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class APIRequests {
  @Test
  void getPosts() {
    given()

        .when()
        .get("https://jsonplaceholder.typicode.com/posts")

        .then()
        .statusCode(200)
        .log().all();
  }
  
  @Test
  void createPost() {
    JSONObject data = new JSONObject();
    data.put("title", "New Post");
    data.put("body", "This is the body of the new post");
    data.put("userId", 1);

    given()
        .contentType("application/json")
        .body(data)

        .when()
            .post("https://jsonplaceholder.typicode.com/posts")
            
        .then()
            .statusCode(201)
            .log().all();
  }
}
