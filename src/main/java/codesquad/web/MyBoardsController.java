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
public class MyBoardsController {
	private static final Logger log = LoggerFactory.getLogger(MyBoardsController.class);
	@Resource(name = "userService")
	private UserService userService;

	@GetMapping("/myboards")
	public String board(@LoginUser User user, Model model) {
		model.addAttribute("boards", userService.getBoards(user));
		return "/boards";
	}
}
