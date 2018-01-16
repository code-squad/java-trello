package codesquad.web.api;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codesquad.domain.Board;
import codesquad.domain.BoardRepository;
import codesquad.domain.User;
import codesquad.domain.UserRepository;
import codesquad.dto.BoardDto;
import codesquad.security.LoginUser;
import codesquad.service.BoardService;
import codesquad.service.UserService;

@RestController
@RequestMapping("/api/boards")
public class ApiBoardsController {
	private static final Logger log = LoggerFactory.getLogger(ApiBoardsController.class);
	@Resource(name = "boardsService")
	private BoardService boardService;
	@Resource(name = "userService")
	private UserService userService;
	@Resource(name = "userRepository")
	private UserRepository userRepository;
	@Resource(name = "boardRepository")
	private BoardRepository boardRepository;

	// 현재 미사용. ajax기반으로 만들게 되면 사용 가능 할듯
	@GetMapping("")
	public ResponseEntity<List<Board>> show(@LoginUser User user) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<Board>>(userService.getBoards(user), headers, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<BoardDto> createBoard(@LoginUser User user, @RequestBody BoardDto boardsDto) {
		User dbUser = userRepository.getOne(user.getId());
		Board board = boardService.create(boardsDto.getBoardName(), dbUser);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<BoardDto>(board.toBoardDto(), headers, HttpStatus.CREATED);
	}
}
