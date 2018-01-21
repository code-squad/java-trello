package codesquad.web.api;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codesquad.domain.Board;
import codesquad.domain.Member;
import codesquad.security.LoginUser;
import codesquad.service.BoardService;
import codesquad.service.MemberService;

@RestController
@RequestMapping("/api/boards")
public class ApiBoardController {
	private static final Logger log = LoggerFactory.getLogger(ApiBoardController.class);
	
	@Resource(name = "boardService")
	private BoardService boardService;
	
	@Resource(name = "memberService")
	private MemberService memberService;

	// 현재 미사용. ajax기반으로 만들게 되면 사용 가능 할듯
	@GetMapping("")
	public ResponseEntity<List<Board>> show(@LoginUser Member member) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<Board>>(memberService.getBoards(member), headers, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Board> createBoard(Authentication authentication, @RequestBody Board board) {
		Member dbMember = memberService.getDbMemberByEmail(authentication.getName());
		Board dbBoard = boardService.create(board);
		memberService.addBoard(dbMember, board);
		return new ResponseEntity<Board>(dbBoard, new HttpHeaders(), HttpStatus.CREATED);
	}
}
