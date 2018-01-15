package codesquad.web.api;

import static io.restassured.RestAssured.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import codesquad.dto.BoardsDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiBoardsAcceptanceTest {
	private static final Logger log = LoggerFactory.getLogger(ApiBoardsAcceptanceTest.class);
	
	@Value("${local.server.port}")
	private int serverPort;

	@Before
	public void setup() {
		RestAssured.port = serverPort;
	}
	//auth(). preemptive().basic("username", "password") 
	@Test
	public void createBoard() {
		BoardsDto boardsDto = new BoardsDto("newBoard");
		given()
			.auth()
			.preemptive()
			.basic("hue@korea.kr","password")
			.contentType(ContentType.JSON)
			.body(boardsDto)
			.when()
			.post("/api/boards")
			.then()
			.statusCode(HttpStatus.CREATED.value())
			.extract().as(BoardsDto.class);		
	}
	//	@Test
//	public void createBoard() {
//		BoardsDto boardsDto = new BoardsDto("newBoard");
//		given()
//			.contentType(ContentType.JSON)
//			.body(boardsDto)
//			.when()
//			.post("/api/boards")
//			.then()
//			.statusCode(HttpStatus.CREATED.value())
//			.extract().as(BoardsDto.class);		
//	}
}
