package codesquad.web.api;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import codesquad.dto.MemberDto;
import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.http.ContentType;
import support.test.AcceptanceTest;

import static io.restassured.RestAssured.given;

public class ApiLoginAcceptanceTest extends AcceptanceTest{
	@Value("${local.server.port}")
	private int serverPort;

	@Before
	public void setup() {
		RestAssured.port = serverPort;
	}

	@Test
	public void loginSuccess() throws Exception {
		MemberDto newMember = new MemberDto("hue@korea.kr", "password");
		given()
		.auth().form("hue@korea.kr", "password")
//			.contentType(ContentType.JSON)
//			.body(newMember)
		.when()
			.post("/login")
		.then()
			.statusCode(HttpStatus.OK.value());
	}

	@Test
	public void loginEmptyEmail() throws Exception {
		MemberDto newMember = new MemberDto("wwww" + "hue@korea.kr", "password");
		given()
			.contentType(ContentType.JSON)
			.body(newMember)
		.when()
			.post("/api/login")
		.then()
			.statusCode(HttpStatus.UNAUTHORIZED.value());
	}

	@Test
	public void loginOtherPassword() throws Exception {
//		content-type: application/x-www-form-urlencoded
//		MemberDto newMember = new MemberDto("hue@korea.kr", "password" + "222");

		given()
			.auth()
			.form("hue@korea.kr", "password", new FormAuthConfig("/login", "username", "password"))
//			.contentType(ContentType.TEXT)
//			.body(newMember)
		.when()
			.post("/login")
		.then()
			.statusCode(HttpStatus.UNAUTHORIZED.value());
	}
	
	@Test
	public void loginEmptyEmail2() throws Exception {
//		content-type: application/x-www-form-urlencoded
//		MemberDto newMember = new MemberDto("hue@korea.kr", "password" + "222");

		given()
			.auth()
			.form("hue@korea.kr" , "password", new FormAuthConfig("/login", "username", "password"))
//			.contentType(ContentType.TEXT)
//			.body(newMember)
		.when()
			.post("/login")
		.then()
			.statusCode(HttpStatus.UNAUTHORIZED.value());
	}

}
