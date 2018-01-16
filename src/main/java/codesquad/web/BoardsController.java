package codesquad.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import codesquad.domain.User;
import codesquad.security.LoginUser;
import codesquad.service.UserService;

@Controller
public class BoardsController {
	private static final Logger log = LoggerFactory.getLogger(BoardsController.class);
	@Resource(name = "userService")
	private UserService userService;
	
	@GetMapping("/boards")
	public String board(@LoginUser User user, Model model) {
		log.error("보드 목록");
		log.error("보드 목록 : {}",userService.getBoards(user));
		log.error("보드 사이즈 : {}",userService.getBoards(user).size());
		model.addAttribute("boards", userService.getBoards(user));
		return "/boards";
	}
}
