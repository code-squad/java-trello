package codesquad.web.api;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codesquad.domain.Card;
import codesquad.domain.Deck;
import codesquad.service.CardService;
import codesquad.service.DeckService;

@RestController
@RequestMapping("/api/card")
public class ApiCardController {
	@Resource(name="deckService")
	private DeckService deckService;
	@Resource(name="cardService")
	private CardService cardService;
	
	@PostMapping("/{deckId}")
	public ResponseEntity<Card> create(@RequestBody Card card, @PathVariable long deckId) {
		Deck deck = deckService.getDeck(deckId);
		card = cardService.create(card);
		deckService.addCard(deckId, card);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Card>(card, headers, HttpStatus.CREATED);
	}
}
