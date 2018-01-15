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
import codesquad.domain.Member;
import codesquad.dto.BoardsDto;
import codesquad.service.BoardService;
import codesquad.service.MemberService;

@RestController
@RequestMapping("/api/boards")
public class ApiBoardsController {
	private static final Logger log = LoggerFactory.getLogger(ApiBoardsController.class);
	@Resource(name = "boardsService")
	private BoardService boardService;

	@Resource(name = "memberService")
	private MemberService memberService;

	@PostMapping("")
	public ResponseEntity<BoardsDto> createBoard(@RequestBody BoardsDto boardsDto) {
		Member member = memberService.create(boardsDto.getUserId());
		Board board = boardService.create(boardsDto.getBoardName(), member.getId());
		boardsDto.setBoardId(board.getId());
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<BoardsDto>(boardsDto, headers, HttpStatus.CREATED);
	}

}
