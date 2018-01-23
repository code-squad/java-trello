package codesquad.web.api;

import static io.restassured.RestAssured.given;

import org.junit.Test;
import org.springframework.http.HttpStatus;

import codesquad.domain.Card;
import io.restassured.http.ContentType;
import support.test.AcceptanceTest;

public class ApiCardAcceptanceTest extends AcceptanceTest{

	@Test
	public void create() {
		Card card = new Card();
		card.setName("newCard");
		given()
			.auth()
			.preemptive()
			.basic("hue@korea.kr", "password")
//			.form("hue@korea.kr", "password", new FormAuthConfig("/login", "username", "password"))
			.contentType(ContentType.JSON)
			.body(card)
		.when()
			.post("api/decks/1/cards")
		.then()
			.statusCode(HttpStatus.CREATED.value())
			.extract().as(Card.class);		
		}
}
