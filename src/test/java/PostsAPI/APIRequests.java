package PostsAPI;

import static io.restassured.RestAssured.*;
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
}
