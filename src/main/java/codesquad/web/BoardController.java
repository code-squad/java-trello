package codesquad.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import codesquad.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Resource(name="boardService")
	private BoardService boardService;
	
	@GetMapping("/{boardId}")
	public String board(@PathVariable long boardId,Model model) {
		model.addAttribute("boardId",boardId);
		model.addAttribute("decks", boardService.getDecks(boardId));
		return "/board";
	}
}
