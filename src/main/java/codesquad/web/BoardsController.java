package codesquad.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardsController {

	@GetMapping("/boards")
	public String board() {
		return "/boards";
	}
}
