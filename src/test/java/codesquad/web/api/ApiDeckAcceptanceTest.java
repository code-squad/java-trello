package codesquad.web.api;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import codesquad.domain.Deck;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiDeckAcceptanceTest {
	private static final Logger log = LoggerFactory.getLogger(ApiDeckAcceptanceTest.class);

	@Value("${local.server.port}")
	private int serverPort;

	@Before
	public void setup() {
		RestAssured.port = serverPort;
	}
	
	@Test
	public void create() {
		Deck deck = new Deck();
		deck.setName("newDeck");
		given()
			.contentType(ContentType.JSON)
			.body(deck)
		.when()
			.post("/api/deck/1")
		.then()
			.statusCode(HttpStatus.CREATED.value())
			.extract().as(Deck.class);		
		}
}
