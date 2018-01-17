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

import codesquad.domain.Deck;
import codesquad.domain.DeckRepository;
import codesquad.service.BoardService;

@RestController
@RequestMapping("/api/deck")
public class ApiDeckController {
	@Resource(name="boardService")
	private BoardService boardService;
	@Resource(name="deckRepository")
	private DeckRepository deckRepository;
	
	@PostMapping("/{bId}")
	public ResponseEntity<Deck> create(@PathVariable long bId, @RequestBody Deck deck){
		System.out.println("here here");
		Deck dbDeck = deckRepository.save(deck);
		boardService.addDeck(bId, dbDeck);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Deck>(dbDeck, headers, HttpStatus.CREATED);
	}
	
}
