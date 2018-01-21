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
import codesquad.domain.repository.DeckRepository;
import codesquad.service.BoardService;
import codesquad.service.DeckService;

@RestController
@RequestMapping("/api/boards")
public class ApiDeckController {
	@Resource(name="boardService")
	private BoardService boardService;
	
	@PostMapping("/{boardId}/decks")
	public ResponseEntity<Deck> create(@PathVariable long boardId, @RequestBody Deck deck){
		Deck dbDeck = boardService.addDeck(boardId, deck);
		return new ResponseEntity<Deck>(dbDeck, new HttpHeaders(), HttpStatus.CREATED);
	}
	
}
