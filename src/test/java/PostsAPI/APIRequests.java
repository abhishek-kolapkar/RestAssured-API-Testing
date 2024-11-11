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

  @Test
  void updatePost() {
    JSONObject data = new JSONObject();
    data.put("title", "Updated Post");
    data.put("body", "This is the updated body of the post");
    data.put("userId", 1);

    given()
        .contentType("application/json")
        .body(data)

        .when()
        .put("https://jsonplaceholder.typicode.com/posts/2")

        .then()
        .statusCode(200)
        .log().all();
  }

  @Test
  void deletePost() {
    given()

        .when()
        .delete("https://jsonplaceholder.typicode.com/posts/5")

        .then()
        .statusCode(200)
        .log().all();
  }
}
