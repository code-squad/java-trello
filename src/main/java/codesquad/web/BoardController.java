package codesquad.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import codesquad.service.BoardService;

@Controller
@RequestMapping("/boards")
public class BoardController {
	@Resource(name="boardService")
	private BoardService boardService;
	
	@GetMapping("/{id}")
	public String board(@PathVariable long id,Model model) {
		model.addAttribute("board", boardService.getBoard(id));
		return "/board";
	}
}
