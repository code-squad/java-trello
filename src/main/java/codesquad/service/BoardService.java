package codesquad.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import codesquad.domain.Board;
import codesquad.domain.BoardRepository;
import codesquad.domain.Deck;

@Service("boardService")
public class BoardService {
	@Resource(name = "boardRepository")
	private BoardRepository boardRepository;

	public Board create(Board board) {
		return boardRepository.save(board);
	}

	public void addDeck(long boardId, Deck dbDeck) {
		Board board = boardRepository.getOne(boardId);
		board.addDeck(dbDeck);
		boardRepository.save(board);
	}
}
