package codesquad.web.api;

import static io.restassured.RestAssured.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import codesquad.domain.Card;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiCardAcceptanceTest {
	@Value("${local.server.port}")
	private int serverPort;

	@Before
	public void setup() {
		RestAssured.port = serverPort;
	}

	@Test
	public void create() {
		Card card = new Card();
		card.setName("newCard");
		given()
			.contentType(ContentType.JSON)
			.body(card)
		.when()
			.post("/api/card/1")
		.then()
			.statusCode(HttpStatus.CREATED.value())
			.extract().as(Card.class);		
		}
}
