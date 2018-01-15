package codesquad.web.api;

import static io.restassured.RestAssured.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import codesquad.dto.UserDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Log
public class ApiUserAcceptanceTest {
	@Value("${local.server.port}")
	private int serverPort;

	@Before
	public void setup() {
		RestAssured.port = serverPort;
	}

	@Test
	public void createSuccess() throws Exception {
		UserDto newUser = new UserDto("testUser", "password", "testUser@korea.kr");
		given()
			.contentType(ContentType.JSON)
			.body(newUser)
			.when()
			.post("/api/users")
			.then()
			.statusCode(HttpStatus.OK.value());
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
