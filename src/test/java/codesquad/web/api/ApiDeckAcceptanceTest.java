package codesquad.web.api;

import static io.restassured.RestAssured.given;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import codesquad.domain.Deck;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.http.ContentType;
import support.test.AcceptanceTest;

public class ApiDeckAcceptanceTest extends AcceptanceTest{
	private static final Logger log = LoggerFactory.getLogger(ApiDeckAcceptanceTest.class);

	@Test
	public void create() {
		Deck deck = new Deck();
		deck.setName("newDeck");
		given()			
			.auth()
			.form("hue@korea.kr", "password", new FormAuthConfig("/login", "username", "password"))
			.contentType(ContentType.JSON)
			.body(deck)
		.when()
			.post("/api/boards/1/decks")
		.then()
			.statusCode(HttpStatus.CREATED.value())
			.extract().as(Deck.class);		
		}
}
