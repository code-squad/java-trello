package codesquad.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import support.test.AcceptanceTest;

import static io.restassured.RestAssured.given;

public class LoginAcceptanceTest extends AcceptanceTest{
	@Value("${local.server.port}")
	private int serverPort;

	@Before
	public void setup() {
		RestAssured.port = serverPort;
	}

	@Test
	public void loginSuccess() throws Exception {
		given()
				.param("username", "hue@korea.kr")
				.param("password", "password")
		.when()
			.post("/login")
		.then()
			.statusCode(HttpStatus.FOUND.value());
	}

	@Test
	public void loginEmptyEmail() throws Exception {
		given()
			.param("username", "other" + "hue@korea.kr")
			.param("password", "password")
		.when()
			.post("/login")
		.then()
			.statusCode(HttpStatus.UNAUTHORIZED.value());
	}

	@Test
	public void loginOtherPassword() throws Exception {

		given()
			.param("username", "hue@korea.kr")
			.param("password", "other" +  "password")
		.when()
			.post("/login")
		.then()
			.statusCode(HttpStatus.UNAUTHORIZED.value());
	}
	
}
