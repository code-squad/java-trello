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
import codesquad.domain.User;
import codesquad.security.LoginUser;
import codesquad.service.BoardService;
import codesquad.service.UserService;

@RestController
@RequestMapping("/api/boards")
public class ApiBoardsController {
	private static final Logger log = LoggerFactory.getLogger(ApiBoardsController.class);
	@Resource(name = "boardService")
	private BoardService boardService;
	@Resource(name = "userService")
	private UserService userService;

	// 현재 미사용. ajax기반으로 만들게 되면 사용 가능 할듯
	@GetMapping("")
	public ResponseEntity<List<Board>> show(@LoginUser User user) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<Board>>(userService.getBoards(user), headers, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Board> createBoard(@LoginUser User user, @RequestBody Board board) {
		User dbUser = userService.getDbUser(user);
		Board dbBoard = boardService.create(board);
		userService.addBoard(dbUser, board);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Board>(dbBoard, headers, HttpStatus.CREATED);
	}
}
