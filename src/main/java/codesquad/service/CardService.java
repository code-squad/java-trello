package codesquad.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import codesquad.domain.Card;
import codesquad.domain.repository.CardRepository;

@Service("cardService")
public class CardService {
	@Resource(name = "cardRepository")
	private CardRepository cardRepository;
	
	public Card create(Card card) {
		return cardRepository.save(card);
	}
}
