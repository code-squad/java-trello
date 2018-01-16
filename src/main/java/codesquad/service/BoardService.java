package codesquad.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import codesquad.domain.Board;
import codesquad.domain.BoardRepository;
import codesquad.domain.User;
import codesquad.domain.UserRepository;

@Service("boardsService")
public class BoardService {
	@Resource(name = "boardRepository")
	private BoardRepository boardRepository;
	@Resource(name = "userRepository")
	private UserRepository userRepository;

	public Board create(String boardName, User user) {
//		Board board = boardRepository.save(new Board(boardName));
		Board board = boardRepository.save(new Board(boardName, user));
//		board.addUser(user);
//		user.addBoard(board);
//		boardRepository.save(board);
//		userRepository.save(user);
		return board;
	}
}
