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
	
	@GetMapping("/{bId}")
	public String board(@PathVariable long bId,Model model) {
		model.addAttribute("board", boardService.getBoard(bId));
		return "/board";
	}
}
