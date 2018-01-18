package codesquad.web.api;

import static io.restassured.RestAssured.given;

import org.junit.Test;
import org.springframework.http.HttpStatus;

import codesquad.dto.UserDto;
import io.restassured.http.ContentType;
import support.test.AcceptanceTest;

public class ApiUserAcceptanceTest extends AcceptanceTest{

	@Test
	public void createSuccess() throws Exception {
		UserDto newUser = new UserDto("testUser", "password", "testUser@korea.kr");
		given()
			.contentType(ContentType.JSON)
			.body(newUser)
		.when()
			.post("/api/users")
		.then()
			.statusCode(HttpStatus.CREATED.value());
	}
	
	@Test
	public void createAlreadyExistedUser() throws Exception {
		UserDto newUser = new UserDto("testUser", "password", "hue@korea.kr");
		given()
			.contentType(ContentType.JSON)
			.body(newUser)
		.when()
			.post("/api/users")
		.then()
			.statusCode(HttpStatus.FORBIDDEN.value());
	}
	
}
