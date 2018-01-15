package codesquad.web.api;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codesquad.domain.Board;
import codesquad.domain.Members;
import codesquad.domain.User;
import codesquad.dto.BoardsDto;
import codesquad.security.LoginUser;
import codesquad.service.BoardService;
import codesquad.service.MembersService;

@RestController
@RequestMapping("/api/boards")
public class ApiBoardsController {
	private static final Logger log = LoggerFactory.getLogger(ApiBoardsController.class);
	@Resource(name = "boardsService")
	private BoardService boardService;

	@Resource(name = "membersService")
	private MembersService membersService;

//	@PostMapping("")
//	public ResponseEntity<BoardsDto> createBoard(@RequestBody BoardsDto boardsDto) {
//		Member member = memberService.create(boardsDto.getUserId());
//		Board board = boardService.create(boardsDto.getBoardName(), member.getId());
//		boardsDto.setBoardId(board.getId());
//		HttpHeaders headers = new HttpHeaders();
//		return new ResponseEntity<BoardsDto>(boardsDto, headers, HttpStatus.CREATED);
//	}
//	
	@PostMapping("")
	public ResponseEntity<BoardsDto> createBoard(@LoginUser User user, @RequestBody BoardsDto boardsDto) {
//		Member member = memberService.create(user.getId());
		log.error("create members before");
		Members members = membersService.create(user);
		log.error("create members after");
		Board board = boardService.create(boardsDto.getBoardName(), members.getId());
		boardsDto.setBoardId(board.getId());
		HttpHeaders headers = new HttpHeaders();
		log.error("done");
		return new ResponseEntity<BoardsDto>(boardsDto, headers, HttpStatus.CREATED);
	}

}
