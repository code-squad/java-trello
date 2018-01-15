package codesquad.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import codesquad.domain.Board;
import codesquad.domain.BoardRepository;

@Service("boardsService")
public class BoardService {
	@Resource(name = "boardRepository")
	private BoardRepository boardRepository;

	public Board create(String boardName, long membersId) {
		return boardRepository.save(new Board(boardName, membersId));
	}

}
