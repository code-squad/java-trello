package codesquad.web;

import static io.restassured.RestAssured.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.authentication.FormAuthConfig;
import support.test.AcceptanceTest;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BoardsAcceptanceTest extends AcceptanceTest{

	@Test
	public void show() {
		given()
			.auth()
			.form("hue@korea.kr", "password", new FormAuthConfig("/login", "username", "password"))
		.when()
			.get("/myboards")
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void showNoLogin() {
		given()
		.when()
			.get("/myboards")
		.then()
			.statusCode(HttpStatus.FORBIDDEN.value());
	}

}
