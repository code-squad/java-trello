package codesquad.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import codesquad.domain.Card;
import codesquad.domain.Deck;
import codesquad.domain.DeckRepository;

@Service("deckService")
public class DeckService {
	@Resource(name = "deckRepository")
	private DeckRepository deckRepository;

	public Deck getDeck(long deckId) {
		return deckRepository.getOne(deckId);
	}

	public void addCard(long deckId, Card card) {
		Deck deck = deckRepository.getOne(deckId);
		deck.addCard(card);
		deckRepository.save(deck);
	}
}
