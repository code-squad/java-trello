package codesquad.web.api;

import static io.restassured.RestAssured.given;

import org.junit.Test;
import org.springframework.http.HttpStatus;

import codesquad.dto.MemberDto;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.http.ContentType;
import support.test.AcceptanceTest;

public class ApiMemberAcceptanceTest extends AcceptanceTest {

	@Test
	public void createSuccess() throws Exception {
		MemberDto newMember = new MemberDto("testMember", "password", "testMember@korea.kr");
		given()
			.auth()
			.form("hue@korea.kr", "password", new FormAuthConfig("/login", "username", "password"))
			.contentType(ContentType.JSON)
			.body(newMember)
		.when()
			.post("/api/members")
		.then()
			.statusCode(HttpStatus.CREATED.value());
	}

	@Test
	public void createAlreadyExistedMember() throws Exception {
		MemberDto newMember = new MemberDto("testMember", "password", "hue@korea.kr");
		given()
//			.auth()
//			.form("hue@korea.kr", "password", new FormAuthConfig("/login", "username", "password"))
			.contentType(ContentType.JSON)
			.body(newMember)
		.when()
			.post("/api/members").then()
			.statusCode(HttpStatus.FORBIDDEN.value());
	}

}
