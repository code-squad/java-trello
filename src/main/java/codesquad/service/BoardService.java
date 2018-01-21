package codesquad.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import codesquad.domain.Board;
import codesquad.domain.Deck;
import codesquad.domain.repository.BoardRepository;
import codesquad.domain.repository.DeckRepository;

@Service("boardService")
public class BoardService {
	@Resource(name = "boardRepository")
	private BoardRepository boardRepository;
	
	@Resource(name="deckRepository")
	private DeckRepository deckRepository;

	public Board create(Board board) {
		return boardRepository.save(board);
	}

	public Deck addDeck(long boardId, Deck deck) {
		Deck dbDeck = deckRepository.save(deck);
		Board board = boardRepository.getOne(boardId);
		board.addDeck(dbDeck);
		boardRepository.save(board);
		return dbDeck;
	}

	public Board getBoard(long bId) {
		return boardRepository.getOne(bId);
	}

}
